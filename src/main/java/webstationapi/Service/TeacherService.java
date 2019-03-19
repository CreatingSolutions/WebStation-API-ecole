package webstationapi.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webstationapi.Entity.Teacher;
import webstationapi.Repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
    private TeacherRepository repository;
	
	@Transactional
	public List<Teacher> findAll() {
		return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
	}
	
	@Transactional
	public Teacher findById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	@Transactional
	public List<Teacher> findByName(String lastName) {
		return repository.findByLastNameIsLike(lastName);
	}
	
	@Transactional
	public void createTeacher(String firstName, String lastName) {
		Teacher teacher = new Teacher();
		teacher.setFirstName(firstName);
		teacher.setLastName(lastName);
		repository.save(teacher);
	}
	
}
