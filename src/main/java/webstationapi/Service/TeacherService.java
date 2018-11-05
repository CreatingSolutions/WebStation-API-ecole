package webstationapi.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webstationapi.Entity.Teacher;
import webstationapi.Repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
    private TeacherRepository repository;
	
	public List<Teacher> findAll() {
		return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
	}
	
}
