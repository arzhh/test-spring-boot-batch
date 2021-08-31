package configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tasklet.TestTasklet;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Value("${value}")
    String value;

    @Bean
    public Job testJob() {
        return jobBuilderFactory.get("testJob")
                .incrementer(new RunIdIncrementer())
                .flow(testStep())
                .end()
                .build();
    }

    @Bean
    public Step testStep() {
        return stepBuilderFactory.get("testStep")
                .tasklet(testTasklet())
                .build();
    }

    @Bean
    public Tasklet testTasklet(){
        return new TestTasklet(value);
    }
}
