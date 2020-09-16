package ee.helmes.assignment.repository;

import ee.helmes.assignment.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {

	List<Sector> findAllByParentSectorIsNull();
}
