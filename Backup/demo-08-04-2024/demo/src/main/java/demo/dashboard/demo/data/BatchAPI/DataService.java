package demo.dashboard.demo.data.BatchAPI;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dashboard.demo.data.DataRepository;

@Service
public class DataService {

    @Autowired
    DataRepository dataRepository;

    public Data getData(Long dataId) {
        Data data = dataRepository.findById(dataId).orElse(null);
        return data;
    }

    public List<Data> getAll() {
        List<Data> data = dataRepository.findAll();
        return data;
    }

}