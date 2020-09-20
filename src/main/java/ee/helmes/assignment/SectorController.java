package ee.helmes.assignment;

import ee.helmes.assignment.dto.*;
import ee.helmes.assignment.model.*;
import ee.helmes.assignment.service.*;
import ee.helmes.assignment.util.ConvertUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SectorController {

	private final VisitorService visitorService;
	private final SectorService sectorService;

	@CrossOrigin
	@GetMapping("/api/sectors")
	public List<SectorDTO> findAllSectors() {
		return sectorService.findAllRootSectors().stream().map(ConvertUtil::convertSectorModelToDto).collect(Collectors.toList());
	}

	@CrossOrigin
	@PostMapping("/api/save")
	public void saveVisitor(@Valid @RequestBody VisitorDTO visitorDTO) {
		log.info("Visitor is " + visitorDTO);
		visitorService.save(convertVisitorDtoToModel(visitorDTO));
	}

	public Visitor convertVisitorDtoToModel(VisitorDTO visitorDTO) {
		List<Long> sectorIds = visitorDTO.getSectors();
		List<Sector> selectedSectors = sectorIds != null ? sectorService.findByIds(sectorIds) : new ArrayList<>();
		return Visitor.builder()
			.id(visitorDTO.getId())
			.username(visitorDTO.getUsername())
			.agreedToTerms(visitorDTO.isAgreedToTerms())
			.selectedSectors(selectedSectors)
			.build();
	}

	// TODO DELETE LATER (THIS EXISTS HERE ONLY FOR DEBUGGING PURPOSES)
	@CrossOrigin
	@GetMapping("/api/visitors")
	public List<Visitor> findAllVisitors() {
		return visitorService.findAll();
	}

}
