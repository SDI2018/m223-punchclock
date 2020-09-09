package ch.zli.m223.punchclock;

import ch.zli.m223.punchclock.controller.EntryController;
import ch.zli.m223.punchclock.domain.ApplicationUser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PunchclockApplication.class)
@WebAppConfiguration
public abstract class PunchclockApplicationTests {
	protected MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;

	protected void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}
	protected <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}


	@Test
	public void contextLoads() {
	}
	@Test
	public void createApllicationUser() throws Exception {
		String uri = "/sign-up";
		ApplicationUser applicationUser = new applicationUser();
		applicationUser.setId("1");
		applicationUser.setUsername("stefan");

		String inputJson = super.mapToJson(applicationUser);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Product is created successfully");
	}
	@Autowired
	private EntryController controller;

	@Test
	public void contexLoads() throws Exception {
		assert ;
	}

}
