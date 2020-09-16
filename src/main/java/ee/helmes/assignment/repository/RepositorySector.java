package ee.helmes.assignment.repository;

import ee.helmes.assignment.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin //NOSONAR
@Repository
public interface RepositorySector extends JpaRepository<Sector, Long> {

}
