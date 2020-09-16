package ee.helmes.assignment;

import ee.helmes.assignment.dto.SectorDTO;
import ee.helmes.assignment.model.*;
import ee.helmes.assignment.repository.*;
import ee.helmes.assignment.util.ConvertUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class SectorController {
	private final RepositorySector repositorySectors;
	private final RepositoryVisitor repositoryVisitor;

	@CrossOrigin //NOSONAR
	@GetMapping("/api/sectors")
	public List<SectorDTO> findAllSectors() {
		return repositorySectors.findAll().stream().map(ConvertUtil::convertToDto).collect(Collectors.toList());
	}

	@CrossOrigin //NOSONAR
	@GetMapping("/api/visitors")
	public List<Visitor> findAllVisitors() {
		return repositoryVisitor.findAll();
	}
}
