package br.com.alura.loja.modelo;

import com.thoughtworks.xstream.XStream;

public class Projeto {
	private String nome; 
	private long id;
	private int anoDeInicio;
	
	public Projeto(String nome, long id, int anoDeInicio) {
		this.nome = nome;
		this.id = id;
		this.anoDeInicio = anoDeInicio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAnoDeInicio() {
		return anoDeInicio;
	}

	public void setAnoDeInicio(int anoDeInicio) {
		this.anoDeInicio = anoDeInicio;
	}

	public String toXml() {
		return new XStream().toXML(this);
	}
	
	
}
