
package demo.dashboard.demo.data;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class DataReader implements ItemReader<DataVisual> {

    private final String[] FIELD_NAMES = new String[] {
            "intensity", "likelihood", "relevance", "start_year", "end_year", "country", "topic", "region", "city"
    };

    @Override
    public DataVisual read() throws Exception {
        return null;
    }

    public FlatFileItemReader<DataVisual> reader() {

        FlatFileItemReader<DataVisual> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("Data.csv"));
        reader.setLinesToSkip(1);
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames(FIELD_NAMES);

        LineMapper<DataVisual> lineMapper = new DefaultLineMapper<>();
        ((DefaultLineMapper<DataVisual>) lineMapper).setLineTokenizer(tokenizer);
        ((DefaultLineMapper<DataVisual>) lineMapper).setFieldSetMapper(fieldSet -> {
            DataVisual dataVisual = new DataVisual();
            dataVisual.setIntensity(fieldSet.readString("intensity"));
            dataVisual.setLikelihood(fieldSet.readString("likelihood"));
            dataVisual.setRelevance(fieldSet.readString("relevance"));
            dataVisual.setStart_year(fieldSet.readString("start_year"));
            dataVisual.setEnd_year(fieldSet.readString("end_year"));
            dataVisual.setCountry(fieldSet.readString("country"));
            dataVisual.setTopic(fieldSet.readString("topic"));
            dataVisual.setRegion(fieldSet.readString("region"));
            dataVisual.setCity(fieldSet.readString("city"));
            return dataVisual;
        });

        reader.setLineMapper(lineMapper);
        return reader;
    }

}
