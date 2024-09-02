package rede;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	private String nome;
	private ArrayList<Usuario> amigos;
	private ArrayList<Mensagem> publicacoes;
	
	public Usuario(String nome) {
		this.nome = nome;
		this.amigos = new ArrayList<Usuario>();
		this.publicacoes = new ArrayList<Mensagem>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Usuario> getAmigos() {
		return amigos;
	}

	public ArrayList<Mensagem> getPublicacoes() {
		return publicacoes;
	}
	
	public void publicarMensagem(Integer id){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com a mensagem");
		String txt = sc.nextLine();
		Mensagem msg = new Mensagem(txt, id);
	}
	
	public void adicionarAmigo(Usuario amigo) {
		
		this.amigos.add(amigo);
		System.out.println("Adicionado com Sucesso! ;D");
	}
	
	public void visualizarFeed() {
		
		for(Usuario amigo:this.amigos) {
			for(Mensagem msg:amigo.getPublicacoes()) {
				System.out.println("-----------------------------------------------------------------");
				System.out.println("Id "+msg.getId().toString());
				System.out.println(msg.getTexto());
				System.out.println("-----------------------------------------------------------------");
			}
		}
	}
	
	public void comentarFeed(Mensagem msg) {
		System.out.println("Entre com seu comentario a ser adicionado a mensagem");
		Scanner sc = new Scanner(System.in);
		String coment = sc.nextLine();
		msg.getPost().add(new Comentario(coment));
	}
}
