package br.com.amigotradutor.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.amigotradutor.service.EditoraService;

@RunWith(SpringRunner.class)
@WebMvcTest(EditoraController.class)
public class EditoraControllerTest {

	@Autowired
    private MockMvc mvc;

	@MockBean
    private EditoraService service;
	
    @Test
    public void getAllPessoas() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/editoras").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
	
}
