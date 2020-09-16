package ee.helmes.assignment.service;

import ee.helmes.assignment.interfaces.SectorServiceI;
import ee.helmes.assignment.model.Sector;
import ee.helmes.assignment.repository.SectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectorService implements SectorServiceI {

	private final SectorRepository sectorRepository;

	public List<Sector> findAllRootSectors() {
		return sectorRepository.findAllByParentSectorIsNull();
	}
}
