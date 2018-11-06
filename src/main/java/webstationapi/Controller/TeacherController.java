package webstationapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import webstationapi.Utils;
import webstationapi.Entity.Teacher;
import webstationapi.Service.TeacherService;

@RestController
@EnableAutoConfiguration
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teachers")
    public List<Teacher> getTeachers() {
        return teacherService.findAll();
    }
    
    @GetMapping("/id/{id}")
    public Teacher getTeacherById(@PathVariable(value="id") String id) {
    	int teacherId = Utils.getIdFromString(id);
    	return teacherService.findById(teacherId);
    }
    
    @GetMapping("/name/{name}")
    public List<Teacher> getTeacherByName(@PathVariable(value="name") String name) {
    	return teacherService.findByName(name);
    }

}
