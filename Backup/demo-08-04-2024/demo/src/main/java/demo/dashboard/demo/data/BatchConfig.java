
package demo.dashboard.demo.data;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import demo.dashboard.demo.data.BatchAPI.Data;

@Configuration
@EnableBatchProcessing

public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DataReader reader;

    @Autowired
    private DataProcessor processor;

    @Autowired
    private DataWriter writer;

    @Bean
    public Step step() {
        return stepBuilderFactory.get("step")
                .<DataVisual, Data>chunk(100)
                .reader(reader.reader())
                .processor(processor)
                .writer(writer)
                .allowStartIfComplete(true)
                .build();
    }

    @Bean
    public Job job(JobCompletionNotificationListener listener) {
        return jobBuilderFactory.get("job")
                .start(step())
                .listener(listener)
                .build();
    }
}
