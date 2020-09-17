package ee.helmes.assignment;

import ee.helmes.assignment.dto.SectorDTO;
import ee.helmes.assignment.model.Visitor;
import ee.helmes.assignment.service.*;
import ee.helmes.assignment.util.ConvertUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class SectorController {

	private final VisitorService visitorService;
	private final SectorService sectorService;

	@CrossOrigin
	@GetMapping("/api/sectors")
	public List<SectorDTO> findAllSectors() {
		return sectorService.findAllRootSectors().stream().map(ConvertUtil::convertToDto).collect(Collectors.toList());
	}

	@CrossOrigin
	@GetMapping("/api/visitors")
	public List<Visitor> findAllVisitors() {
		return visitorService.findAll();
	}
}
