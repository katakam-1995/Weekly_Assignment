package com.book.ticket.serviceimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.book.ticket.model.AvailableSeats;
import com.book.ticket.model.MovieScreenAlloted;
import com.book.ticket.model.Movies;
import com.book.ticket.model.Screens;
import com.book.ticket.model.UserDTO;
import com.book.ticket.model.UserDetails;
import com.book.ticket.repository.AvailableSeatsRepo;
import com.book.ticket.repository.MovieRepository;
import com.book.ticket.repository.MovieScreenAllotedRepo;
import com.book.ticket.repository.ScreenRepository;
import com.book.ticket.repository.UserDetailsRepo;
import com.book.ticket.repository.UserRepository;
import com.book.ticket.service.MovieService;
import com.book.ticket.service.Sequence;
import com.book.ticket.vo.InputVO;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private Sequence sequence;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScreenRepository screenRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private MovieScreenAllotedRepo movieScreenAllotedRepo;

	@Autowired
	private AvailableSeatsRepo availableSeatsRepo;

	@Autowired
	private UserDetailsRepo userDetailsRepo;

	private static final String MOVIE_SEQ_KEY = "MOVIE";

	@Override
	public List<Movies> getmovieList() {
		List<Movies> list = (List<Movies>) movieRepository.findByStatus("open");

		return list;
	}

	@Override
	public InputVO showavailableScreenandTimings() {
		InputVO vo = new InputVO();
		List<String> tim = new ArrayList<>();
		Map<String, List<String>> timings = new HashMap<>();
		Map<String, String> screens = new HashMap();
		List<Screens> screenDetails = screenRepository.findByScreenStatus("open");
		screenDetails = screenDetails.stream().filter(
				u -> (!StringUtils.isEmpty(u.getCount()) && u.getCount() < 3) || StringUtils.isEmpty(u.getCount()))
				.collect(Collectors.toList());
		screenDetails.forEach(u -> {
			screens.put(u.getScreenId(), u.getScreenName());

		});
		vo.setScreens(screens);
		screenDetails = screenDetails.stream()
				.filter(t -> (!CollectionUtils.isEmpty(t.getTimings()) && t.getTimings().size() <= 2)
						|| CollectionUtils.isEmpty(t.getTimings()))
				.collect(Collectors.toList());

		screenDetails.forEach(t -> {
			if (t.getTimings() != null) {
				if (!t.getTimings().contains("10:00")) {
					tim.add("10:00");
				}
				if (!t.getTimings().contains("2:00")) {
					tim.add("2:00");
				}
				if (!t.getTimings().contains("5:00")) {
					tim.add("5:00");
				}
			} else {
				tim.add("10:00");
				tim.add("2:00");
				tim.add("5:00");
			}
			timings.put(t.getScreenName(), tim);

		});
		vo.setTimings(timings);

		return vo;
	}

	@Override
	public void savingMovie(InputVO vo) throws Exception {

		Movies masterMve = new Movies();
		masterMve.setMovieName(vo.getMovieName());
		masterMve.setMovieContent(vo.getMovieContent());
		masterMve.setMovieImage(vo.getMovieImage());
		masterMve.setStatus("open");
		masterMve.setMovieId(sequence.getNextSequenceId(MOVIE_SEQ_KEY));
		Movies mveSave = movieRepository.save(masterMve);
		MovieScreenAlloted mveScreen = new MovieScreenAlloted();
		mveScreen.setMovieId(mveSave.getMovieId());
		mveScreen.setMovieName(mveSave.getMovieName());
		mveScreen.setScreenName(vo.getScreenName());
		mveScreen.setFromDate(vo.getFromdate());
		mveScreen.setToDate(vo.getTodate());
		mveScreen.setTiming(vo.getShowTimmings());
		// Screens masterScreen = new Screens();
		Screens masterScreen = screenRepository.findByScreenName(vo.getScreenName());
		if (masterScreen != null) {
			int i = vo.getShowTimmings().size();

			if (masterScreen.getCount() == 0) {
				masterScreen.setCount(i);
			} else {
				masterScreen.setCount(masterScreen.getCount() + i);
			}

			masterScreen.setTimings(vo.getShowTimmings());
		} else {
			throw new Exception("No screen found with " + vo.getScreenName());
		}
		movieScreenAllotedRepo.save(mveScreen);
		screenRepository.save(masterScreen);

	}

	@Override
	public void deleteMovie(InputVO vo) throws Exception {
		Movies mveDetails = null;
		mveDetails = movieRepository.findByMovieId(vo.getMovieId());
		if (mveDetails != null) {
			mveDetails.setStatus("closed");
			movieRepository.save(mveDetails);

			MovieScreenAlloted mveScreenDetails = movieScreenAllotedRepo.findByMovieId(mveDetails.getMovieId());
			if (mveScreenDetails != null) {
				Screens screenDetails = screenRepository.findByScreenName(mveScreenDetails.getScreenName());
				for (int i = 0; i < mveScreenDetails.getTiming().size(); i++) {
					for (int j = 0; j < screenDetails.getTimings().size(); j++) {
						if (mveScreenDetails.getTiming().get(i).equalsIgnoreCase(screenDetails.getTimings().get(j))) {
							// screenDetails.getTimings().set(j,"");
							screenDetails.getTimings().remove(j);
						}
					}
				}

				screenRepository.save(screenDetails);
			} else {
				throw new Exception("no movie allotted with the screen");
			}

		} else {
			throw new Exception("No movie found");
		}

	}

	@Override
	public Map<String, List<String>> showAvailScreen(InputVO vo) {
		Map<String, List<String>> screen = new HashMap<>();
		MovieScreenAlloted mveScreenAllot = movieScreenAllotedRepo.findByMovieId(vo.getMovieId());
		if (mveScreenAllot != null) {
			if (mveScreenAllot.getToDate() != null) {
				if (mveScreenAllot.getToDate().compareTo(vo.getDate()) <= 0) {
					System.out.println("jhkdd");
				}
			}
			screen.put(mveScreenAllot.getScreenName(), mveScreenAllot.getTiming());
		}
		return screen;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public InputVO showAvailableSeats(InputVO vo) {
		InputVO input = new InputVO();
		Optional<AvailableSeats> availSeats = availableSeatsRepo.findByScreenNameAndScreenTiming(vo.getScreenName(),
				vo.getSelectedTiming());

		Map<String, List<String>> mapSeries = new HashMap<String, List<String>>();
		Map<String, List<Integer>> map1 = new HashMap<String, List<Integer>>();
		List<Integer> li = new ArrayList<>();

		if (availSeats.isPresent()) {
			availSeats.get().getRows().forEach(r -> {
				r.forEach((k, v) -> {
					List<String> listOfSeat = new ArrayList<>();
					v.forEach(m -> {
						m.forEach((h, b) -> {
							if (b.equalsIgnoreCase("open")) {
								listOfSeat.add(h);
								int parseInt = Integer.parseInt(h);
								li.add(parseInt);
							}

						});
					});
					mapSeries.put(k, listOfSeat);
					map1.put(k, li);

				});

			});

		}
		input.setRowamount(availSeats.get().getRowamount());
		input.setRows(map1);
		Map<String, Integer> totalSeatsCount = new HashMap<>();
		Map<String, String> map = new HashMap<>();

		totalSeatsCount.put("A", 10);
		totalSeatsCount.put("B", 10);
		totalSeatsCount.put("C", 10);

		// totalSeatsCount.add(map);
		input.setTotalSeatsCount(totalSeatsCount);
		return input;

	}

	@Override
	public void saveseat() {
		AvailableSeats av = new AvailableSeats();
		av.setScreenName("Screen_1");
		av.setScreenTiming("2.00");
		List<Map<String, List<Map<String, String>>>> rows = new ArrayList<>();
		List<Map<String, String>> st = new ArrayList<>();
		Map<String, List<Map<String, String>>> s = new HashMap<>();
		Map<String, String> m = new HashMap<>();
		m.put("1", "open");
		m.put("2", "open");
		m.put("3", "open");
		st.add(m);
		s.put("A", st);
		rows.add(s);
		av.setRows(rows);
		List<Map<String, String>> rowamount = new ArrayList<>();
		Map<String, String> mm = new HashMap<>();

		mm.put("B", "50");
		mm.put("A", "100");
		rowamount.add(mm);
		av.setRowamount(mm);
		// av.setRowamount(rowamount);
		availableSeatsRepo.save(av);
	}

	@Override
	public InputVO saveUserDetails(InputVO vo) throws Exception {
		UserDetails userDet = new UserDetails();
		userDet.setUserId(sequence.getNextSequenceId(MOVIE_SEQ_KEY));
		userDet.setMovieId(vo.getMovieId());
		userDet.setMovieContent(vo.getMovieContent());
		userDet.setMovieImage(vo.getMovieImage());
		userDet.setMovieName(vo.getMovieName());
		userDet.setSelectedDate(vo.getDate());
		userDet.setSelectedTiming(vo.getSelectedTiming());
		userDet.setSelectedScreen(vo.getScreenName());
		Map<String, List<String>> selectedSeats = vo.getSelectedSeats();
		Optional<AvailableSeats> closingSeats = availableSeatsRepo.findByScreenNameAndScreenTiming(vo.getScreenName(),
				vo.getSelectedTiming());
		List<Map<String, List<Map<String, String>>>> rows = closingSeats.get().getRows();
		Set<String> keySet = vo.getSelectedSeats().keySet();
		Collection<List<String>> values = vo.getSelectedSeats().values();
		rows.stream().forEach(u -> {
			u.forEach((k, v) -> {
				keySet.stream().forEach(n -> {
					System.out.println(n + " " + k);
					System.out.println(vo.getSelectedSeats().get(n));
					if (n.equalsIgnoreCase(k)) {
						v.stream().forEach(j -> {
							j.forEach((k1, v1) -> {
								System.out.println(vo.getSelectedSeats().get(n) + "   " + k1);
								if (vo.getSelectedSeats().get(n).contains(k1)) {
									System.out.println("fsfsfs");
									j.put(k1, "close");
								}

							});
						});
					}
				});
			});
		});

		availableSeatsRepo.save(closingSeats.get());
		System.out.println(selectedSeats.get("A"));
		List<Integer> list = new ArrayList<>();
		selectedSeats.forEach((k, v) -> {
			int res = 0;
			System.out.println(k);
			if (k.equals("A")) {
				res = 100 * selectedSeats.get("A").size();
				System.out.println(res);
				list.add(res);
			} else if (k.equals("B")) {
				res = 100 * selectedSeats.get("B").size();
				list.add(res);

			} else if (k.equals("C")) {
				res = 50 * selectedSeats.get("C").size();
				list.add(res);

			}
		});

		double sum = 0;
		for (int i : list) {
			sum += i;
			System.out.println(sum);
		}

		userDet.setSelectedSeats(vo.getSelectedSeats());
		userDet.setTotalamount(sum);
		UserDetails save = userDetailsRepo.save(userDet);
		InputVO vo1 = new InputVO();
		vo1.setUserId(save.getUserId());
		return vo1;
	}

	@Override
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

}
