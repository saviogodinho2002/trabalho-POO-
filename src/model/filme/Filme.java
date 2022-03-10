package model.filme;

import java.util.ArrayList;
import java.util.List;

import model.cliente.Cliente;

public class Filme {
	private String nome;
	private int classificacao_indicativa;
	private int quantidade;
	private int quantidade_estoque;
	private String produtora;
	private String genero;
	
	
	public Filme(String nome, String genero, int classificacao_indicativa, String produtora, int quantidade) {
		this.nome = nome;
		this.classificacao_indicativa = classificacao_indicativa;
		this.produtora = produtora;
		this.quantidade = quantidade;
		this.quantidade_estoque = quantidade;
		this.genero = genero;
		
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getClassificacao_indicativa() {
		return classificacao_indicativa;
	}
	
	public void setClassificacao_indicativa(int classificacao_indicativa) {
		this.classificacao_indicativa = classificacao_indicativa;
	}
	
	public String getProdutora() {
		return produtora;
	}
	
	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override()
	public String toString() {
		return this.nome + " " + this.produtora + " " + this.classificacao_indicativa + " " + this.quantidade_estoque + "/" + this.quantidade;
	}
	
	public int getQuantidade_estoque() {
		return quantidade_estoque;
	}
	
	public void setQuantidade_estoque(int quantidade_estoque) {
		this.quantidade_estoque = quantidade_estoque;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
}