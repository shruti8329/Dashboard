
package demo.dashboard.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.dashboard.demo.data.BatchAPI.Data;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {
}
