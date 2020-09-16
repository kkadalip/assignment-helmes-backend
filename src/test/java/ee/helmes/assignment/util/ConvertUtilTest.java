package ee.helmes.assignment.util;

import ee.helmes.assignment.dto.SectorDTO;
import ee.helmes.assignment.model.Sector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;

import javax.persistence.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConvertUtilTest {

	@Test
	void convertToDto() {
		Sector parentSector = Sector.builder()
			.id(1)
			.name("Manufacturing")
			.build();
		List<Sector> childSectors = List.of(
			Sector.builder()
				.id(4)
				.name("Construction materials")
				.parentSector(parentSector)
				.build(),
			Sector.builder()
				.id(5)
				.name("Electronics and Optics")
				.parentSector(parentSector)
				.build()
		);
		parentSector.setChildSectors(childSectors);
		SectorDTO sectorDTO = ConvertUtil.convertToDto(parentSector);
		assertNotNull(sectorDTO.getChildSectors());
		assertEquals(2, sectorDTO.getChildSectors().size());
	}
}