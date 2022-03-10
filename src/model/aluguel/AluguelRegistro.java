package model.aluguel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.cliente.Cliente;
import model.filme.Filme;

public class AluguelRegistro {
	private Cliente cliente;
	private Filme filme;
	private Date momentoLocacao;
	private Date finalLocacao;
	private SimpleDateFormat converter;
	private double precoLocacao;
	private Boolean atrasado;
	private Boolean devolvido;
	
	public AluguelRegistro(Filme filme, Cliente cliente, String data) throws ParseException {
		this.cliente = cliente;
		this.filme = filme;
		momentoLocacao = new Date();
		converter = new SimpleDateFormat("dd-MM-yyyy");
		finalLocacao = converter.parse(data);
		precoLocacao = 50;
		atrasado = false;
		devolvido = false;
		
	}
	
	public double calcDivida(String data) throws ParseException {
		Date dataEntrega = converter.parse(data);
		this.verificaAtrasado(data);
		if (this.isAtrasado()) {
			return precoLocacao;
		} else {
			return (((dataEntrega.getTime() / 1000) / 86400) - ((this.finalLocacao.getTime() / 1000) / 86400)) + precoLocacao;
		}
	}
	
	public void verificaAtrasado(String data) throws ParseException {
		Date dataEntrega = converter.parse(data);
		if (this.finalLocacao.getTime() >= dataEntrega.getTime()) {
			this.setAtrasado(false);
		} else {
			this.setAtrasado(true);
		}
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Filme getFilme() {
		return filme;
	}
	
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
	public Date getMomentoLocacao() {
		return momentoLocacao;
	}
	
	public void setMomentoLocacao(Date momentoLocacao) {
		this.momentoLocacao = momentoLocacao;
	}
	
	public Date getFinalLocacao() {
		return finalLocacao;
	}
	
	public void setFinalLocacao(Date finalLocacao) {
		this.finalLocacao = finalLocacao;
	}
	
	public double getPrecoLocacao() {
		return precoLocacao;
	}
	
	public void setPrecoLocacao(double precoLocacao) {
		this.precoLocacao = precoLocacao;
	}
	
	@Override()
	public String toString() {
		return "Cliente........:" + cliente.getNome() + 
		       "\nFilme..........: " + filme.getNome() + 
		       "\nData de Aluguel: " + momentoLocacao + 
		       "\nPreço..........: R$" + precoLocacao;
	}
	
	public Boolean isAtrasado() {
		return atrasado;
	}
	
	public void setAtrasado(Boolean atrasado) {
		this.atrasado = atrasado;
	}
	
	public Boolean isDevolvido() {
		return devolvido;
	}
	
	public void setDevolvido(Boolean devolvido) {
		this.devolvido = devolvido;
	}

}