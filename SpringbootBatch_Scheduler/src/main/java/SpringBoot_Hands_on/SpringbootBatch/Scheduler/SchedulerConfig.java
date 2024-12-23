package SpringBoot_Hands_on.SpringbootBatch.Scheduler;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableScheduling
public class SchedulerConfig {
	
//	@Scheduled(fixedRate = 3000)
	@Scheduled(fixedDelay = 3000)
	
//	@Scheduled(cron = "2 * * * * FRI")
//	@Scheduled(cron = "2 * * * * fri")
	@Scheduled(cron = "2 * * * * 5")
//	•second
//	•minute
//	•hour
//	•day of month
//	•month
//	•day of week

	public void printfrequently() {
		System.out.println( Thread.currentThread().getName() +" Look here ...... I am here ");
		
		
	}
	

		
	@Bean

	public ThreadPoolTaskScheduler  threapoll() {
		
		ThreadPoolTaskScheduler tps =new ThreadPoolTaskScheduler();
		
		tps.setPoolSize(4);
		tps.setThreadNamePrefix("Where are you ?");
		
		return tps;
		
	}
   
}


