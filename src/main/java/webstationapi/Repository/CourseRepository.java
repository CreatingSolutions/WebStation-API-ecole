package webstationapi.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import webstationapi.Entity.Course;
import webstationapi.Entity.DayMoment;
import webstationapi.Entity.Period;

public interface CourseRepository extends CrudRepository<Course, Integer> {

	public List<Course> findByPeriodAndMoment(Period period, DayMoment moment);
	
}
