package trab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Principal {
    private static ArrayList<Atleta> atletas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        int pontuacaoAcumulada;
        String busca;
        boolean foneExistente;
        
		do {
            System.out.println("1 - Listar");
            System.out.println("2 - Cadastrar");
            System.out.println("3 - Buscar");
            System.out.println("4 - Remover");
            System.out.println("5 - Sair");
            System.out.print("Opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

        switch (opcao) {
        
                case 1:
                	if (atletas.isEmpty()) {
                        System.out.println("0 atletas cadastrados");
                        return;
                    }
                	
                    System.out.println("1 - Por nome");
                    System.out.println("2 - Por pontuação");
                    opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao) {
                    
                    	case 1:	
                            Collections.sort(atletas, Comparator.comparing(Atleta::getNome));
                            break;
                            
                        case 2:
                            Collections.sort(atletas, Comparator.comparingInt(Atleta::getPontuacaoAcumulada).reversed());
                            break;
                            
                        default:
                            System.out.println("ERRO!!!");
                            return;
                    }

                    System.out.println("Lista de atletas:");
                    
                    for (Atleta atleta : atletas) {
                        System.out.println(atleta);
                    }
                    break;
                    
                case 2:
                	
                	System.out.println("Cadastrar Atleta:");
        	        System.out.print("Fone: ");
        	        String fone = scanner.nextLine();
        	        
        	        foneExistente = false; 
        	        
        	        for (Atleta atleta : atletas) {
        	            if (atleta.getFone().equals(fone)) {
        	                foneExistente = true;
        	                break;
        	            }
        	        }
        	        
        	        if (foneExistente) {
        	            System.out.println("Atleta com telefone cadastrado!!");  	           
        	        } else {
        	            System.out.print("Nome: ");
        	            String nome = scanner.nextLine();
        	            
        	            System.out.print("Apelido: ");
        	            String apelido = scanner.nextLine();
        	            
        	            System.out.print("Data de Nascimento: ");
        	            String dataNascimento = scanner.nextLine();
        	            
        	            System.out.print("Pontuação Acumulada: ");
        	            pontuacaoAcumulada = scanner.nextInt();
        	            scanner.nextLine(); 
        	            
        	            Atleta novoAtleta = new Atleta(fone, nome, apelido, dataNascimento, pontuacaoAcumulada);
        	            atletas.add(novoAtleta);
        	            System.out.println("Atleta cadastrado com sucesso.");
        	        }
                	
                    break;
                    
                case 3:
                	System.out.print("Digite o nome ou apelido do atleta: ");
                    busca = scanner.nextLine();

                    for (Atleta atleta : atletas) {
                        if (atleta.getNome().equalsIgnoreCase(busca) || atleta.getApelido().equalsIgnoreCase(busca)) {
                            System.out.println("Atleta encontrado:");
                            System.out.println(atleta);
                            return;
                        }
                    }
                    System.out.println("Nao encontrado!!!");
                    break;
                    
                case 4:	
                	 System.out.print("Digite quem vc deseja remover:");
                     busca = scanner.nextLine();

                     for (Atleta atleta : atletas) {
                         if (atleta.getNome().equalsIgnoreCase(busca) || atleta.getApelido().equalsIgnoreCase(busca)) {
                             atletas.remove(atleta);
                             System.out.println("Removido!!!");
                             return;
                         }
                     }
                     System.out.println("Nao encontrado!!!");
            
                    break;
                    
                case 5:
                    System.out.println("Voce saiu!!!");
                    break;
                default:
                    System.out.println("ERRO!!!!");
            }
        }
		
        while (opcao != 5);
		
    }
}


