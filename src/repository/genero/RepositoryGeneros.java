package repository.genero;

import java.util.List;

public interface RepositoryGeneros {
	
	void cadastrarGenero(RepositoryGeneroFilmeList genero) throws GeneroJaCadastradoException;
	
	void deletarGenero(RepositoryGeneroFilmeList genero) throws GeneroNaoCadastradoException;
	
	RepositoryGeneroFilmeList buscarGenero(String genero) throws GeneroNaoCadastradoException;
	
	List<RepositoryGeneroFilmeList> getAll();

}
