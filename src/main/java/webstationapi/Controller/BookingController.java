package webstationapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webstationapi.Entity.Booking;
import webstationapi.Entity.Course;
import webstationapi.Service.BookingService;
import webstationapi.Service.CourseService;

@RestController
@RequestMapping(path = "/booking")
@EnableAutoConfiguration
public class BookingController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping(path = "/book")
    public void book(@RequestParam int userId, @RequestParam int courseId) {
		Course course = courseService.getCourseById(courseId).orElseThrow(InternalError::new);
		if (course != null) {
			Booking booking = new Booking();
			booking.setUserId(userId);
			booking.setCourse(course);
			bookingService.createBooking(booking);
		}
	}
	
}
