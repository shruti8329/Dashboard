
package demo.dashboard.demo.data;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import demo.dashboard.demo.data.BatchAPI.Data;

@Component
public class DataProcessor implements ItemProcessor<DataVisual, Data> {

    @Override
    public Data process(final DataVisual dataVisual) throws Exception {

        Data data = new Data();
        data.setIntensity(dataVisual.getIntensity());
        data.setLikelihood(dataVisual.getLikelihood());
        data.setRelevance(dataVisual.getRelevance());
        data.setStartYear(dataVisual.getStart_year());
        data.setEndYear(dataVisual.getEnd_year());
        data.setCountry(dataVisual.getCountry());
        data.setTopic(dataVisual.getTopic());
        data.setRegion(dataVisual.getRegion());
        data.setCity(dataVisual.getCity());
        return data;
    }

}
