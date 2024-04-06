// package demo.dashboard.demo.BatchAPI;
package demo.dashboard.demo.data.BatchAPI;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dashboard.demo.data.DataRepository;

@Service
public class DataService {

    @Autowired
    DataRepository dataRepository;

    @SuppressWarnings("unused")
    public Data getData(Long dataId) {
        Optional<demo.dashboard.demo.data.BatchAPI.Data> data = dataRepository.findById(dataId);
        return null;
    }

}
