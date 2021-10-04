package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

import controller.ControllerOpcaoResposta;
import controller.ControllerPergunta;
import controller.ControllerQuestinario;
import controller.ControllerTipoPergunta;
import model.OpcaoResposta;
import model.Pergunta;
import model.Questinario;
import model.TipoPergunta;

public class App {

    public static void main(String[] args) {
        
                  
            // Variavel utilizada para receber entrada do usuário, podemos iniciar um diagnóstico ou encerrar o sistema.
    		int opcao = -1;
    		
    		// Loop para que o usuário possa navegar no menu.
    		do {
    			
    			// Imprimir menu
    			menu();
    			
    	        System.out.print("\nDigite aqui sua opção: ");
    	        
    	        // Inicializando objeto Scanner, utilizado para receber entrada do usuário.
        		Scanner sc = new Scanner(System.in);
        		
        		// Aguardando usuário digitar uma opção de acordo com o menu.
        		try {
        			
        			opcao = sc.nextInt();
        			
        		} catch (InputMismatchException e) {
        			
                    System.out.println("\nOpção inválida! Tente novamente!");
                    
                }
        		
        		
    	        // Switch case para executar a opção escolhida pelo usuário.
    	        switch (opcao) {
    	        	case 1:
    	        		
    	        		cadastrarPerguntas();
    	        		break;
    	        		
    	        	// Case para listar questionarios e perguntas.
    	        	case 2:
    	        		
    	        		listarQuestionariosPerguntas();    	        		
    	        		break;
    	        		
    	            // Case para encerrar o sistema caso o usuário digite 0.
                    case 0:
                        System.out.println("\n****** FIM DO PROGRAMA ******");
                        System.exit(0);
                }
    		} while(opcao != 0);	
            
    		System.out.println("\n****** FIM DO PROGRAMA ******");

            // Encerra o sistema.
            System.exit(0);

           
    }
   	
   	private static void cadastrarPerguntas() {
   		  	
		Scanner sc = new Scanner(System.in);
    	int idQuestionario = 0;
    	int qtdPerguntasInformado = 0;
    	
    	listarQuestinarios();
    	
		try {
			
			System.out.println("\nInforme o questionário que deseja cadastrar perguntas: ");
			idQuestionario = sc.nextInt();
			
			if(ControllerQuestinario.existeQuestinario(idQuestionario)) {
				
				int idTipoResposta = 0;
				String enunciado = "";
				
				do {
				
					listarTiposPerguntas();
					
					System.out.println("\nInforme o tipo de pergunta: ");
					idTipoResposta = sc.nextInt();
					
					if(ControllerTipoPergunta.existeTipoPergunta(idTipoResposta)) {
						
						System.out.println("\nInforme o enunciado da pergunta: ");
						sc.nextLine();
						enunciado = sc.nextLine();
						
						Pergunta pergunta = new Pergunta();
						
						pergunta.setEnunciado(enunciado);
						pergunta.setIdQuestionario(idQuestionario);
						pergunta.setIdTipoPergunta(idTipoResposta);

						int idPergunta;
						idPergunta = ControllerPergunta.cadastrarPergunta(pergunta);
						
						if(idTipoResposta == 1 || idTipoResposta == 3) {
							
							List<OpcaoResposta> opcoesRespostas = new ArrayList<OpcaoResposta>();
							int qntOpcoesRespostas = 0;
							
							System.out.println("\nInforme a quantidade de opções de resposta: ");
							qntOpcoesRespostas = sc.nextInt();
							
							String descOpcaoResposta = "";
							sc.nextLine();
							for(int i=1; i <= qntOpcoesRespostas; i++) {
								
								System.out.println("\nInforme a opção de resposta Nº"+ i +": ");
								descOpcaoResposta = sc.nextLine();
								
								OpcaoResposta opcaoResposta = new OpcaoResposta();
								
								opcaoResposta.setDescricao(descOpcaoResposta);
								opcaoResposta.setIdPergunta(idPergunta);
								opcoesRespostas.add(opcaoResposta);
								
							}
							
							ControllerOpcaoResposta.cadastrarOpcaoResposta(opcoesRespostas);
							
						} 
						else if(idTipoResposta == 2) {
							
							List<OpcaoResposta> opcoesRespostas = new ArrayList<OpcaoResposta>();
							int qntOpcoesRespostas = 2;
							
							String descOpcaoResposta = "";
							//sc.nextLine();
							for(int i=1; i <= qntOpcoesRespostas; i++) {
								
								System.out.println("\nInforme a opção de resposta Nº"+ i +": ");
								descOpcaoResposta = sc.nextLine();
								
								OpcaoResposta opcaoResposta = new OpcaoResposta();
								
								opcaoResposta.setDescricao(descOpcaoResposta);
								opcaoResposta.setIdPergunta(idPergunta);
								opcoesRespostas.add(opcaoResposta);
								
							}
							
							ControllerOpcaoResposta.cadastrarOpcaoResposta(opcoesRespostas);
			            	
						}
						
						String resposta = "";
		    	    	do {
		    	    		
				            System.out.println("\nDeseja informar mais uma pergunta? [S/N]");
				            resposta = sc.next();
				            
		            	} while((!resposta.equalsIgnoreCase("s")) && (!resposta.equalsIgnoreCase("n")));
		            	
		            	if (resposta.equalsIgnoreCase("n")) {
		            		
		                    break;
		                    
		            	}
						
					} else {
						
						System.out.println("\nTipo pergunta não existe!");
						
					}
				
				} while(true);
				
			} else {
				
				System.out.println("\nQuestionário não existe!\n");
				
			}
			
		} catch (InputMismatchException e) {
			
			System.out.println("\nOpção inválida! Tente novamente!");
			
		}
		
   	}
   	
