package ee.helmes.assignment.repository;

import ee.helmes.assignment.model.Visitor;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {

	@Query("select v from Visitor v where v.sessionId = :sessionId")
	Visitor findBySessionId(@Param("sessionId") String sessionId);
}
