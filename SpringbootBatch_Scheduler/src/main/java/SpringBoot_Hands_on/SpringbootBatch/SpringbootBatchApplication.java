package SpringBoot_Hands_on.SpringbootBatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringbootBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBatchApplication.class, args);
	}

}
