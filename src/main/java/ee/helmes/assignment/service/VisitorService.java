package ee.helmes.assignment.service;

import ee.helmes.assignment.interfaces.VisitorServiceI;
import ee.helmes.assignment.model.Visitor;
import ee.helmes.assignment.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class VisitorService implements VisitorServiceI {

	private final VisitorRepository visitorRepository;

	public Visitor save(Visitor visitor) {
		return visitorRepository.save(visitor);
	}

	public List<Visitor> findAll() {
		return visitorRepository.findAll();
	}

	public Visitor findBySessionId(String sessionId) {
		try {
			if (StringUtils.isNotBlank(sessionId)) {
				return visitorRepository.findBySessionId(sessionId);
			}
		}
		catch (Exception ex) {
			log.error("Failed to retreive Visitor by existing username", ex);
		}
		return null;
	}
}
