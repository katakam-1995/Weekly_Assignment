package com.example.demo.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.demo.repository.SequenceDao;
import com.example.demo.Model.AvailableSeatsDTO;
import com.example.demo.Model.InputVO;
import com.example.demo.Model.Movies;
import com.example.demo.Model.SequenceId;
import com.example.demo.Model.UserDTO;
import com.example.demo.Service.MovieService;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AvailableSeats;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.UserRepository;

@Service
public class MovieServiceImpl implements MovieService,SequenceDao {
	private static final String MOVIE_SEQ_KEY = "MOVIE";

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private AvailableSeats availableSeatsRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MongoOperations mongoOperation;

	@Autowired
	private SequenceDao sequenceDao;

	@Override
	public List<Movies> getmovieList() {
		List<Movies> list = movieRepository.findAll();
		return list;
	}

	public InputVO getAuthorizedUser(InputVO vo) {
		Optional<UserDTO> user = userRepository.findByUserName(vo.getUserName());
		if (user != null && user.get().getPassword().equalsIgnoreCase(vo.getPassword())) {
			vo.setUserName(user.get().getUserName());
			vo.setPassword(user.get().getPassword());
			vo.setRole(user.get().getRole());
			vo.setLogin(true);
		}
		return vo;
	}
	
	@Override
	public long getNextSequenceId(String key) throws ResourceNotFoundException {
		
	  Query query = new Query(Criteria.where("_id").is(key));
	  Update update = new Update();
	  update.inc("seq", 1);
	  FindAndModifyOptions options = new FindAndModifyOptions();
	  options.returnNew(true);
	  SequenceId seqId = 
            mongoOperation.findAndModify(query, update, options, SequenceId.class);
	  if (seqId == null) {
		throw new ResourceNotFoundException("Unable to get sequence id for key : " + key);
	  }

	  return seqId.getSeq();

	}
	
	public void save() throws ResourceNotFoundException {

		Movies mov = new Movies();

		mov.setId(sequenceDao.getNextSequenceId(MOVIE_SEQ_KEY));
		mov.setMovieContent("ghhfgvhjgjhgjhk");
		mov.setMovieImage("tfhgfvgh");
		mov.setMovieName("hghvh");
		mov.setStatus("true");
		movieRepository.save(mov);

		System.out.println(mov);

	}

	public InputVO getAvailableSeatsDetails(InputVO vo) {
		Optional<AvailableSeatsDTO> availableSeats=availableSeatsRepository.findByScreenNameAndScreenTiming(vo.getScreenName(),vo.getScreenTiming());
		
		Map<String, List<String>> avlbList= new HashMap<String, List<String>>();
		/*Map<String, Map<String, List<String>>> testMap = 
				availableSeats.get().getRows().stream().collect(Collectors.groupingBy(AvailableSeatsDTO::getScreenName,
			                                       Collectors.groupingBy(AvailableSeatsDTO::getObjectName,
			                                                             Collectors.mapping(::getSeats,*/
		availableSeats.get().getRows().stream().forEach( r -> {
			//r.entrySet().iterator().
		});
		return vo;
		
		
	}

	


}
