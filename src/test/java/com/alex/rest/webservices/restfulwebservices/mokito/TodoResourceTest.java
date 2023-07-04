package com.alex.rest.webservices.restfulwebservices.mokito;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.alex.rest.webservices.restfulwebservices.todo.TodoJpaService;

@WebMvcTest
class TodoResourceTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TodoJpaService todoJpaService;

	@Test
	public void retrieveAllTodosApi() throws Exception {
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/users/{username}/todos", "alex")
				.header("Authorization", "Basic YWxleDoxMjM0"));
		result.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
