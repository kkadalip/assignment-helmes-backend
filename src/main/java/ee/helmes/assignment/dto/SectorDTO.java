package ee.helmes.assignment.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
public class SectorDTO {
	private long id;
	private String name;
	private List<SectorDTO> childSectors;
}
