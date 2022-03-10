package model.cliente;

public class ClienteNaoPossuiFilmeEspecificoException extends Exception{
	public ClienteNaoPossuiFilmeEspecificoException() {
		super("O Cliente não possui esse Filme");
	}

}
