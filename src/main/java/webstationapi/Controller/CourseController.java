package webstationapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webstationapi.Entity.Course;
import webstationapi.Service.CourseService;

@RestController
@RequestMapping(path = "/course")
@EnableAutoConfiguration
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/available")
    public List<Course> getAvailableCourses() {
    	return courseService.getAvailableCourses();
    }
	
}
