package main;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.List;

import controller.ControladorLocadora;
import model.aluguel.AluguelRegistro;
import model.cliente.Cliente;
import model.filme.Filme;
import repository.cliente.ClienteNaoInseridoException;
import repository.filme.FilmeJaCadastradoException;
import repository.filme.FilmeNaoCadastradoException;
import repository.genero.GeneroNaoCadastradoException;
import repository.genero.RepositoryGeneroFilmeList;
import repository.genero.RepositoryGeneros;

public class ProgramaLocadora {
	
	static ControladorLocadora controlador;
	static  Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		controlador = new ControladorLocadora();
		insereIniciais();
		int opcao;
		//TODO: TERMINAR ESSA PORRA AQUI
		 do {
	            limpaTela();
	            System.out.println(">>>>>>>> LOCADORA - MENU <<<<<<<<<");
	            System.out.println("==================================");
	            System.out.println();
	            System.out.println("<1> PORTAL DO CLIENTE ");
	            System.out.println("<2> PORTAL DO LOCADORA");
	            System.out.println("<3> FILMES DO CLIENTE");
	            System.out.println("<0> SAIR");
	            System.out.println();
	            System.out.print("Escolha uma opção: ");

	            try {
	                opcao = Integer.valueOf(scanner.nextLine());
	            } catch (Exception e) {
	                opcao = 0;
	            }

	            switch (opcao) {
	                case 0:
	                    limpaTela();
	                    break;
	                case 1:
	                    portalCliente();
	                    break;
	                case 2:
	                    portalLocadora();
	                    break;
	                case 3:
	                    filmesDoClinte();
	                    break;
	            }
	        } while (opcao != 0);

	        
	        System.out.println("Programa terminado");
	        
	    }
		private static void portalLocadora() {
			try {
				limpaTela();
				System.out.println(">>>> LOCADORA - PORTAL DA LOCADORA <<<<<");
				System.out.println("========================================");
				System.out.println();
				int opcao;
				//TODO: terminar essa pica aqui tbm
				//aqui o cliente vai escolher se ele quer devolver o filme ou alugar ou outra coisa
				
				  do {
		                limpaTela();
		            	  System.out.println(">>>> LOCADORA - PORTAL DA LOCADORA <<<<<");
						        System.out.println("========================================");
		                System.out.println();
		                System.out.println("<1> CADASTRAR NOVO FILME");
		                System.out.println("<2> EXCLUIR FILME");
		                System.out.println("<3> CADASTRAR NOVO CLIENTE");
		                System.out.println("<4> EXCLUIR CLIENTE");
		                System.out.println("<5> LISTAR ALUGUEIS");
		                System.out.println("<0> SAIR");
		                System.out.println();
		                System.out.print("Escolha uma opção: ");

		                try {
		                    opcao = Integer.valueOf(scanner.nextLine());
		                } catch (Exception e) {
		                    opcao = 0;
		                }

		                switch (opcao) {
		                    case 0:
		                        limpaTela();
		                        break;
		                    case 1:
		                        limpaTela();
		                        incluirFilme();
		                        break;
		                    case 2:
		                       limpaTela();
		                       removerFilme();
		                       break;
		                    case 3:
			                     limpaTela();
			                     incluirCliente();
		                       break;
		                    case 4:
			                      limpaTela();
			                      removerCliente();
		                        break;
		                    case 5:
		                    	  limpaTela();
		                    	  showAllAluguei();
		                    	  break;
		                 
		                }
		            } while (opcao != 0);
				

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println();
	        System.out.println("tecle <enter> para voltar");
	        scanner.nextLine();
	        
			
			
		}
	
		private static void portalCliente() {
			try {
				limpaTela();
				System.out.println(">>>> LOCADORA - PORTAL DO CLIENTE <<<<<");
				System.out.println("=======================================");
				System.out.println();
				System.out.print("CPF do cliente: ");
				String cpf =  scanner.nextLine();
				controlador.buscarCliente(cpf);
				int opcao;
				//TODO: terminar essa pica aqui tbm
				//aqui o cliente vai escolher se ele quer devolver o filme ou alugar ou outra coisa
				
				  do {
		                limpaTela();
		                System.out.println(">>>> LOCADORA - PORTAL DO CLIENTE <<<<<");
						        System.out.println("=======================================");
		                System.out.println();
		                System.out.println("<1> ALUGAR FILME");
		                System.out.println("<2> DEVOLVER FILME");
		                System.out.println("<0> SAIR");
		                System.out.println();
		                System.out.print("Escolha uma opção: ");

		                try {
		                    opcao = Integer.valueOf(scanner.nextLine());
		                } catch (Exception e) {
		                    opcao = 0;
		                }

		                switch (opcao) {
		                    case 0:
		                        limpaTela();
		                        break;
		                    case 1:
		                        escolherGenero(cpf); 
		                        break;
		                    case 2:
		                        devolverFilme();
		                        break;
		                 
		                }
		            } while (opcao != 0);
				

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			System.out.println();
	        System.out.println("tecle <enter> para voltar");
	        scanner.nextLine();
	        
		}
		private static void escolherGenero(String cpf) {
			//TODO: TERMINAR ISSO AQUI TBM
			//daqui ele vai pra outro metodo (que tu vai criar) que vai pegar esse genero e mostrar uma lista
			//lista dos filmes que tem nesse genero, pro usuario alugar o filme ele vai ter que teclar o nome dele(do filme)
			int opcao; 
			do {
				 	
	                limpaTela();
	                System.out.println(">>>>> LOCADORA - LISTA DE GENEROS <<<<<");
					        System.out.println("=======================================");
	                System.out.println();
	                System.out.println("<1> FICÇÃO CIENTIFICA");
	                System.out.println("<2> AÇÃO");
	                System.out.println("<3> ANIME");
	                System.out.println("<4> TERROR");
	                System.out.println("<5> INFANTIL");
	                System.out.println("<6> COMEDIA");
	                System.out.println("<0> Menu Principal");
	                System.out.println();
	                System.out.print("Escolha uma opção: ");

	                try {
	                    opcao = Integer.valueOf(scanner.nextLine());
	                } catch (Exception e) {
	                    opcao = 0;
	                }

	                switch (opcao) {
	                    case 0:
	                        limpaTela();
	                        break;
	                    case 1:
	                        listarFilmesToCliente(cpf,"FICÇÃO CIENTIFICA");
	                        break;
	                    case 2:
	                        listarFilmesToCliente(cpf,"AÇÃO");
	                        break;
	                    case 3:
	                        listarFilmesToCliente(cpf,"TERROR");
	                        break;
	                    case 4:
	                        listarFilmesToCliente(cpf,"ANIME");
	                        break;
	                    case 5:
	                        listarFilmesToCliente(cpf,"INFANTIL");
	                        break;
	                    case 6:
	                        listarFilmesToCliente(cpf,"COMEDIA");
	                        break;
	                }
	            } while (opcao != 0);
			
		}
		private static void showAllAluguei() {
			List<AluguelRegistro> alugueis = controlador.AllAlugueis();
			System.out.println("===================================================================");
		  for (AluguelRegistro aluguel: alugueis) {
				System.out.print(aluguel.getCliente().getNome()+ " ");
				System.out.print(" || ");
				System.out.print(aluguel.getFilme().getNome() + " ") ;
				System.out.print(" || ");
				SimpleDateFormat converter  = new SimpleDateFormat("dd-MM-yyyy");
				System.out.print(converter.format(aluguel.getMomentoLocacao()));
			}
			System.out.println();
			  System.out.println("tecle <enter> para voltar");
			    scanner.nextLine();
		}
	
	  private static void filmesDoClinte() {
		  limpaTela();
		  
		  try{
			 System.out.printf("CPF DO CLIENTE: ");
		   String cpf = scanner.nextLine();
			 List<Filme> filmes = controlador.getAllFilmesFromCliente(cpf);
		  
		   System.out.println("\nFILMES DO CLIENTE ");
			 System.out.println("=======================");
			
		   for (Filme filme: filmes) {
			     System.out.printf("+ %s\n\n", filme.getNome());
			 }
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		
			System.out.println();
			System.out.println("tecle <enter> para voltar");
			scanner.nextLine();
		}
	
	
	
	
	
	
		private static void listarFilmesToCliente(String cpf,String genero) {
			limpaTela();
		  
		 try {
			  List<Filme> filmes = controlador.getAllFilmesFromGenero(genero);
			  System.out.println("LISTA DE FILMES");
			  System.out.println("=================");
			 
			 
		   for(Filme filme : filmes){
			   
		       System.out.printf("+ %s - %d\n\n", filme.getNome(), filme.getQuantidade_estoque());
				 
		   }
		   
		   System.out.printf("NOME DO FILME: ");
		   String nome = scanner.nextLine().toUpperCase();
			
		   System.out.printf("DATA DE DEVOLUÇÃO (DD-MM-YYYY): ");
		   String data = scanner.nextLine();
			 
			 limpaTela();
			 System.out.println("REGISTRO DE ALUGUEL");
			 System.out.println("===================");
			
		   controlador.alugarFilme(cpf, nome, data);
		   System.out.println(controlador.buscarAllAlugueis(cpf,nome) );
			}catch (Exception e) {
				System.err.println(e.getMessage());
			}
		  
		  System.out.printf("Filme Alugado!!!\n\n");
		  System.out.println();
		  System.out.println("tecle <enter> para voltar");
	    scanner.nextLine();
		
		}
	
	  private static void devolverFilme() {
	    limpaTela();
		  
		  try{
		    System.out.println("DEVOLUÇÃO DE FILME");
			  System.out.println("==================");
			
			  System.out.printf("NOME DO FILME: ");
			  String nome = scanner.nextLine().toUpperCase();
			
			  System.out.printf("SEU CPF: ");
			  String cpf = scanner.nextLine();
			
			  System.out.printf("DATA DE DEVOLUÇÃO (dd-mm-yyyy): ");
			  String data = scanner.nextLine();
			  
			  if(controlador.verificaAtraso(cpf, nome, data)) System.out.println("O filme esta atrasado, você pagará o valor com multa.");;
			  System.out.println(controlador.buscarAluguelNaoDevolvido(cpf,nome) );
			  System.out.print("\ninsira um valor: ");
			  double dinheiro =  scanner.nextDouble();
			  if(dinheiro > controlador.calcDivida(cpf, nome, data)) {
				  
				  System.out.println("Aqui esta o seu troco de R$" + (dinheiro - controlador.calcDivida(cpf, nome, data)));
				  controlador.devolveFilme(cpf, nome);
				  System.out.println("Filme devolvido");
				  
			  }else if (dinheiro < controlador.calcDivida(cpf, nome, data)) {
				  
				  System.out.println("Dinheiro insuficiente");
				  
			  }else {
				  controlador.devolveFilme(cpf, nome);
				  System.out.println("Filme devolvido");
			  }
			 
	
			  
	
		  }catch(Exception e){
		     System.err.println(e.getMessage());
		  }
		  System.out.println("tecle <enter> para voltar");
	    scanner.nextLine();
		
	  }

		private static void incluirFilme() {
			limpaTela();
			 System.out.println("Cadastro de Filme");
		     System.out.println("=================");
		     System.out.println();
			try {
				System.out.print("Nome do Filme: ");
				String nome = scanner.nextLine().toUpperCase();
				
				System.out.print("Nome do Estudio: ");
				String estudio =  scanner.nextLine().toUpperCase();
				
				System.out.print("Classificação indicativa: ");
				int classi = Integer.valueOf(scanner.nextLine());
				
				System.out.print("Genero do filme: ");
				String genero = scanner.nextLine().toUpperCase();
				
				System.out.print("Numero de cópias: ");
				int num = Integer.valueOf(scanner.nextLine());
				
				Filme filme = new Filme(nome, genero, classi, estudio, num);
				
				controlador.cadastrarFilmeToGenero(filme, genero);
				controlador.cadastrarFilme(filme);
				
			}catch (Exception e) {
				System.err.println(e.getMessage());
				}
			System.out.println("");
			System.out.println("tecle <enter> para voltar");
	        scanner.nextLine();
			
		}
		private static void incluirCliente() {
			limpaTela();
			 System.out.println("Cadastro de Cliente");
		     System.out.println("=================");
		     System.out.println();
			try {
				System.out.print("Nome do Cliente: ");
				String nome = scanner.nextLine().toUpperCase();
				
				System.out.print("CPF do cliente: ");
				String cpf =  scanner.nextLine();
				
				System.out.print("Idade do cliente: ");
				int idade = Integer.valueOf(scanner.nextLine());
				
				Cliente cliente = new Cliente(nome, idade, cpf);
				controlador.cadastrarcliente(cliente);
				
				
			}catch (Exception e) {
				System.err.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("tecle <enter> para voltar");
	        scanner.nextLine();
			
		}
		
		private static void removerFilme() {
			 System.out.print("Nome do Filme: ");
		     String nome = scanner.nextLine().toUpperCase();
		     try {
		    	 Filme filme = controlador.buscarFilme(nome);
		    	 System.out.println();
		    	 System.out.println("Nome: " + filme.getNome() );
		    	 System.out.println("Classificação indicativa: " + filme.getClassificacao_indicativa());
		    	 System.out.println("Estudio " + filme.getProdutora());
		    	 System.out.println("Genero: " + filme.getGenero());
		    	 
		    	 System.out.print("Exclui esse filme? (s/n)?");
		            String resposta = scanner.nextLine();

		            if (resposta.equalsIgnoreCase("s")) {
		            	try {
		            		controlador.deletarFilme(filme);
		            		controlador.deletarFilmeFromGenero(filme, filme.getGenero());
		            		System.out.println("filme excluído");
		            	}catch (Exception e) {
		            		System.err.println(e.getMessage());		
		            		e.printStackTrace();
		            	}
		            	
		            }
		    	     	 
			} catch (FilmeNaoCadastradoException e) {
				System.out.println(e.getMessage());
				
			}
		 	System.out.println("");
		     System.out.println("tecle <enter> para voltar");
		        scanner.nextLine();
				
		}
			
		private	static void removerCliente(){
			 System.out.print("CPF do Cliente: ");
		     String cpf = scanner.nextLine();
		     try {
		    	 Cliente cliente = controlador.buscarCliente(cpf);
		    	 System.out.println();
		    	 System.out.println("Nome: " + cliente.getNome() );
		    	 System.out.println("Idade: " + cliente.getIdade());
		    	 System.out.println("CPF: " + cliente.getCpf());
		    	
		    	 
		    	 System.out.print("Exclui esse Cliente? (s/n)?");
		            String resposta = scanner.nextLine();

		            if (resposta.equalsIgnoreCase("s")) {
		            	try {
		            		controlador.deletarCliente(cliente);
		            		System.out.println("Cliente excluído");
		            	}catch (Exception e) {
		            		System.err.println(e.getMessage());				
		            	}
		            	
		            }
		    	     	 
			} catch (ClienteNaoInseridoException e) {
				System.err.println(e.getMessage());	
			}
		 	System.out.println("");
		     System.out.println("tecle <enter> para voltar");
		        scanner.nextLine();
				
		}
		
		
	private static void insereIniciais() {
		
		try {
			Filme filme01 =  new Filme("DE VOLTA PRO FUTURO","FICÇÃO CIENTIFICA", 12, "UNIVERSAL", 10);
			Filme filme02 = new Filme("EXTERMINADOR DO FUTURO", "AÇÃO", 18, "SONY PICTURES", 12);
			Filme filme03 =  new Filme("TOY STORY", "INFANTIL", 0 , "PIXAR", 20);
			Filme filme04 = new Filme("INTERESTELAR","FICÇÃO CIENTIFICA", 18,"ANITUBE", 12);
			
			RepositoryGeneroFilmeList genero01 =  new RepositoryGeneroFilmeList("FICÇÃO CIENTIFICA");
			RepositoryGeneroFilmeList genero02 =  new RepositoryGeneroFilmeList("AÇÃO");
			RepositoryGeneroFilmeList genero03 =  new RepositoryGeneroFilmeList("INFANTIL");
			
			RepositoryGeneroFilmeList genero04 =  new RepositoryGeneroFilmeList("COMÉDIA");
			RepositoryGeneroFilmeList genero05 =  new RepositoryGeneroFilmeList("TERROR");
			RepositoryGeneroFilmeList genero06 =  new RepositoryGeneroFilmeList("ANIME");
			
			controlador.cadastrarGenero(genero01);
			controlador.cadastrarGenero(genero02);
			controlador.cadastrarGenero(genero03);
			controlador.cadastrarGenero(genero04);
			controlador.cadastrarGenero(genero05);
			controlador.cadastrarGenero(genero06);
			
			controlador.cadastrarFilme(filme01);
			controlador.cadastrarFilme(filme02);
			controlador.cadastrarFilme(filme03);
			controlador.cadastrarFilme(filme04);
			
			controlador.cadastrarFilmeToGenero(filme01,filme01.getGenero() );
			controlador.cadastrarFilmeToGenero(filme02,filme02.getGenero() );
			controlador.cadastrarFilmeToGenero(filme03,filme03.getGenero() );
			controlador.cadastrarFilmeToGenero(filme04,filme04.getGenero() );
			
			Cliente cliente01 =  new Cliente("RAMON BARBOSA", 19, "696969");
			Cliente cliente02 = new Cliente("LORENZO ALBERTO", 12, "171717");
			Cliente cliente03 = new Cliente("SANDRA DOS REMEDIOS", 8, "666999");
			
			controlador.cadastrarcliente(cliente01);
			controlador.cadastrarcliente(cliente02);
			controlador.cadastrarcliente(cliente03);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	 private static void limpaTela() {
	        for (int i = 0; i < 25; i++) {
	            System.out.println();
	        }
	 }
	 
	 
	 

}
