package ecole.persistency;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ecole.model.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {

}
