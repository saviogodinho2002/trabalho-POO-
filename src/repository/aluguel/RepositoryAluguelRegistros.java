package repository.aluguel;

import java.util.List;

import model.aluguel.AluguelRegistro;

public interface RepositoryAluguelRegistros {
	
	void cadastrarAluguel(AluguelRegistro aluguel);
	void deletarAluguel(AluguelRegistro aluguel) throws AluguelNaoCadastradoException;
	AluguelRegistro buscarAllAluguel(String cpf, String nome) throws AluguelNaoCadastradoException;
	
	List<AluguelRegistro> getAll();
}
