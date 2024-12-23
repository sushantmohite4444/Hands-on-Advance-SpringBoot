package EurekaClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "EurekaClient.FeingClient")
public class EurekaClientgetApiAccessApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientgetApiAccessApplication.class, args);
	}

}
