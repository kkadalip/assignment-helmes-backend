package ee.helmes.assignment;

import ee.helmes.assignment.model.Sector;
import ee.helmes.assignment.repository.RepositorySector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class SectorController {
	private final RepositorySector repositorySectors;

	@Autowired
	public SectorController(RepositorySector sectorsRepository) {
		this.repositorySectors = sectorsRepository;
	}

	@CrossOrigin //NOSONAR
	@GetMapping("/api/sectors")
	public List<Sector> findAllSectors() {
		return new ArrayList<>(repositorySectors.findAll());
	}

}
