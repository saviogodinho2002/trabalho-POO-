package repository.aluguel;

import java.util.ArrayList;
import java.util.List;
import model.aluguel.AluguelRegistro;

public class RepositoryAluguelRegistrosList implements RepositoryAluguelRegistros {
	List<AluguelRegistro> alugueis;
	
	public RepositoryAluguelRegistrosList() {
		alugueis = new ArrayList<>();
	}
	
	@Override()
	public void cadastrarAluguel(AluguelRegistro aluguel) {
		alugueis.add(aluguel);
	}
	
	@Override()
	public void deletarAluguel(AluguelRegistro aluguel) throws AluguelNaoCadastradoException {
		if (!alugueis.remove(aluguel)) {
			throw new AluguelNaoCadastradoException();
		}
	}
	
	@Override()
	public AluguelRegistro buscarAllAluguel(String cpf, String nome) throws AluguelNaoCadastradoException {
		for (AluguelRegistro aluguel : alugueis) {
			if ((aluguel.getCliente().getCpf().equals(cpf)) && 
					(aluguel.getFilme().getNome().equals(nome))) {
				return aluguel;
			}
		}
		throw new AluguelNaoCadastradoException();
	}
	
	public AluguelRegistro buscarAluguelNaoDevolvido(String cpf, String nome) throws AluguelNaoCadastradoException {
		for (AluguelRegistro aluguel : alugueis) {
			if ((aluguel.getCliente().getCpf().equals(cpf)) && 
					(aluguel.getFilme().getNome().equals(nome)) && (!aluguel.isDevolvido())) {
				return aluguel;
			}
		}
		throw new AluguelNaoCadastradoException();
	}
	
	@Override()
	public List<AluguelRegistro> getAll() {
		return new ArrayList<>(alugueis);
	}
}