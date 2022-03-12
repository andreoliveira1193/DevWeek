package com.dio_class.devWeek;

import com.dio_class.devweek.Entity.Regiao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.Mock;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class DevWeekApplicationTests {

	private final String URL= "/api/regiao";

	@Autowired
	MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Mock
	private Regiao controller;


	//Teste para Listar os Objetos
	@Test
	public void getControllerTest() throws Exception{
		mockMvc.perform(get(URL)).andExpect(status().isOk());
	}

	@Test
	public void getByIdControllerTest() throws Exception{
		mockMvc.perform(get(URL + "2")).andExpect(status().isOk());
	}

	@Test
	public void postRegiaoTest() throws Exception
	{
		//Long id = Long.valueOf(55); valor auto incrementado
		Regiao newRegiao = new Regiao(99L,"OutraRegiao",99);
		mockMvc.perform(post(URL + "/novo").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(newRegiao))).andExpect(status().isOk());

	}


	@Test
	public void postRegiaoTest2() throws Exception{
		Regiao newRegiao = new Regiao(99L,"OutraRegiao",99);
		mockMvc.perform(post(URL + "/novo").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(newRegiao))).andExpect(status().isOk());
	}
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
