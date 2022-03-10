package controller;

import model.cliente.Cliente;
import model.cliente.ClienteNaoPossuiFilmeEspecificoException;
import model.filme.ClienteNaoAlugouFilmeException;
import model.filme.Filme;
import repository.cliente.RepositoryCliente;
import repository.cliente.RepositoryClienteList;
import repository.cliente.CPFJaInseiroException;
import repository.cliente.ClienteNaoInseridoException;
import repository.filme.RepositoryFilme;
import repository.filme.RepositoryFilmeList;
import repository.genero.GeneroJaCadastradoException;
import repository.genero.GeneroNaoCadastradoException;
import repository.genero.RepositoryGeneroFilmeList;
import repository.genero.RepositoryGenerosList;
import repository.genero.RepositoryGeneros;
import repository.filme.FilmeJaCadastradoException;
import repository.filme.FilmeNaoCadastradoException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import controller.ControladorException;
import repository.aluguel.AluguelNaoCadastradoException;
import model.aluguel.AluguelRegistro;
import repository.aluguel.RepositoryAluguelRegistrosList;
import repository.aluguel.AluguelNaoCadastradoException;
import repository.aluguel.RepositoryAluguelRegistros;
import repository.aluguel.AluguelJaCadastradoException;

//controlador ainda em contrução;
public class ControladorLocadora {
	private RepositoryCliente repositorioCliente;
	private RepositoryFilme repositorioFilme;
	private RepositoryGenerosList repositorioGeneros;
	private RepositoryAluguelRegistrosList repositorioAluguel;
	
	public ControladorLocadora() {
		repositorioCliente = new RepositoryClienteList();
		repositorioFilme = new RepositoryFilmeList();
		repositorioGeneros = new RepositoryGenerosList();
		repositorioAluguel = new RepositoryAluguelRegistrosList();
	}
	
	//CLIENTES
	public void cadastrarcliente(Cliente cliente) throws CPFJaInseiroException {
		repositorioCliente.cadastrarCliente(cliente);
	}
	
	public Cliente buscarCliente(String cpf) throws ClienteNaoInseridoException {
		return repositorioCliente.buscarCliente(cpf);
	}
	
	public void cadastrarGenero(RepositoryGeneroFilmeList genero) throws GeneroJaCadastradoException {
		repositorioGeneros.cadastrarGenero(genero);
	}
	
	public void cadastrarFilmeToGenero(Filme f1, String genero) throws FilmeNaoCadastradoException, GeneroNaoCadastradoException, FilmeJaCadastradoException {
		//Filme f1 = repositorioFilme.buscarFilme(nome);
		RepositoryGeneroFilmeList g1 = repositorioGeneros.buscarGenero(genero);
		g1.cadastrarFilme(f1);
	}
	
	public void deletarFilmeFromGenero(Filme f1, String genero) throws FilmeNaoCadastradoException, GeneroNaoCadastradoException {
		
		RepositoryGeneroFilmeList g1 = repositorioGeneros.buscarGenero(genero);
		g1.deletarFilme(f1);
	}
	
	public void deletarCliente(Cliente cliente) throws ControladorException, ClienteNaoInseridoException {
		List<Filme> AllFilmes = this.getAllFilmesFromCliente(cliente.getCpf());
		if (AllFilmes.isEmpty()) {
			repositorioCliente.deletarCliente(cliente);
		} else {
			throw new ControladorException("Este Cliente n\u00e3o pode ser excluido");
		}
	}
	
	public List<Cliente> getAllCliente() {
		return repositorioCliente.getAll();
		//pega a lista de todos os clientes
	}
	
	//FILMES
	public void cadastrarFilme(Filme filme) throws FilmeJaCadastradoException {
		repositorioFilme.cadastrarFilme(filme);
	}
	
	public Filme buscarFilme(String nome) throws FilmeNaoCadastradoException {
		return repositorioFilme.buscarFilme(nome);
	}
	
	public void deletarFilme(Filme filme) throws ControladorException, FilmeNaoCadastradoException {
		if (filme.getQuantidade_estoque() == filme.getQuantidade()) {
			repositorioFilme.deletarFilme(filme);
		} else {
			throw new ControladorException("Este filme naoo pode ser excluido");
		}
	}
	
	public void deletarGenero(RepositoryGeneroFilmeList genero) throws GeneroNaoCadastradoException, ControladorException {
		if (genero.getAll().isEmpty()) {
			repositorioGeneros.deletarGenero(genero);
		} else {
			throw new ControladorException("Esse genero n\u00e3o pode ser exclu\u00eddo");
		}
	}
	
