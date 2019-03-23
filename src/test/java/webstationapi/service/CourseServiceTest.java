package webstationapi.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import webstationapi.DTO.CourseDTO;
import webstationapi.Entity.Booking;
import webstationapi.Entity.Course;
import webstationapi.Entity.DayMoment;
import webstationapi.Entity.Period;
import webstationapi.Repository.BookingRepository;
import webstationapi.Repository.CourseRepository;
import webstationapi.Repository.PeriodRepository;
import webstationapi.Service.CourseService;

public class CourseServiceTest {

	@Test
	public void getByIdOnEmptyRepository() {
		CourseRepository repository = mock(CourseRepository.class);
		CourseService service = new CourseService();
		service.setCourseRepository(repository);

		Optional<Course> result = service.getCourseById(1);
		assertEquals(result.isPresent(), false);
	}

	@Test
	public void getByIdOnFilledRepository() {
		CourseRepository repository = mock(CourseRepository.class);
		CourseService service = new CourseService();
		service.setCourseRepository(repository);

		Course course = new Course();
		course.setCourseId(1);
		when(repository.findById(1)).thenReturn(Optional.of(course));

		Optional<Course> result = service.getCourseById(1);
		assertEquals(result.isPresent(), true);
		assertEquals(result.get(), course);
	}

	@Test
	public void getByMomentAndPeriod() {
		CourseRepository courseRepository = mock(CourseRepository.class);
		PeriodRepository periodRepository = mock(PeriodRepository.class);
		BookingRepository bookingRepository = mock(BookingRepository.class);
		CourseService service = new CourseService();
		service.setCourseRepository(courseRepository);
		service.setPeriodRepository(periodRepository);
		service.setBookingRepository(bookingRepository);

		Period period = new Period();
		DayMoment moment = DayMoment.MORNING;

		Course course1 = new Course();
		course1.setCourseId(1);
		Course course2 = new Course();
		course2.setCourseId(2);
		List<Course> courses = new ArrayList<Course>();
		courses.add(course1);
		courses.add(course2);
		when(bookingRepository.findByCourseIn(courses)).thenReturn(new ArrayList<Booking>());
		when(periodRepository.findById(1)).thenReturn(Optional.of(period));
		when(courseRepository.findByPeriodAndMoment(period, moment)).thenReturn(courses);

		List<CourseDTO> result = service.getCourses(1, moment);
		assertEquals(result.stream().filter(dto -> dto.getCourseId() == 1).findAny().isPresent(), true);
		assertEquals(result.stream().filter(dto -> dto.getCourseId() == 2).findAny().isPresent(), true);
		assertEquals(result.stream().filter(dto -> dto.getCourseId() == 3).findAny().isPresent(), false);
	}

}
