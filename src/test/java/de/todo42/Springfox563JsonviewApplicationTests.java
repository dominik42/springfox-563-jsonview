package de.todo42;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springfox563JsonviewApplication.class)
public class Springfox563JsonviewApplicationTests {

	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac)
        		.alwaysDo(print())
        		.build();
	}

	@Test
	public void testPersonController() throws Exception {
		mockMvc.perform(get("/person")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("firstName", is("Dominik")))
				.andExpect(jsonPath("lastName", is("Hirt")))
				.andExpect(jsonPath("nickName", is("Dom")));

		mockMvc.perform(get("/person/simple")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("firstName").doesNotExist())
				.andExpect(jsonPath("lastName").doesNotExist())
				.andExpect(jsonPath("nickName", is("Dom")));

		mockMvc.perform(get("/v2/api-docs")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
	}



}
