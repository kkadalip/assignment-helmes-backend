package ee.helmes.assignment;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ee.helmes.assignment.dto.SectorDTO;
import ee.helmes.assignment.repository.SectorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	private SectorRepository sectorRepository;

	@Test
	void getQueryWorks() throws Exception {
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/api/sectors")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		MvcResult result = resultActions.andReturn();
		List<SectorDTO> actual = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
		});
		assertNotNull(actual);
		assertEquals(3, actual.size());
		assertEquals(1, actual.get(0).getId());
		assertEquals("sector.manufacturing", actual.get(0).getName());
	}
}
