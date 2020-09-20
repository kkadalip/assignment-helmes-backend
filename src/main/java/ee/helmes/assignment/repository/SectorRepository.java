package ee.helmes.assignment.repository;

import ee.helmes.assignment.model.Sector;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {

	List<Sector> findAllByParentSectorIsNull();

	@Query("select s from Sector s where s.id in :ids")
	List<Sector> findByIds(@Param("ids") List<Long> sectorIds);
}
