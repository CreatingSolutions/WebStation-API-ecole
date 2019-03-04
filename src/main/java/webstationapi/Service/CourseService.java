package webstationapi.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webstationapi.Entity.Booking;
import webstationapi.Entity.Course;
import webstationapi.Repository.BookingRepository;
import webstationapi.Repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private BookingRepository bookingRepository;	
	
	public List<Course> getAvailableCourses() {
		List<Booking> bookings = StreamSupport.stream(bookingRepository.findAll().spliterator(), false).collect(Collectors.toList());
		Map<Integer, Long> sumByCourse = bookings.stream().map(booking -> booking.getCourse()).collect(Collectors.groupingBy(Course::getCourseId, Collectors.counting()));
		
		List<Course> result = new ArrayList<Course>();
		return StreamSupport.stream(courseRepository.findAll().spliterator(), false).filter(course -> course.getNbCustomersMax() > sumByCourse.get(course)).collect(Collectors.toList());
	}
	
}
