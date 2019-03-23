package webstationapi.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import webstationapi.Entity.Booking;
import webstationapi.Entity.Course;
import webstationapi.Repository.BookingRepository;
import webstationapi.Service.BookingService;

public class BookingServiceTest {

	@Test
	public void testUserIdByBooking() {
		BookingRepository repository = mock(BookingRepository.class);
		BookingService service = new BookingService();
		service.setBookingRepository(repository);

		Course course = new Course();
		course.setCourseId(1);
		Booking booking1 = new Booking();
		booking1.setUserId(1);
		booking1.setCourse(course);
		Booking booking2 = new Booking();
		booking2.setUserId(2);
		booking2.setCourse(course);
		Booking booking3 = new Booking();
		booking3.setUserId(3);
		booking3.setCourse(course);
		List<Booking> bookings = new ArrayList<Booking>();
		bookings.add(booking1);
		bookings.add(booking2);
		bookings.add(booking3);

		when(repository.findAll()).thenReturn(bookings);

		List<Integer> userIds = service.getBookedUsersByCourseId(course.getCourseId());
		assertTrue(userIds.contains(1));
		assertTrue(userIds.contains(2));
		assertTrue(userIds.contains(3));
		assertFalse(userIds.contains(4));
	}

}
