package model.cliente;

public class ClienteNaoPossuiFilmeException extends Exception {
	
	public ClienteNaoPossuiFilmeException() {
		super("O Cliente não possui nenhum filme");
	}
}