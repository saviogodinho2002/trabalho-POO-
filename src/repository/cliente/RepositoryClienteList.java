package repository.cliente;

import java.util.ArrayList;
import java.util.List;
import model.cliente.Cliente;

public class RepositoryClienteList implements RepositoryCliente {
	List<Cliente> clientes;
	
	public RepositoryClienteList() {
		clientes = new ArrayList<>();
	}
	
	@Override()
	public void cadastrarCliente(Cliente cliente) throws CPFJaInseiroException {
		try {
			buscarCliente(cliente.getCpf());
			throw new CPFJaInseiroException();
		} catch (ClienteNaoInseridoException e) {
			clientes.add(cliente);
		}
	}
	
	@Override()
	public void deletarCliente(Cliente cliente) throws ClienteNaoInseridoException {
		if (!clientes.remove(cliente)) {
			throw new ClienteNaoInseridoException();
		}
	}
	
	@Override()
	public Cliente buscarCliente(String cpf) throws ClienteNaoInseridoException {
		for (Cliente cliente : clientes) {
			if (cliente.getCpf().equals(cpf)) return cliente;
		}
		throw new ClienteNaoInseridoException();
	}
	
	@Override()
	public List<Cliente> getAll() {
		return new ArrayList<>(clientes);
	}
}