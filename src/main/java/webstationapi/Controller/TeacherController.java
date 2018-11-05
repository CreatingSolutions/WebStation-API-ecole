package webstationapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import webstationapi.Entity.Teacher;
import webstationapi.Service.TeacherService;

@RestController
@EnableAutoConfiguration
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teachers")
    public List<Teacher> getTeachers() {
        System.out.println("OK");
        return teacherService.findAll();
    }    

}
