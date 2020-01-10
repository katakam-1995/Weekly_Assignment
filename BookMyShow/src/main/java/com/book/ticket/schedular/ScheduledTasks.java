package com.book.ticket.schedular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.book.ticket.service.MovieService;

@Component
public class ScheduledTasks {

	@Autowired
	private MovieService movieService;

	// at 12:00 AM every day
	@Scheduled(cron = "0 0 0 * * ?")
	@Scheduled(cron = "*/10 * * * * *")
	public void scheduleTaskWithCronExpression() {
		System.out.println(" scheduled tasks");
		movieService.saveseat();

	}

}
