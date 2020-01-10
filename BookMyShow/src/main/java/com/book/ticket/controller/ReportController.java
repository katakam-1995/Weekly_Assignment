package com.book.ticket.controller;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.ticket.model.ReportConstants;
import com.book.ticket.serviceimpl.ReportsServiceImpl;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@CrossOrigin
@RestController
@RequestMapping("/reports")
public class ReportController {

	@Autowired
	private ResourceLoader resourceLoader;

	@Autowired
	private ReportsServiceImpl reportsServiceImpl;

	@GetMapping(value = "/generateBookMyShowTicket")
	public ResponseEntity<String> generateBookMyShowTicket(HttpServletResponse response, @RequestParam Long userId)
			throws Exception {
		File file = null;
		InputStream is = null;
		try {
			Resource resource = resourceLoader
					.getResource("classpath:" + reportsServiceImpl.getFile(ReportConstants.TICKET));
			file = resource.getFile();
			is = new FileInputStream(file);
		} catch (IOException e) {
			IOUtils.closeQuietly(is);
			throw new Exception("NOT FOUND");
		}
		try {
			Map<String, Object> parameters = reportsServiceImpl.generateBookMyShowTicket(userId);
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(is);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
			response.setContentType("application/x-pdf");
			response.setHeader("Content-disposition", "inline; filename=" + ".pdf");
			final OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

		} catch (Exception ex) {
			throw new Exception("Bad Request");
		} finally {
			IOUtils.closeQuietly(is);
		}
		return null;
	}
}
