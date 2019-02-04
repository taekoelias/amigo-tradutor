package br.com.amigotradutor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames = { "numero","artigo_id" }))
public class Volume {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "artigo_id")
    private Artigo artigo;
 
    private long numero;
	
    private String titulo;

    public Volume() {
    }

    public Volume(long id) {
            super();
            this.id = id;
    }

    public Volume(long id, long numero, String titulo, long artigo) {
            super();
            this.id = id;
            this.numero = numero;
            this.artigo = new Artigo(artigo);
            this.titulo = titulo;
    }

    public long getId() {
            return id;
    }

    public void setId(long id) {
            this.id = id;
    }

    public String getTitulo() {
            return titulo;
    }

    public void setTitulo(String titulo) {
            this.titulo = titulo;
    }

    public Artigo getArtigo() {
            return artigo;
    }

    public void setArtigo(Artigo artigo) {
            this.artigo = artigo;
    }

    public long getNumero() {
            return numero;
    }

    public void setNumero(long numero) {
            this.numero = numero;
    }
	
}
