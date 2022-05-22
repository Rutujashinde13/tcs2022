package assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import assignment.bean.Student;
import assignment.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService deatilsService;

	@PostMapping(value = "/adddeatils")
	Student addDetails(@RequestBody Student deatils) {

		Student prod = deatilsService.addDetails(deatils);

		return prod;

	}

}
