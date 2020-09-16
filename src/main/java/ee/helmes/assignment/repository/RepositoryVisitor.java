package ee.helmes.assignment.repository;

import ee.helmes.assignment.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryVisitor extends JpaRepository<Visitor, Long> {

}
