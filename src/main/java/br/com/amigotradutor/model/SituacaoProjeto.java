package br.com.amigotradutor.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class SituacaoProjeto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Projeto projeto;
	
	@OneToOne
	private TipoSituacaoProjeto tipo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	
	@ManyToOne
	private Usuario usuario;
	
	public SituacaoProjeto() {
	}

	public SituacaoProjeto(long id, Projeto projeto, long tipo, Date dataCadastro, long usuario) {
		super();
		this.id = id;
		this.projeto = projeto;
		this.tipo = new TipoSituacaoProjeto(tipo, null);
		this.dataCadastro = dataCadastro;
		this.usuario = new Usuario(usuario);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public TipoSituacaoProjeto getTipo() {
		return tipo;
	}

	public void setTipo(TipoSituacaoProjeto tipo) {
		this.tipo = tipo;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
