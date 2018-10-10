package br.com.amigotradutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.amigotradutor.model.Idioma;
import br.com.amigotradutor.model.Papel;
import br.com.amigotradutor.repository.interfaces.IdiomaRepository;
import br.com.amigotradutor.repository.interfaces.PapelRepository;

@SpringBootApplication
public class AmigoTradutorApplication implements CommandLineRunner  {

	@Autowired
	private PapelRepository papelDao;
	
	@Autowired
	private IdiomaRepository idiomaDao;
	
	public static void main(String[] args) {
		SpringApplication.run(AmigoTradutorApplication.class, args);

	}

	@Override
	public void run(String... arg0) throws Exception {
		Papel papelUsuario = new Papel();
		papelUsuario.setId(Papel.PAPEL_USUARIO);
		papelUsuario.setNome("Usuário");
		papelUsuario.setDescricao("Usuário comum do sistema.");
		papelDao.save(papelUsuario);
		
		Papel papelAdministrador = new Papel();
		papelAdministrador.setId(Papel.PAPEL_ADMIN);
		papelAdministrador.setNome("Administrador");
		papelAdministrador.setDescricao("Usuário administrador do sistema.");
		papelDao.save(papelAdministrador);
		
		Papel papelGer = new Papel();
		papelGer.setId(Papel.PAPEL_GERENTE);
		papelGer.setNome("Gerente de Projeto");
		papelGer.setDescricao("Usuário gerente de projeto.");
		papelDao.save(papelGer);
		
		Papel papelTrad = new Papel();
		papelTrad.setId(Papel.PAPEL_TRADUTOR);
		papelTrad.setNome("Tradutor");
		papelTrad.setDescricao("Usuário responsável pela tradução de artigos.");
		papelDao.save(papelTrad);
		
		Papel papelRev = new Papel();
		papelRev.setId(Papel.PAPEL_REVISOR);
		papelRev.setNome("Revisor de tradução");
		papelRev.setDescricao("Usuário responsável pela revisão da tradução.");
		papelDao.save(papelRev);
		
		Papel papelEd = new Papel();
		papelEd.setId(Papel.PAPEL_EDITOR);
		papelEd.setNome("Editor");
		papelEd.setDescricao("Usuário responsável pela edição do artigo.");
		papelDao.save(papelEd);
		
		Papel papelRevEd = new Papel();
		papelRevEd.setId(Papel.PAPEL_REV_EDICAO);
		papelRevEd.setNome("Revidor de Edição");
		papelRevEd.setDescricao("Usuário responsável pela revisão da edição do artigo.");
		papelDao.save(papelRevEd);
		
		Idioma pt_br = new Idioma(Idioma.PT_BR, "Português Brasileiro", "PT_BR");
		idiomaDao.save(pt_br);
		Idioma us = new Idioma(Idioma.EN_US, "Inglês", "EN_US");
		idiomaDao.save(us);
		Idioma jp = new Idioma(Idioma.JP, "Japonês", "JP");
		idiomaDao.save(jp);
	}

	
	
}
