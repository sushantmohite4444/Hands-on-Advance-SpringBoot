package springAOP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.transaction.Transactional;
import springAOP.Entity.Student;
import springAOP.ProgramaticTransectionManage.TransactionService1;
import springAOP.ProgramaticTransectionManage.TransactionService2;
import springAOP.Service.StudentService;

@Controller
public class AopTest {
	
	@Autowired
	StudentService stdservice;
	
	@Autowired
	TransactionService1 transactionService1;
	@Autowired
	TransactionService2 transactionService2;
	
	@RequestMapping("/saveStudent")
	@ResponseBody
	
	public String getpage() {
		
		

		Student s=new Student( );
		s.setLname("mohite");
		s.setName("sush");
		transactionService1.createUserWithTransaction(s);
		Student s1=new Student( );
		s1.setLname("mohite");
		s1.setName("sush");
		transactionService2.createUserWithTransaction(s1);
		
		stdservice.saveStudent(s);
		
		
		return "update";
		
	}
	
	@RequestMapping("/getStudent")
	public String Aopmethod() {
		stdservice.getstudent(List.of(1,52,102));
		return "update";
	}
	
	@RequestMapping("/keyword")
	public String keywordSerch() {
		stdservice.keywordSerch("z");
		return "update";
	}
	
	
	
}
