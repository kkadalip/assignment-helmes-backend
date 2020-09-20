package ee.helmes.assignment.interfaces;

import ee.helmes.assignment.model.Sector;

import java.util.List;

public interface SectorServiceI {

	List<Sector> findAllRootSectors();

	List<Sector> findByIds(List<Long> ids);

}
