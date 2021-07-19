
package dados;

import conexao.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DadosContato {
    
    public static int obtemMaiorID() {
        int maxID = 0;
        Connection conexao = ConexaoBD.conectarBD();
        try {
            Statement comando = conexao.createStatement();
            ResultSet res = comando.executeQuery( "SELECT MAX(id) AS maior FROM contato;" );
            if ( res.next() ) {
                maxID = res.getInt("maior");
            }
        }
        catch (SQLException ex) {
            System.out.println("Erro ao consultar o maior id na tabela contato");
        } 
        return maxID;
    }
    
    public static int incluirContato(String nome, String telefone) {
        int codErro = 0;
        Connection conexao = ConexaoBD.conectarBD();
        int novoId = obtemMaiorID() + 1;
        
        try { //exemplo:  INSERT INTO contato VALUES (3, 'Mário', '(31)3443-1123');    
            String sql = "INSERT INTO contato VALUES (?, ?, ?);" ; 
            PreparedStatement comando = conexao.prepareStatement( sql );
            comando.setInt(1, novoId);
            comando.setString(2, nome);
            comando.setString(3, telefone);
            comando.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Erro ao inserir contato: "+ex.toString());
            codErro = 1;
        } 
        return codErro;
    }
    
    public static ResultSet obtemTodosContatos() {
        ResultSet resultado=null;
        Connection conexao = ConexaoBD.conectarBD();
        try {
            Statement comando = conexao.createStatement();
            resultado = comando.executeQuery( "SELECT * FROM contato ORDER BY nome;" );
        }
        catch (SQLException ex) {
            System.out.println("Erro ao consultar na tabela de contatos.");
        } 
        return resultado;        
    }
    
    public static int excluirContato(int id) {
        int codErro = 0;
        Connection conexao = ConexaoBD.conectarBD();
        
        try {
            String sql = "DELETE FROM contato WHERE id = ?;" ; 
            PreparedStatement comando = conexao.prepareStatement( sql );
            comando.setInt(1, id);
            comando.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Erro ao excluir contato: "+ex.toString());
            codErro = 1;
        } 
        return codErro;        
    }
    
    public static int alterarContato(int id, String nome, String telefone) {
        int codErro = 0;
        Connection conexao = ConexaoBD.conectarBD();
        
        try {
            String sql = "UPDATE contato SET nome=?, telefone=? WHERE id=? ;" ; 
            PreparedStatement comando = conexao.prepareStatement( sql );
            comando.setString(1, nome);
            comando.setString(2, telefone);
            comando.setInt(3, id);
            comando.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Erro ao atualizar contato: "+ex.toString());
            codErro = 1;
        } 
        return codErro;
    }
}
