package ee.helmes.assignment.interfaces;

import ee.helmes.assignment.model.Visitor;

import java.util.List;

public interface VisitorServiceI {

	Visitor save(Visitor visitor);

	List<Visitor> findAll();

	Visitor findBySessionId(String username);

}
