package ee.helmes.assignment.model;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "sector")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sector {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	// TODO parent/child sectors
}
