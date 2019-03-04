package webstationapi.Repository;

import org.springframework.data.repository.CrudRepository;

import webstationapi.Entity.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {

}
