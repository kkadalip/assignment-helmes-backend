package ee.helmes.assignment.interfaces;

import ee.helmes.assignment.model.Visitor;

import java.util.List;

public interface VisitorServiceI {

	List<Visitor> findAll();

	Visitor save(Visitor visitor);

	List<Visitor> findBySessionId();

}
