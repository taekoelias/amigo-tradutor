package br.com.amigotradutor.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames = { "numero","artigo_id","volume_id" }))
public class Capitulo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "volume_id")
    private Volume volume;
 
    @ManyToOne
    @JoinColumn(name = "artigo_id")
    private Artigo artigo;
    
    private long numero;

    private String tituloTraduzido;

    private String tituloOriginal;

    @Temporal(TemporalType.DATE)
    private Date publicacao;

    public Capitulo(long id, long numero, String tituloTraduzido, String tituloOriginal, long artigo, long volume, Date publicacao) {
            super();
            this.id = id;
            this.numero = numero;
            this.artigo = new Artigo(artigo);
            this.volume = new Volume(volume);
            this.tituloTraduzido = tituloTraduzido;
            this.tituloOriginal = tituloOriginal;
            this.publicacao = publicacao;
    }

    public Capitulo() {
    }

    public long getId() {
            return id;
    }

    public void setId(long id) {
            this.id = id;
    }

    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
    }

    public Artigo getArtigo() {
        return artigo;
    }

    public Volume getVolume() {
            return volume;
    }

    public void setVolume(Volume volume) {
            this.volume = volume;
    }

    public long getNumero() {
            return numero;
    }

    public void setNumero(long numero) {
            this.numero = numero;
    }

    public String getTituloTraduzido() {
            return tituloTraduzido;
    }

    public void setTituloTraduzido(String tituloTraduzido) {
            this.tituloTraduzido = tituloTraduzido;
    }

    public String getTituloOriginal() {
            return tituloOriginal;
    }

    public void setTituloOriginal(String tituloOriginal) {
            this.tituloOriginal = tituloOriginal;
    }

    public Date getPublicacao() {
            return publicacao;
    }

    public void setPublicacao(Date publicacao) {
            this.publicacao = publicacao;
    }
	
}
