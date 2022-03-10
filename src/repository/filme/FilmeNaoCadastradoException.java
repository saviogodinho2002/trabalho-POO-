package repository.filme;

public class FilmeNaoCadastradoException extends Exception{
	
	public FilmeNaoCadastradoException() {
		// TODO Auto-generated constructor stub
		super("Esse filme não esta no catalogo");
	}

}
