package ee.helmes.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "visitor")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Visitor {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;

	@Column(name = "username")
	private String username;

	@Column(name = "ageed_to_terms")
	private boolean agreedToTerms;

	@OneToMany
	@JoinTable(name = "sector_visitor",
		joinColumns = @JoinColumn(name = "visitor_id"),
		inverseJoinColumns = @JoinColumn(name = "sector_id")
	)
	List<Sector> selectedSectors;
}