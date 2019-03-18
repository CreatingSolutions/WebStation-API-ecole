package webstationapi.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import webstationapi.Entity.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

	public List<Teacher> findByLastNameIsLike(String lastName);
	
}
