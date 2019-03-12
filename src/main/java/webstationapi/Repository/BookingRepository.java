package webstationapi.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import webstationapi.Entity.Booking;
import webstationapi.Entity.Course;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
	
	public List<Booking> findByCourseIn(List<Course> course);
	
	public Long countByCourse(Course course);
	
}
