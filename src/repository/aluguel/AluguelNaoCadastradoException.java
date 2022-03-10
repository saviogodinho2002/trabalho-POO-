package repository.aluguel;

public class AluguelNaoCadastradoException extends Exception{
	public AluguelNaoCadastradoException() {
		// TODO Auto-generated constructor stub
		super("Esse aluguel não foi feito ou ja foi devolvido");
	}

}
