package ee.helmes.assignment.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitorDTO {

	@Min(0)
	private long id;
	@NotNull(message = "Username is required")
	@NotBlank(message = "Username cannot be empty")
	private String username;
	@AssertTrue(message = "You have to agree to terms")
	private boolean agreedToTerms;
	@NotNull(message = "Selected sectors can not be empty")
	@NotEmpty
	List<Long> sectors;

	String sessionId;
}