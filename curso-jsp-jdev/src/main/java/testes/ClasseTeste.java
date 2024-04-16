package testes;

import dao.UserRepository;
import model.LoginModel;

public class ClasseTeste {
	
	public static void main(String[] args) {
		
		UserRepository repository = new UserRepository();
		
		LoginModel usuario = new LoginModel();
		usuario.setEmail("gritona@email.com");
		usuario.setNome("Ally");
		usuario.setLogin("Ally");
		usuario.setSenha("345");
		
		try {
			repository.gravarUsuario(usuario);
			System.out.println(usuario.getNome() + " persistido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
