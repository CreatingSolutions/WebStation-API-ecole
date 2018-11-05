package ecole.persistency;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ecole.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

}
