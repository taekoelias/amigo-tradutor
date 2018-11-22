package br.com.amigotradutor.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import javax.swing.text.AbstractDocument.Content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.amigotradutor.model.Papel;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PapelControllerTest {

	@Autowired
    private MockMvc mvc;

    @Test
    public void getAllPapeis() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/papeis").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
	
    @Test
    public void getPapelAdministrador() throws Exception {
    	
    	Papel papelAdministrador = new Papel();
		papelAdministrador.setId(Papel.PAPEL_ADMIN);
		papelAdministrador.setNome("Administrador");
		papelAdministrador.setDescricao("Usuário administrador do sistema.");
    	
        mvc.perform(MockMvcRequestBuilders.get("/papeis/"+Papel.PAPEL_ADMIN).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().equals(papelAdministrador);
    }
}
