package ecole.service;

import java.util.List;

import ecole.model.Teacher;

public interface TeacherService {

	public List<Teacher> findByLastName(String lastName);
	
}
