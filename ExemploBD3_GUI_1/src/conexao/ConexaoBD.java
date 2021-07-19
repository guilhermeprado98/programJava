package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    public static Connection conectarBD() {
        Connection con=null;
        try {
            if ( con == null ) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/bd_contato?useTimezone=true&serverTimezone=UTC", "root", "");
            }
        }
        catch(SQLException e) {
            System.out.println("Erro de conexão com o banco" + e.toString());
            System.exit(1);
        }
        catch(ClassNotFoundException e) {
            System.out.println("Erro: driver do banco não encontrado");
            System.exit(1);
        }
        return con;
    }    
}
