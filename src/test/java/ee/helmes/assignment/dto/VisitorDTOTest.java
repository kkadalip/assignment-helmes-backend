package ee.helmes.assignment.dto;

import org.junit.jupiter.api.Test;

import javax.validation.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class VisitorDTOTest {

	@Test
	void testInvalidDTOusernameMissing() {
		VisitorDTO visitorDTOnoSectors = VisitorDTO.builder().username("").agreedToTerms(true).sectors(getValidMockSectorDTOs()).build();
		Set<ConstraintViolation<VisitorDTO>> violations = validate(visitorDTOnoSectors);
		assertFalse(violations.isEmpty());
		assertEquals(1L, violations.size());
		String expectedMessage = getValidationMessage(violations.stream().iterator().next());
		assertEquals("VisitorDTO.username Username cannot be empty", expectedMessage);
	}

	@Test
	void testInvalidDTOusernameEmpty() {
		VisitorDTO visitorDTOnoSectors = VisitorDTO.builder().username("").agreedToTerms(true).sectors(getValidMockSectorDTOs()).build();
		Set<ConstraintViolation<VisitorDTO>> violations = validate(visitorDTOnoSectors);
		assertFalse(violations.isEmpty());
		assertEquals(1L, violations.size());
		String expectedMessage = getValidationMessage(violations.stream().iterator().next());
		assertEquals("VisitorDTO.username Username cannot be empty", expectedMessage);
	}

	@Test
	void testInvalidDTOagreedToTermsFalse() {
		VisitorDTO visitorDTOnoSectors = VisitorDTO.builder().username("aaa").agreedToTerms(false).sectors(getValidMockSectorDTOs()).build();
		Set<ConstraintViolation<VisitorDTO>> violations = validate(visitorDTOnoSectors);
		assertFalse(violations.isEmpty());
		assertEquals(1L, violations.size());
		String expectedMessage = getValidationMessage(violations.stream().iterator().next());
		assertEquals("VisitorDTO.agreedToTerms You have to agree to terms", expectedMessage);
	}

	private Set<ConstraintViolation<VisitorDTO>> validate(VisitorDTO visitorDTO) {
		return Validation.buildDefaultValidatorFactory().getValidator().validate(visitorDTO);
	}

	private List<Long> getValidMockSectorDTOs() {
		return Arrays.asList(1L, 4L);
	}

	@Test
	void testInvalidDTOnoSectors() {
		VisitorDTO visitorDTOnoSectors = VisitorDTO.builder().username("aaa").agreedToTerms(true).sectors(Collections.emptyList()).build();
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