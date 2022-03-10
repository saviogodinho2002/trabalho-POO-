package repository.genero;

import repository.filme.RepositoryFilmeList;

public class RepositoryGeneroFilmeList extends RepositoryFilmeList{
	
	private String genero;
	
	public RepositoryGeneroFilmeList(String genero) {
		// TODO Auto-generated constructor stub
		super();
		this.genero = genero;	
	}
	

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
