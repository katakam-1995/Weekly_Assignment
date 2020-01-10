package com.otsi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.otsi.model.CouchbaseEmployee;
import com.otsi.model.Employee;
import com.otsi.model.EmployeeVO;
import com.otsi.repository.CouchBaseRepository;
import com.otsi.repository.MySqlDao;
import com.otsi.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private MySqlDao employeeDao;

	@Autowired
	private CouchBaseRepository couchBaseRepository;

	@Autowired
	private RestTemplate restTemplate;

	List<Employee> employeeList = new ArrayList<>();

	private static final String url_1 = "http://localhost:8000/RestComplete/complete";

	private static final String url_2 = "http://localhost:8001/restError/error";

	private static final String url_3 = "http://localhost:8002/RestResolve/resolve";

	private ResponseEntity<String> restStatus = null;

	int count = 0;

	@Override
	public List<EmployeeVO> saveEmployeeDetails(List<EmployeeVO> empVo) {
		List<EmployeeVO> empList = new ArrayList<>();
		List<Employee> dtoList = new ArrayList<>();
		empVo.forEach(e -> {
			Employee dto = new Employee();
			dto.setId(e.getId());
			dto.setName(e.getName());
			dto.setAge(e.getAge());
			dto.setAddress(e.getAddress());
			dto.setStatus(e.getStatus());
			dto.setRest_id(e.getRest_id());
			dtoList.add(dto);
		});

		List<Employee> list = employeeDao.saveAll(dtoList);

		list.forEach(e -> {
			EmployeeVO vo = new EmployeeVO();
			vo.setId(e.getId());
			vo.setName(e.getName());
			vo.setAge(e.getAge());
			vo.setAddress(e.getAddress());
			vo.setStatus(e.getStatus());
			vo.setRest_id(e.getRest_id());
			empList.add(vo);
		});

		return empList;

		// return saveEmployeeDataInCouchBase(empList);
	}

	public List<EmployeeVO> saveEmployeeDataInCouchBase(List<EmployeeVO> empVo) {
		List<EmployeeVO> empList = new ArrayList<>();
		List<CouchbaseEmployee> dtoList = new ArrayList<>();
		empVo.forEach(e -> {
			CouchbaseEmployee dto = new CouchbaseEmployee();
			dto.setId(e.getId());
			dto.setName(e.getName());
			dto.setAge(e.getAge());
			dto.setAddress(e.getAddress());
			dto.setStatus(e.getStatus());
			dto.setRest_id(e.getRest_id());
			dtoList.add(dto);
		});

		List<CouchbaseEmployee> list = (List<CouchbaseEmployee>) couchBaseRepository.saveAll(dtoList);

		list.forEach(e -> {
			EmployeeVO vo = new EmployeeVO();
			vo.setId(e.getId());
			vo.setName(e.getName());
			vo.setAge(e.getAge());
			vo.setAddress(e.getAddress());
			vo.setStatus(e.getStatus());
			vo.setRest_id(e.getRest_id());
			empList.add(vo);
		});
		return empList;
	}

	public void executeEmployee(List<Employee> employee) throws InterruptedException {
		ScheduledExecutorService ex = Executors.newSingleThreadScheduledExecutor();

		Runnable r = new Runnable() {

			@Override
			public void run() {
				ExecutorService executorService = (ExecutorService) Executors.newFixedThreadPool(1);
				List<Callable<Employee>> list = new ArrayList<>();
				List<Future<Employee>> resultList;

				employee.forEach(r -> list.add(() -> findEmployees(r)));
				try {
					resultList = executorService.invokeAll(list);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		};
		ex.schedule(r, 1, TimeUnit.SECONDS);

	}

	public void getAllEmployeeDetailsStatus(String status) throws InterruptedException {
		employeeList = employeeDao.findByStatus(status);
		executeEmployee(employeeList);
	}

	public Employee findEmployees(Employee emp) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity requestEntity = new HttpEntity<>(headers);
		if (emp.getRest_id() == 1) {
			restStatus = restTemplate.exchange(url_1, HttpMethod.GET, requestEntity, String.class);
		} else if (emp.getRest_id() == 2) {
			restStatus = restTemplate.exchange(url_2, HttpMethod.GET, requestEntity, String.class);

		} else if (emp.getRest_id() == 3) {
			restStatus = restTemplate.exchange(url_3, HttpMethod.GET, requestEntity, String.class);
		}
		emp.setStatus(restStatus.getBody().toString());
		employeeDao.save(emp);
		CouchbaseEmployee CouchbaseEmployee = new CouchbaseEmployee();
		CouchbaseEmployee.setId(emp.getId());
		CouchbaseEmployee.setName(emp.getName());
		CouchbaseEmployee.setAge(emp.getAge());
		CouchbaseEmployee.setAddress(emp.getAddress());
		CouchbaseEmployee.setRest_id(emp.getRest_id());
		CouchbaseEmployee.setStatus(emp.getStatus());
		couchBaseRepository.save(CouchbaseEmployee);

		return emp;
	}
}
