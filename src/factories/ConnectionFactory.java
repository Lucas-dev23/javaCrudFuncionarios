package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// parâmetros necessários para conexão com o banco de dados
	private static String driver = "org.postgresql.Driver";
	private static String url = "jdbc:postgresql://localhost:5432/bd_exercicio";
	private static String user = "postgres";
	private static String password = "Ldelchmr";

	// método para retornar a conexão com o banco de dados
	public static Connection getConnection() throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}
}
