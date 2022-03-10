package repository.filme;

import java.util.List;
import model.filme.Filme;

public interface RepositoryFilme {
	
	void cadastrarFilme(Filme filme) throws FilmeJaCadastradoException;
	
	void deletarFilme(Filme filme) throws FilmeNaoCadastradoException;
	
	Filme buscarFilme(String nome) throws FilmeNaoCadastradoException;
	
	List<Filme> getAll();
	
}