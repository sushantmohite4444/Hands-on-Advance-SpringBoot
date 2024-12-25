package springAOP.Service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import springAOP.Dao.DaoInterfaceJPA;
import springAOP.Entity.Student;

@Service
public class StudentService {
	
	@Autowired
	DaoInterfaceJPA jpaObj;
	

	
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
//	@Transactional(propagation = Propagation.NOT_SUPPORTED,isolation = Isolation.REPEATABLE_READ)
//	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.READ_COMMITTED)
//	@Transactional(propagation = Propagation.NESTED,isolation = Isolation.READ_UNCOMMITTED)
//	@Transactional(propagation = Propagation.MANDATORY,isolation = Isolation.DEFAULT)
//	@Transactional(propagation = Propagation.NEVER)
//	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Student saveStudent(Student std) {
		
				
		
		jpaObj.save(std);
		
		
		throw new RuntimeException("Runtime Exception");
//		return std;
	}
	
	public List<Student> getstudent(List<Integer> val)
	{
//		jpaObj.findAll();
//		Optional<Student> stud=	jpaObj.findById(123);
//		List<Student> stud=	(List<Student>) jpaObj.findById(123).orElse(null);
		
//		List<Student> stud = new ArrayList<>();
//		jpaObj.findById(123).ifPresent(stud::add);
		
//		List<Student> stud=	jpaObj.findByname(name);
//		List<Student> stud=	jpaObj.findBylname(name);
//		List<Student> stud=	jpaObj.getStudents(val);
		
		List<Student> stud=	jpaObj.findByidGreaterThan(0);
		System.out.println(stud);
		for(Student std :stud) {
//			jpaObj.delete(std);   //delete
			//(or)
			std.setLname("mohite");
			jpaObj.save(std);   // update
			
		}

		return stud;
	}
	
	public List<Student> keywordSerch(String name) {
		
	List<Student>	stud =jpaObj.findByNameContainingOrLnameContaining(name,name);
	System.out.println(stud);
		return stud;

	}

	// we can use transactional on method or class 
	// internally uses @within("* *.transactional")
	// uses Around (combination of @Before and @After)
	// work with only public method as you know private method is a part of class 
	// Transactional annotation provide ACID property
	// Screenshot JTA transaction manager is use for two way commit transaction
}
