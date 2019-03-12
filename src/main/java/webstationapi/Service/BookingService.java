package webstationapi.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webstationapi.Entity.Booking;
import webstationapi.Repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	public void createBooking(Booking booking) {
		bookingRepository.save(booking);
	}
	
	public List<String> getBookedUsersByCourseId(int courseId) {
		//TODO waiting for getUsernamesByUserIdList implementation in the main API.
		return new ArrayList<String>();
	}
	
}
