package trabalhofinal.view;
import java.sql.Connection;
import trabalhofinal.persistencia.ConnectionFactory;

public class Main {
	public static void main(String[] args) {
		Connection conn = ConnectionFactory.getConnection();
		if (conn != null) {
			System.out.println("OK");
			ConnectionFactory.close(conn);
		}
	}
}
