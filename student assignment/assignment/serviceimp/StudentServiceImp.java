package assignment.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment.bean.Student;
import assignment.repositary.MyLocalRepository;
import assignment.service.StudentService;

@Service
public class StudentServiceImp implements StudentService{

	@Autowired
	MyLocalRepository myLocalRepository;

	@Override
	public Student addDetails(Student deatils) {
		
		Student deatiladded = myLocalRepository.save(deatils);
	
		return deatiladded;
	}

}
