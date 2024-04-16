package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.SingleConnectionBD;
import model.LoginModel;

public class UserRepository {

	private Connection connection;

	public UserRepository() {
		connection = SingleConnectionBD.getConnection();
	}


	public void gravarUsuario(LoginModel objeto) throws Exception {
		
		String sql = "INSERT INTO users (login, senha, nome, email)  VALUES (?, ?, ?, ?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setString(1, objeto.getLogin());
		stmt.setString(2, objeto.getSenha());
		stmt.setString(3, objeto.getNome());
		stmt.setString(4, objeto.getEmail());
		
		stmt.execute();
		
		connection.commit();
		
	}

}
