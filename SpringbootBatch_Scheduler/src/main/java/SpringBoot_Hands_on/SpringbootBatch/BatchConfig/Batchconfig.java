package SpringBoot_Hands_on.SpringbootBatch.BatchConfig;



import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import SpringBoot_Hands_on.SpringbootBatch.Entity.UserInfo;
import SpringBoot_Hands_on.SpringbootBatch.Repository.UserInfoRepository;

@Configuration
public class Batchconfig {
	
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	
	@Bean
	public Job job(JobRepository  jobRepository ,Step step) {
		
		return new JobBuilder("AddUserinfo" ,jobRepository).start(step).build();
	}
	
	@Bean
	Step step(JobRepository jobRepository ,PlatformTransactionManager platformTransactionManager) {
		return new StepBuilder("step1",jobRepository)
				.<UserInfo, UserInfo>chunk(10,platformTransactionManager)
				.reader(reader())
				.processor(itemProcessor())
				.writer(repositoryItemWriter())
				.build();
		
	}

    @Bean
    FlatFileItemReader<UserInfo> reader() 
    {
		return new FlatFileItemReaderBuilder<UserInfo>()
				.name("FileReader")
				.resource(new ClassPathResource("sample.csv"))
				.linesToSkip(1)
				.lineMapper(linemapper())
				.targetType(UserInfo.class)
				.build();
		
	}

	private LineMapper<UserInfo> linemapper() {
		DefaultLineMapper<UserInfo> userMapper =new DefaultLineMapper<>();
		 
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("id","name","lastName");
			
		BeanWrapperFieldSetMapper<UserInfo> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(UserInfo.class);
			
		userMapper.setLineTokenizer(lineTokenizer);
		userMapper.setFieldSetMapper(fieldSetMapper);	
			
		return userMapper;
	}
	
	@Bean
 ModifyData modifyData () {
		return new ModifyData();
	}
	
	@Bean
	ItemProcessor<UserInfo, UserInfo> itemProcessor (){
		return (UserInfo item)->{
				item.setName(item.getName().toLowerCase());
				return item;
				};
	}
	
	@Bean
	 RepositoryItemWriter<UserInfo> repositoryItemWriter (){
		
	     RepositoryItemWriter<UserInfo>  writer=	new RepositoryItemWriter<>();
		writer.setRepository(userInfoRepository);
	    writer.setMethodName("save");
	     return writer;
		
	}
//	@Bean
//	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//	    return new JpaTransactionManager(entityManagerFactory);
//	}
	
	


	
		
	}


