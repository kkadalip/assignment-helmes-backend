package ee.helmes.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "sector")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sector {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_sector_id")
	private Sector parentSector;

	@JsonIgnore
	@OneToMany(mappedBy = "parentSector", fetch = FetchType.LAZY)
	@OrderBy("name ASC")
	private List<Sector> childSectors;
}
