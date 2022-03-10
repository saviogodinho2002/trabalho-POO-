package repository.filme;

import java.util.ArrayList;
import java.util.List;
import model.cliente.ClienteNaoPossuiFilmeException;
import model.filme.Filme;

public class RepositoryFilmeList implements RepositoryFilme {
	List<Filme> filmes;
	
	public RepositoryFilmeList() {
		filmes = new ArrayList<>();
	}
	
	@Override()
	public void cadastrarFilme(Filme filme) throws FilmeJaCadastradoException {
		try {
			buscarFilme(filme.getNome());
			throw new FilmeJaCadastradoException();
		} catch (FilmeNaoCadastradoException e) {
			filmes.add(filme);
		}
	}
	
	@Override()
	public void deletarFilme(Filme filme) throws FilmeNaoCadastradoException {
		if (!filmes.remove(filme)) {
			throw new FilmeNaoCadastradoException();
		}
	}
	
	@Override()
	public Filme buscarFilme(String nome) throws FilmeNaoCadastradoException {
		for (Filme filme : filmes) {
			if (filme.getNome().equals(nome) ) return filme;
		}
		throw new FilmeNaoCadastradoException();
	}
	
	@Override()
	public List<Filme> getAll() {
		return new ArrayList<>(filmes);
	}
}