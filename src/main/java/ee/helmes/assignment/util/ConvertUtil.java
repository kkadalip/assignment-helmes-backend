package ee.helmes.assignment.util;

import ee.helmes.assignment.dto.SectorDTO;
import ee.helmes.assignment.model.Sector;

import java.util.stream.Collectors;

public class ConvertUtil {

	public static SectorDTO convertToDto(Sector sector) {
		return SectorDTO.builder()
			.id(sector.getId())
			.name(sector.getName())
			.childSectors(sector.getChildSectors().stream().map(ConvertUtil::convertToDto).collect(Collectors.toList()))
			.build();
	}
}
