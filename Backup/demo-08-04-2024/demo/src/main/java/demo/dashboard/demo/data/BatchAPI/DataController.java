
package demo.dashboard.demo.data.BatchAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
    @Autowired
    DataService dataService;

    @GetMapping("demo/getData/{dataId}")
    public Data getData(@PathVariable Long dataId) {
        return dataService.getData(dataId);
    }

    @GetMapping("demo/getAllData")
    public List<Data> getData() {
        return dataService.getAll();
    }

}
