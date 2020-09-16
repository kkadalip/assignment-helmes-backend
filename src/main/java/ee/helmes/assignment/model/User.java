package ee.helmes.assignment.model;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;

	@Column(name = "username")
	private String name;

	@Column(name = "ageed_to_terms")
	private boolean agreedToTerms;

	// TODO user sectors
}