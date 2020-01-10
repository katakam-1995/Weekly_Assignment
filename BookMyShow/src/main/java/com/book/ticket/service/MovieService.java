
package com.book.ticket.service;

import java.util.List;
import java.util.Map;

import com.book.ticket.model.Movies;
import com.book.ticket.vo.InputVO;

public interface MovieService {

	List<Movies> getmovieList();

	InputVO showavailableScreenandTimings();

	void savingMovie(InputVO vo) throws Exception;

	void deleteMovie(InputVO vo) throws Exception;

	Map<String, List<String>> showAvailScreen(InputVO vo);

	InputVO showAvailableSeats(InputVO vo);

	void saveseat();

	InputVO saveUserDetails(InputVO vo) throws Exception;

	InputVO getAuthorizedUser(InputVO vo);

	// List<MovieScreenAlloted> showAvailablewithScreens(InputVO vo);

}
