package ee.helmes.assignment.dto;

import org.junit.jupiter.api.Test;

import javax.validation.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class VisitorDTOTest {

	@Test
	void testInvalidDTOnoSectors() {
		VisitorDTO visitorDTOnoSectors = VisitorDTO.builder()
			.id(111)
			.username("aaa")
			.agreedToTerms(true)
			.sectors(Collections.emptyList())
			.build();
		final Set<ConstraintViolation<VisitorDTO>> violations = Validation.buildDefaultValidatorFactory().getValidator().validate(visitorDTOnoSectors);
		assertFalse(violations.isEmpty());
		assertEquals(1L, violations.size());
		String expectedMessage = getValidationMessage(violations.stream().iterator().next());
		assertEquals("VisitorDTO.sectors must not be empty", expectedMessage);
	}

	public static <T> String getValidationMessage(ConstraintViolation<T> violation) {
		String className = violation.getRootBeanClass().getSimpleName();
		String property = violation.getPropertyPath().toString();
		String message = violation.getMessage();
		return String.format("%s.%s %s", className, property, message);
	}
}