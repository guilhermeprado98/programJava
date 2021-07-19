
package dados;

import conexao.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DadosAluno {
    
     public static String proximoRA(String RA) {
        String tempRA = RA.substring(3);  // retira o A06
        int numRA = Integer.valueOf(tempRA);  // converte para inteiro
        numRA++;     // gera o prÃ³ximo
        tempRA = "A06" + String.valueOf(numRA); // converte p/ string e concatena o A06
        return tempRA;
    }
   
    
    
    public static String obtemProximoRA() {
        String maxRA = "A06000001";
        Connection conexao = ConexaoBD.conectarBD();
        try {
            Statement comando = conexao.createStatement();
            ResultSet res = comando.executeQuery( "SELECT MAX(RA) AS maior FROM aluno;" );
            if ( res.next() ) {
                maxRA = proximoRA(res.getString("maior"));
            }
        }
        catch (SQLException ex) {
            System.out.println("Erro ao consultar o maior RA na tabela aluno");
        } 
        return maxRA;
        
    }
    
   
    public static int incluirAluno(String Nome, String Curso) {
        int codErro = 0;
        Connection conexao = ConexaoBD.conectarBD();
        String novoRA = obtemProximoRA();
        
        try { //exemplo:  INSERT INTO contato VALUES ('3', 'MÃ¡rio', 'Sistemas de informaÃ§Ã£o');    
            String sql = "INSERT INTO aluno VALUES (?, ?, ?);" ; 
            PreparedStatement comando = conexao.prepareStatement( sql );
            comando.setString(1, novoRA);
            comando.setString(2, Nome);
            comando.setString(3, Curso);
            comando.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Erro ao inserir aluno: "+ex.toString());
            codErro = 1;
        } 
        return codErro;
    }
    
    public static ResultSet obtemTodosAlunos() {
        ResultSet resultado=null;
        Connection conexao = ConexaoBD.conectarBD();
        try {
            Statement comando = conexao.createStatement();
            resultado = comando.executeQuery( "SELECT * FROM Aluno;" );
        }
        catch (SQLException ex) {
            System.out.println("Erro ao consultar na tabela de Alunos.");
        } 
        return resultado;        
    }
    
    public static int excluirAluno(String RA) {
        int codErro = 0;
        Connection conexao = ConexaoBD.conectarBD();
        
        try {
            String sql = "DELETE FROM aluno WHERE RA = ?;" ; 
            PreparedStatement comando = conexao.prepareStatement( sql );
            comando.setString(1, RA);
            comando.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Erro ao excluir aluno: "+ex.toString());
            codErro = 1;
        } 
        return codErro;        
    }
    
    public static int alterarAluno(String RA, String nome, String curso) {
        int codErro = 0;
        Connection conexao = ConexaoBD.conectarBD();
        
        try {
            String sql = "UPDATE aluno SET nome=?, curso=? WHERE RA=? ;" ; 
            PreparedStatement comando = conexao.prepareStatement( sql );
            comando.setString(1, nome);
            comando.setString(2, curso);
            comando.setString(3, RA);
            comando.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Erro ao atualizar aluno: "+ex.toString());
            codErro = 1;
        } 
        return codErro;
    }
    
    // pesquisa por nome ou partes do nome na tabela de contatos
    // ParÃ¢metro nm - o nome ou parte do nome a ser pesquisado
    // Retorno: Um ResultSet contendo todas as tuplas que "casem" com o nome pesquisado
    public static ResultSet obtemAlunosPorNome(String nm) {
        ResultSet resultado=null;
        Connection conexao = ConexaoBD.conectarBD();
        try {
            // Uso o LIKE na consulta para pesquisar partes do nome
            String sql = "SELECT * FROM aluno WHERE nome LIKE ? ORDER BY nome;" ; 
            PreparedStatement comando = conexao.prepareStatement( sql );
            comando.setString(1, "%"+nm+"%"); // adiciona o sÃ­mbolo % na frente
                                              // e atrÃ¡s do nome pesquisado
                                              // para o LIKE pesquisar partes do nome
            resultado = comando.executeQuery();
        }
        catch (SQLException ex) {
            System.out.println("Erro ao consultar na tabela de alunos.");
        } 
        return resultado;        
    }
    public static ResultSet obtemAlunosPorCurso(String curso) {
        ResultSet resultado=null;
        Connection conexao = ConexaoBD.conectarBD();
        try {
            // Uso o LIKE na consulta para pesquisar partes do nome
            String sql = "SELECT * FROM aluno WHERE curso LIKE ? ORDER BY curso;" ; 
            PreparedStatement comando = conexao.prepareStatement( sql );
            comando.setString(1, "%"+curso+"%"); // adiciona o sÃ­mbolo % na frente
                                              // e atrÃ¡s do nome pesquisado
                                              // para o LIKE pesquisar partes do nome
            resultado = comando.executeQuery();
        }
        catch (SQLException ex) {
            System.out.println("Erro ao consultar na tabela de alunos.");
        } 
        return resultado;        
    }

   
}