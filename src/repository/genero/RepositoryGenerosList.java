package repository.genero;

import java.util.ArrayList;
import java.util.List;

public class RepositoryGenerosList implements RepositoryGeneros{
	List<RepositoryGeneroFilmeList> generos;
	
	public RepositoryGenerosList() {
		generos =  new ArrayList<>();
	}
	

	@Override
	public void cadastrarGenero(RepositoryGeneroFilmeList genero) throws GeneroJaCadastradoException {
		try {
			buscarGenero(genero.getGenero());
			throw new GeneroJaCadastradoException();
		}catch(GeneroNaoCadastradoException e){
			
			generos.add(genero);
		}
		
	}

	@Override
	public void deletarGenero(RepositoryGeneroFilmeList genero) throws GeneroNaoCadastradoException {
		// TODO Auto-generated method stub
		if(!generos.remove(genero)) throw new GeneroNaoCadastradoException();
		
	}

	@Override
	public RepositoryGeneroFilmeList buscarGenero(String genero) throws GeneroNaoCadastradoException {
		for (RepositoryGeneroFilmeList repositoryGeneroFilmeList : generos) {
			if(repositoryGeneroFilmeList.getGenero().equals(genero)) return repositoryGeneroFilmeList;
			
		}
		throw new GeneroNaoCadastradoException();
	}

	@Override
	public List<RepositoryGeneroFilmeList> getAll() {
		// TODO Auto-generated method stub
		return new ArrayList<>(generos);
	}

}
