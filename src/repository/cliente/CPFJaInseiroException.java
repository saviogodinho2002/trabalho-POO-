package repository.cliente;

public class CPFJaInseiroException extends Exception {
	
	public CPFJaInseiroException() {
		super("Ja existe um cliente com esse CPF");
	}
}