package webstationapi.Repository;

import org.springframework.data.repository.CrudRepository;

import webstationapi.Entity.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

	// public List<Teacher> getTeacherByName(String name);
	
}
