package repository.cliente;

public class ClienteNaoInseridoException extends Exception {
	
	public ClienteNaoInseridoException() {
		super("Esse cliente n\u00e3o existe");
	}
}