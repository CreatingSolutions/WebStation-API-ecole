package webstationapi.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webstationapi.Entity.Booking;
import webstationapi.Repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	public void setBookingRepository(BookingRepository repository) {
		this.bookingRepository = repository;
	}

	public void createBooking(Booking booking) {
		bookingRepository.save(booking);
	}

	public List<Integer> getBookedUsersByCourseId(int courseId) {
		return StreamSupport.stream(bookingRepository.findAll().spliterator(), false)
			.filter(booking -> booking.getCourse().getCourseId() == courseId)
			.map(booking -> booking.getUserId())
			.collect(Collectors.toList());
	}

}
