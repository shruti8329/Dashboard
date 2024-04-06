
package demo.dashboard.demo.data;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.dashboard.demo.data.BatchAPI.Data;

@Component
public class DataWriter implements ItemWriter<Data> {

    @Autowired
    DataRepository dataRepository;

    @Override
    public void write(List<? extends Data> data) throws Exception {
        dataRepository.saveAll(data);
    }

}
