package springAOP.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
public class TransactionalConfiguration {
	
	 @Bean
	    public PlatformTransactionManager transactionManager() {
	        return new JpaTransactionManager();
	    }
	 
	 
//	 @Bean
//	 public TransactionTemplate transactionTemplate (PlatformTransactionManager Ptm)
//	 {
//		return new TransactionTemplate(Ptm);
//		 
//	 }

}
