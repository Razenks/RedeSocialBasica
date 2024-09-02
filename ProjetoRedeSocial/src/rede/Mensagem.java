package rede;

import java.util.ArrayList;

public class Mensagem {
	
	private String texto;
	private Integer id;
	private ArrayList<Comentario> post;
	
	public Mensagem(String texto, Integer id) {
		this.texto = texto;
		this.id = id;
		this.post = new ArrayList<>();
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Integer getId() {
		return id;
	}

	public ArrayList<Comentario> getPost() {
		return post;
	}
	
	
	
	
}
