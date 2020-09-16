package ee.helmes.assignment.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_sector_id")
	private Sector parentSector;

	@OneToMany(mappedBy = "parentSector")
	@OrderBy("name ASC")
	private List<Sector> childSectors;
}