	public void alugarFilme(String cpf, String nome, String data) throws ClienteNaoInseridoException, FilmeNaoCadastradoException, ControladorException, ParseException, AluguelNaoCadastradoException {
		Cliente c1 = repositorioCliente.buscarCliente(cpf);
		Filme f1 = repositorioFilme.buscarFilme(nome);
		if (f1.getQuantidade_estoque() > 0) {
			c1.setFilmes(f1);
			f1.setQuantidade_estoque(f1.getQuantidade_estoque() - 1);
			
			AluguelRegistro aluguel = new AluguelRegistro(f1, c1, data);
			repositorioAluguel.cadastrarAluguel(aluguel);
			
			
		} else {
			throw new ControladorException("Os filmes em estoque acabaram");
		}
	}
	
	public void devolveFilme(String cpf, String nome) throws ClienteNaoInseridoException, FilmeNaoCadastradoException, ClienteNaoPossuiFilmeEspecificoException, ClienteNaoAlugouFilmeException, AluguelNaoCadastradoException {
		Cliente c1 = repositorioCliente.buscarCliente(cpf);
		Filme f1 = repositorioFilme.buscarFilme(nome);
		c1.devolverFilme(f1);
		f1.setQuantidade_estoque(f1.getQuantidade_estoque() + 1);
		repositorioAluguel.buscarAllAluguel(cpf, nome).setDevolvido(true);
		
	}
	
	public void devolveAllFilme(String cpf) throws ClienteNaoInseridoException, FilmeNaoCadastradoException, ClienteNaoPossuiFilmeEspecificoException, AluguelNaoCadastradoException {
		Cliente c1 = repositorioCliente.buscarCliente(cpf);
		for (Iterator<Filme> i = c1.getAllFilmes().iterator(); i.hasNext(); ) {
			//devolve todos os filmes
			Filme filme = i.next();
			c1.devolverFilme(filme);
			filme.setQuantidade_estoque(filme.getQuantidade_estoque() + 1);
			repositorioAluguel.buscarAllAluguel(cpf, filme.getNome()).setDevolvido(true);
			
			i.remove();
		}
	}
	

	public List<Filme> getAllFilmesFromCliente(String cpf) throws ClienteNaoInseridoException {
		Cliente c1 = repositorioCliente.buscarCliente(cpf);
		return c1.getAllFilmes();
	}
	
	public List<Filme> getAllFilme() {
		//pega a lista de todos os filmes
		return repositorioFilme.getAll();
	}
	
	public List<RepositoryGeneroFilmeList> getAllGeneros() {
		return repositorioGeneros.getAll();
	}
	
	public List<Filme> getAllFilmesFromGenero(String genero) throws GeneroNaoCadastradoException {
		RepositoryGeneroFilmeList g1 = repositorioGeneros.buscarGenero(genero);
		return g1.getAll();
	}
	
	//Aluguel
	public void cadastrarAluguel(AluguelRegistro Aluguel) throws AluguelJaCadastradoException {
		repositorioAluguel.cadastrarAluguel(Aluguel);
	}
	
	public void deletarAluguel(AluguelRegistro Aluguel) throws ControladorException, AluguelNaoCadastradoException {
		if (Aluguel.isDevolvido()) {
			throw new ControladorException("O REGISTRO DE ALUGUEL NAO PODE SER EXCLUIDO!!!");
		} else {
			repositorioAluguel.deletarAluguel(Aluguel);
		}
	}
	
	public AluguelRegistro buscarAllAlugueis(String cpf, String nome) throws FilmeNaoCadastradoException, AluguelNaoCadastradoException {
		return repositorioAluguel.buscarAllAluguel(cpf, nome);
	}
	
	public AluguelRegistro buscarAluguelNaoDevolvido(String cpf, String nome) throws AluguelNaoCadastradoException {
		return repositorioAluguel.buscarAluguelNaoDevolvido(cpf, nome);
	}
	
	public Boolean verificaAtraso(String cpf ,String nome, String data) throws ClienteNaoInseridoException, FilmeNaoCadastradoException, AluguelNaoCadastradoException, ParseException {
		Cliente c1 = repositorioCliente.buscarCliente(cpf);
		Filme f1 = repositorioFilme.buscarFilme(nome);
		AluguelRegistro aluguel =  repositorioAluguel.buscarAluguelNaoDevolvido(cpf, nome);
		aluguel.verificaAtrasado(data);
		return aluguel.isAtrasado();
	
	}
	
	public double calcDivida(String cpf, String nome, String data) throws ParseException, AluguelNaoCadastradoException, FilmeNaoCadastradoException, ClienteNaoInseridoException {
		Cliente c1 = repositorioCliente.buscarCliente(cpf);
		Filme f1 = repositorioFilme.buscarFilme(nome);
		AluguelRegistro aluguel =  repositorioAluguel.buscarAluguelNaoDevolvido(cpf, nome);
		
		return aluguel.calcDivida(data);
	}
	
	public List<AluguelRegistro> AllAlugueis() {
		//pega todos os alugues
		return repositorioAluguel.getAll();
	}
	
}