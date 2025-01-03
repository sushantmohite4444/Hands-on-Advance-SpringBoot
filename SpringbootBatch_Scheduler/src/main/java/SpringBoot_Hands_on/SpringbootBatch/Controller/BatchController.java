package SpringBoot_Hands_on.SpringbootBatch.Controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController
public class BatchController {
	
	
	
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;
	
	@GetMapping("/addData")
	public String addData() {
		
		 JobParameters jobParameters =new JobParametersBuilder()
				.addLong("startAt",System.currentTimeMillis() ).toJobParameters();
		
		
		
		try {
			 JobExecution jobExecution = jobLauncher.run(job, jobParameters);
			return jobExecution.getStatus().toString();
			
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			
		e.printStackTrace();
			
			return " Error "+ e.getMessage();
		}
		

		
	}
	
	
	

}