   	private static void listarQuestionariosPerguntas() {
   		
   		Scanner sc = new Scanner(System.in);
   		int idQuestionario = 0;
   		
   		do {
   			
	   		listarQuestinarios();
	   		System.out.println("\nInforme o questinário que deseja listar as perguntas: ");
	   		idQuestionario = sc.nextInt();
	   		
	   		if(ControllerQuestinario.existeQuestinario(idQuestionario)) {
	   			
	   			List<Pergunta> perguntas = ControllerPergunta.buscarTodos();
	   			
	   			if(perguntas.size() > 0) {
	   				for(int i=1; i <= perguntas.size(); i++) {

	        			System.out.print("\n"+ i + ") ");
	            		System.out.println(perguntas.get(i-1).getEnunciado() +"?");
	            		
	            		List<OpcaoResposta> opcoesPerguntas = ControllerOpcaoResposta.buscarOpcoesRespostas(perguntas.get(i-1).getId());
	            		
	            		if(opcoesPerguntas.size() > 0) {
	            			
	            			for(int k=1; k <= opcoesPerguntas.size(); k++) {
	                			
	                			System.out.print("\t"+ k +" - ");
	                			System.out.println(opcoesPerguntas.get(k-1).getDescricao());
	                			
	                		}
	            			
	            		}
	            		
	        		}

	   			}
        		        		
        		break;
				
			} else {
				
				System.out.println("\nQuestionário não existe!");
				
			}
   		
   		} while(true);
   		
   		
   	}
   	
    // Metodo para imprimir o menu principal.
   	private static void menu () {
           System.out.println("\n ********* Sistema de Questinário *********");
           System.out.println(" * Escolha uma das opções abaixo **********");
           System.out.println(" * 1 -> Cadastrar perguntas ***************");
           System.out.println(" * 2 -> Listar questinarios e perguntas ***");
           System.out.println(" * 0 -> Sair ******************************");
           System.out.println(" ******************************************");	
   	}
   	
   	private static void listarQuestinarios() {
   		
		List<Questinario> questinarios = ControllerQuestinario.buscarTodosQuestionarios();
		
		System.out.println("\n>>>> Questionários <<<");
		
		for(int i=0; i < questinarios.size(); i++) {
    		System.out.print(questinarios.get(i).getId() + " - ");
    		System.out.print(questinarios.get(i).getDescricao()+"\n");
		}

   	}
   	
   	private static void listarTiposPerguntas() {
   		
		List<TipoPergunta> tiposPerguntas = ControllerTipoPergunta.buscarTodosTiposPerguntas();
		
		System.out.println("\n>>>> Tipos de Perguntas <<<");
		
		for(int i=0; i < tiposPerguntas.size(); i++) {
    		System.out.print(tiposPerguntas.get(i).getId() + " - ");
    		System.out.print(tiposPerguntas.get(i).getDescricao()+"\n");
		}

   	}
    
}
