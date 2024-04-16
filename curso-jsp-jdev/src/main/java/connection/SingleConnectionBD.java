package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionBD {
	
	private static String url = "jdbc:postgresql://localhost:5432/curso_jsp?autoReconnect=true";
	private static String user = "postgres";
	private static String senha = "151902";
	private static Connection connection = null;
	
	
	
	public static Connection getConnection() {
		return connection;
	}
	
	static {
		conectar();
	}
	
	
	public SingleConnectionBD() {/*quando tiver um instancia vai conectar*/
		conectar();
	}
	
	
	private static void conectar() {
		
		try {
			
			if(connection == null) {
				Class.forName("org.postgresql.Driver"); /*Carrega o driver de conexão do banco*/
				connection = DriverManager.getConnection(url, user, senha);
				connection.setAutoCommit(false); /*para nao efetuar alteracoes no banco sem nosso comando*/
				System.out.println("Conexão ok");
			}
			
		}catch (Exception e) {
			System.out.println("sem conexão");
			e.printStackTrace();/*Mostrar qualquer erro no momento de conectar*/
		}
	}

}
