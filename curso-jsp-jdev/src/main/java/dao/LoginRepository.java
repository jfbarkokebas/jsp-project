package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnectionBD;
import model.LoginModel;

public class LoginRepository {
	
	private Connection connection;
	
	public LoginRepository() {
		connection = SingleConnectionBD.getConnection();
	}
	
	public boolean validarAutenticacao(LoginModel modelLogin) throws SQLException {

		String sql = "SELECT * FROM users WHERE login = ? and senha = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, modelLogin.getLogin());
		stmt.setString(2, modelLogin.getSenha());

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) return true;
			
		return false;
			
	}

}
