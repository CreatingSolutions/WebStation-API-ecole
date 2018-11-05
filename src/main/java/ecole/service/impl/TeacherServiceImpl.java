package ecole.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import ecole.model.Teacher;
import ecole.persistency.TeacherRepository;
import ecole.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {

	private TeacherRepository teacherRepo;
	
	@Override
	public List<Teacher> findByLastName(String lastName) {
		return StreamSupport.stream(teacherRepo.findAll().spliterator(), false).collect(Collectors.toList());
	}

}
