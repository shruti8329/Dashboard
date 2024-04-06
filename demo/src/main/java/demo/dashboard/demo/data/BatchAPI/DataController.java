// package demo.dashboard.demo.BatchAPI;
package demo.dashboard.demo.data.BatchAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    DataService dataService;

    @GetMapping("demo/getData/{dataId}")
    public Data getData(@PathVariable Long dataId) {
        return dataService.getData(dataId);
    }

}
