package ee.helmes.assignment.service;

import ee.helmes.assignment.interfaces.VisitorServiceI;
import ee.helmes.assignment.model.Visitor;
import ee.helmes.assignment.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitorService implements VisitorServiceI {

	private final VisitorRepository visitorRepository;

	public List<Visitor> findAll() {
		return visitorRepository.findAll();
	}

	public Visitor save(Visitor visitor) {
		return visitorRepository.save(visitor);
	}

	public List<Visitor> findBySessionId() {
		return visitorRepository.findAll();
	}
}
