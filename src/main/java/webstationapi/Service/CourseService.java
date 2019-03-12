package webstationapi.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webstationapi.Entity.Booking;
import webstationapi.Entity.Course;
import webstationapi.Entity.DayMoment;
import webstationapi.Entity.Pack;
import webstationapi.Entity.Period;
import webstationapi.Repository.BookingRepository;
import webstationapi.Repository.CourseRepository;
import webstationapi.Repository.PeriodRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private PeriodRepository periodRepository;
	
	public List<Course> getAvailableCourses(int periodId, DayMoment moment) {
		Period period = periodRepository.findById(periodId).orElseThrow(IllegalArgumentException::new);
		List<Course> courses = courseRepository.findByPeriodAndMoment(period, moment);
		
		List<Booking> bookings = StreamSupport.stream(bookingRepository.findByCourseIn(courses).spliterator(), false).collect(Collectors.toList());
		Map<Integer, Long> sumByCourse = bookings.stream().map(booking -> booking.getCourse()).collect(Collectors.groupingBy(Course::getCourseId, Collectors.counting()));
		
		return courses.stream().filter(course -> course.getNbCustomersMax() > sumByCourse.get(course.getCourseId())).collect(Collectors.toList());
	}
	
	public int countAvailableCourseSlots(int periodId, DayMoment moment) {
		return 1;
	}
	
	public Optional<Course> getCourseById(int courseId) {
		return courseRepository.findById(courseId);
	}
	
	public List<Course> getCourseByPack(Pack pack) {
		return new ArrayList<Course>();
	}
	
}
