package com.domain.config;




import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.domain.model.Lotto;

@Configuration
@EnableBatchProcessing
public class SpringBatchConffig {

	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory,
				   StepBuilderFactory stepBuilderFactory,
				   ItemReader<Lotto> itemReader,  
				   ItemProcessor<Lotto, Lotto> itemProcessor,
				   ItemWriter<Lotto> itemWriter
			       ) {
	
		
		Step step = stepBuilderFactory.get("ETL-file-load")
				.<Lotto,Lotto>chunk(100)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
		
		return jobBuilderFactory.get("ETL-Load")
				.start(step)
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public FlatFileItemReader<Lotto> itemReader( @Value("${input.file}") String filePath){
		FlatFileItemReader<Lotto> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new FileSystemResource(filePath));
		flatFileItemReader.setName("CSV-Reader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(lineMapper());
		
		return flatFileItemReader;
	}

	private LineMapper<Lotto> lineMapper() {
		// TODO Auto-generated method stub
		
		DefaultLineMapper<Lotto> defaultLineMapper =new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] {"round","row1","row2","row3","row4","row5","row6","row7"});
		
		BeanWrapperFieldSetMapper<Lotto> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Lotto.class);
		
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		
		return defaultLineMapper ;
	}
	
	
}
