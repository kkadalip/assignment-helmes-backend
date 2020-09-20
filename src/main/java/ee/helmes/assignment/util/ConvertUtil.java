package ee.helmes.assignment.util;

import ee.helmes.assignment.dto.*;
import ee.helmes.assignment.model.*;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public class ConvertUtil {

	private ConvertUtil() {
	}

	public static SectorDTO convertSectorModelToDto(Sector sector) {
		if (sector == null) {
			return null;
		}
		List<SectorDTO> childSectors = !CollectionUtils.isEmpty(sector.getChildSectors()) ?
			sector.getChildSectors().stream().map(ConvertUtil::convertSectorModelToDto).collect(Collectors.toList()) : new ArrayList<>();
		return SectorDTO.builder()
			.id(sector.getId())
			.name(sector.getName())
			.childSectors(childSectors)
			.build();
	}
}
