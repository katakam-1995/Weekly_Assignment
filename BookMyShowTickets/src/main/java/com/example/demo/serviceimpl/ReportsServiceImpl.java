package com.example.demo.serviceimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ReportConstants;
import com.example.demo.Model.UserDetails;
import com.example.demo.repository.UserDetailsRepository;

@Service
public class ReportsServiceImpl {

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Autowired
	private ResourceLoader resourceLoader;

	public String getFile(String ticket) {
		return "jasper\\" + ticket;
	}

	private String seats = "";

	public Map<String, Object> generateBookMyShowTicket(Long userId) {
		Map<String, Object> parameters = new HashMap<>();

		Optional<UserDetails> userDetails = userDetailsRepository.findById(userId);

		parameters.put("BOOKING_ID", userDetails.get().getUserId().toString());
		parameters.put("MOVIE_NAME", userDetails.get().getMovieName().toUpperCase());
		parameters.put("DATE", userDetails.get().getSelectedDate().toString());
		parameters.put("TIME", userDetails.get().getSelectedTiming());
		Map<String, String> selectedrows = userDetails.get().getSelectedSeats();
		List<String> noOfSeats = new ArrayList<String>();
		if (!selectedrows.isEmpty()) {
			selectedrows.forEach((k, v) -> {
				noOfSeats.add(k + " : " + v);
			});
		}
		System.out.println(seats + "Start");
		if (!noOfSeats.isEmpty()) {

			noOfSeats.forEach(u -> {
				seats += u + "\n";
			});

		}

		System.out.println(seats + "End");
		parameters.put("SEATS", seats);
		parameters.put("SCREEN_NAME", userDetails.get().getSelectedScreen());
		parameters.put("MOVIE_IMAGE", userDetails.get().getMovieImage().toString());
		parameters.put("TOTAL_AMOUNT", userDetails.get().getTotalamount().toString());
		parameters.put("QRCODE_IMAGE", getImages(ReportConstants.QRCODEIMAGE));
		seats = "";
		return parameters;
	}

	private String getImages(String image) {
		String apLogo = "";
		Resource resource = resourceLoader.getResource("classpath:" + "images\\" + image);
		String encodstring = null;
		try {
			encodstring = encodeFileToBase64Binary(resource.getFile());
			return apLogo = encodstring;
		} catch (IOException e) {
			e.printStackTrace();
			return apLogo;
		}
	}

	private static String encodeFileToBase64Binary(File file) {
		String encodedfile = null;
		FileInputStream fileInputStreamReader = null;
		try {
			fileInputStreamReader = new FileInputStream(file);
			byte bytes[] = new byte[(int) file.length()];
			fileInputStreamReader.read(bytes);
			encodedfile = Base64.encodeBase64URLSafeString(bytes);
			return encodedfile;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileInputStreamReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return encodedfile;
	}
}
