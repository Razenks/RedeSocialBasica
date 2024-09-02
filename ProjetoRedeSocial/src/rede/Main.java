package rede;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre  com o nome do usuario:");
		Usuario user = new Usuario(sc.next());
		
		System.out.println("Entre  com o nome do amigo 1");
		Usuario amigo1 = new Usuario(sc.nextLine());
		
		System.out.println("Entre  com o nome do amigo 2");
		Usuario amigo2 = new Usuario(sc.nextLine());
		
		user.adicionarAmigo(amigo1);
		user.adicionarAmigo(amigo2);
		Integer msgCounter = 1;
		Integer cont = 1;
		for(Usuario amg : user.getAmigos()) {
			
			System.out.println("entre com a mensagem 1 do amigo" +cont.toString());
			amg.getPublicacoes().add(new Mensagem(sc.nextLine(),msgCounter));
			msgCounter += 1;
			
			System.out.println("entre com a mensagem 2 do amigo" +cont.toString());
			amg.getPublicacoes().add(new Mensagem(sc.nextLine(),msgCounter));
			msgCounter += 1;
		}
		Integer opcao;
		
		do {
			System.out.println("Qual acao deseja realizar: ");
			System.out.println("[1] - Listar Amigos ");
			System.out.println("[2] - Listar Mensagens dos Amigos ");
			System.out.println("[3] - Comentar Mensagem ");
			System.out.println("[0] - Sair");
			
		    opcao = sc.nextInt();
			
			switch(opcao) {
			case 1:
				for(Usuario amg : user.getAmigos()) {
					System.out.println("---------------");
					System.out.println("nome: "+amg.getNome());
					System.out.println("---------------");
				}
				break;
			case 2:
				for(Usuario amg : user.getAmigos()) {
					for(Mensagem msg : amg.getPublicacoes()) {
						System.out.println("---------------");
						System.out.println("Mensagem" +amg.getNome());
						System.out.println("---------------");
						System.out.println("id" + msg.getId());
						System.out.println("---------------");
						System.out.println(msg.getTexto());
						for(Comentario cmt:msg.getPost()) {
							System.out.println("----------------");
							System.out.println("Comentario:");
							System.out.println(cmt.getTexto());
						}
						}
				}
				break;
			case 3:
				System.out.println("Informe o ID da mensagem que deseja comentar");
				Integer idMsgm = sc.nextInt();
				Mensagem msgModif = null;
				for(Usuario amg:user.getAmigos()) {
					for(Mensagem msg:amg.getPublicacoes()) {
						if(msg.getId() ==idMsgm)
							msgModif = msg;
					}
				}
				
				if(msgModif != null) {
					user.comentarFeed(msgModif);
				}
				else
					System.out.println("Nao existe messagem com id informado");
				break;
			case 0:
				
				break; 
			default:
				System.out.println("Opcao invalida");
			}
		} while(opcao != 0);		
	}

}
