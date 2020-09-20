package ee.helmes.assignment;

import ee.helmes.assignment.dto.*;
import ee.helmes.assignment.model.Visitor;
import ee.helmes.assignment.service.*;
import ee.helmes.assignment.util.ConvertUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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
		return sectorService.findAllRootSectors().stream().map(ConvertUtil::convertToDto).collect(Collectors.toList());
	}

	// TODO DELETE (FOR DEBUGGING PURPOSES)
	@CrossOrigin
	@GetMapping("/api/visitors")
	public List<Visitor> findAllVisitors() {
		return visitorService.findAll();
	}

	@CrossOrigin
	@PostMapping("/api/save")
	public void saveVisitor(@Valid @RequestBody VisitorDTO visitorDTO) {
		System.out.println("Visitor is " + visitorDTO);
		visitorService.save(convertToVisitor(visitorDTO));
	}

	private Visitor convertToVisitor(VisitorDTO visitorDTO) {
		return Visitor.builder()
			//.id(visitorDTO.getId())
			.username(visitorDTO.getUsername())
			.agreedToTerms(visitorDTO.isAgreedToTerms())
			.selectedSectors(null) // TODO
			.build();
	}
}
