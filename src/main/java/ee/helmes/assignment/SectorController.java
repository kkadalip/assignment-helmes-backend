package ee.helmes.assignment;

import ee.helmes.assignment.dto.*;
import ee.helmes.assignment.model.*;
import ee.helmes.assignment.service.*;
import ee.helmes.assignment.util.ConvertUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

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
		String sessionId = getSessionId();
		Visitor existingVisitor = visitorService.findBySessionId(sessionId);
		if (existingVisitor != null) {
			existingVisitor.setUsername(visitorDTO.getUsername());
			List<Sector> selectedSectors = sectorService.findByIds(visitorDTO.getSectors());
			existingVisitor.setSelectedSectors(selectedSectors);
			existingVisitor.setAgreedToTerms(visitorDTO.isAgreedToTerms());
			visitorService.save(existingVisitor);
		}
		else {
			visitorService.save(convertVisitorDtoToModel(visitorDTO, sessionId));
		}
	}

	public Visitor convertVisitorDtoToModel(VisitorDTO visitorDTO, String sessionId) {
		List<Long> sectorIds = visitorDTO.getSectors();
		List<Sector> selectedSectors = sectorIds != null ? sectorService.findByIds(sectorIds) : new ArrayList<>();
		return Visitor.builder()
			.username(visitorDTO.getUsername())
			.agreedToTerms(visitorDTO.isAgreedToTerms())
			.selectedSectors(selectedSectors)
			.sessionId(sessionId)
			.build();
	}

	// TODO DELETE LATER (THIS EXISTS HERE ONLY FOR DEBUGGING PURPOSES)
	@CrossOrigin
	@GetMapping("/api/visitors")
	public List<Visitor> findAllVisitors() {
		return visitorService.findAll();
	}

	private static String getSessionId() {
		return RequestContextHolder.currentRequestAttributes().getSessionId();
	}

}
