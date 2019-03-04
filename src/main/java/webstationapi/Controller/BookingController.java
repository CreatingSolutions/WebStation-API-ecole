package webstationapi.Controller;

import java.sql.Date;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webstationapi.Entity.Booking;

@RestController
@RequestMapping(path = "/booking")
@EnableAutoConfiguration
public class BookingController {

	@PostMapping(path = "/book")
    public void removeElement(@RequestParam int userId, @RequestParam Date courseDate, @RequestParam int startingHour, @RequestParam int courseId) {
		Booking booking = new Booking();
		booking.setUserId(userId);
		
		//MAPPING TODO
	}
	
}
