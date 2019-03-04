package webstationapi.Repository;

import org.springframework.data.repository.CrudRepository;

import webstationapi.Entity.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
	
}
