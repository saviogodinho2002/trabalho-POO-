package repository.cliente;

import java.util.List;
import model.cliente.Cliente;

public interface RepositoryCliente {
	
	void cadastrarCliente(Cliente cliente) throws CPFJaInseiroException;
	
	void deletarCliente(Cliente cliente) throws ClienteNaoInseridoException;
	
	Cliente buscarCliente(String cpf) throws ClienteNaoInseridoException;
	
	List<Cliente> getAll();
}