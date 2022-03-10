package repository.filme;

public class FilmeJaCadastradoException extends Exception {
	
	public FilmeJaCadastradoException() {
		super("Esse filme ja esta no Catologo");
	}
}