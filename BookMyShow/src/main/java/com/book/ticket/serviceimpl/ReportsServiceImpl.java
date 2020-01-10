package com.book.ticket.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.ticket.model.UserDetails;
import com.book.ticket.repository.UserDetailsRepository;

@Service
public class ReportsServiceImpl {

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	public String getFile(String ticket) {
		return "jasper\\" + ticket;
	}

	private String selectedSeats = null;
	private String seats = "";

	@SuppressWarnings("unlikely-arg-type")
	public Map<String, Object> generateBookMyShowTicket(Long userId) {
		Map<String, Object> parameters = new HashMap<>();

		Optional<UserDetails> userDetails = userDetailsRepository.findById(userId);

		parameters.put("BOOKING_ID", userDetails.get().getUserId().toString());
		parameters.put("MOVIE_NAME", userDetails.get().getMovieName());
		parameters.put("DATE", userDetails.get().getSelectedDate().toString());
		parameters.put("TIME", userDetails.get().getSelectedTiming());
		Map<String, List<String>> selectedrows = userDetails.get().getSelectedSeats();
		List<String> noOfSeats = new ArrayList<String>();
		Set<String> keys = selectedrows.keySet();
		if (!selectedrows.isEmpty()) {
			selectedrows.forEach((k, v) -> {
				noOfSeats.add(k + " : " + v + "\n");
			});
		}
		if (!noOfSeats.isEmpty()) {

			noOfSeats.forEach(u -> {
				seats += u + "\n";
			});

		}
		parameters.put("SEATS", seats);
		parameters.put("SCREEN_NAME", userDetails.get().getSelectedScreen());
		parameters.put("MOVIE_IMAGE", userDetails.get().getMovieImage().toString());
		parameters.put("QRCODE_IMAGE", userDetails.get().getMovieImage());

		return parameters;
	}

}
