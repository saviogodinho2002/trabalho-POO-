package model.cliente;

import java.util.*;

import model.filme.Filme;
import repository.filme.FilmeNaoCadastradoException;

public class Cliente {
	
	private String nome;
	private int idade;
	private String cpf;
	
	private List<Filme> filmes;
	
	public Cliente(String nome, int idade, String cpf) 
	{
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.filmes = new ArrayList<>();
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
/* 	TODO:FAZER ISSO NA INTERFACE
	public void getFilmes() throws ClienteNaoPossuiFilmeException{
		if (!this.filmes.isEmpty())
		{
		for (Filme filme : this.filmes) {
			
			System.out.println(filme.getNome());
		}
		}else 
		{
			throw new ClienteNaoPossuiFilmeException();
			
		}
	}
*/
	public void setFilmes(Filme filme) { // alugar filme
		filmes.add(filme);
		//filme.setQuantidade_estoque(filme.getQuantidade_estoque() - 1); // temporario (fazer isso no controlador)	
	}
	
	public void devolverFilme(Filme filme) throws ClienteNaoPossuiFilmeEspecificoException//devolve 1 por vez
	{
		if(!filmes.remove(filme)) throw new ClienteNaoPossuiFilmeEspecificoException();
		//filme.setQuantidade_estoque(filme.getQuantidade_estoque() + 1);// temporario (fazer isso no controlador)
			
	}
	/* JA TA IMPLEMENTADO NO CONTRALADOR
	public void rmvAllFilmes() 
	{
		for (Iterator<Filme> i = filmes.iterator(); i.hasNext();) { //devolve todos os filmes
			
			 Filme filme = i.next();
			 filme.setQuantidade_estoque(filme.getQuantidade_estoque() + 1);	 
			 i.remove();
		}
	}
	*/
	/* INUTIL
	 
	public Boolean buscarFilmeCliente(String nome) {
		
		for (Filme filme : filmes) {
			if(filme.getNome().equals(nome)) return true;
			
		}
		return false;
		
		
	}
	*/
	public List<Filme> getAllFilmes() {
		
		  return new ArrayList<>(filmes);
	}


}
