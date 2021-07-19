
package dados;

import conexao.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DadosHabilidade {
    
    public static ResultSet obtemMaiorAvaliacao() {
        ResultSet res = null;
        Connection conexao = ConexaoBD.habilidadesBD();
        try {
            Statement comando = conexao.createStatement();
             res = comando.executeQuery( "SELECT *  FROM aluno_habilidade WHERE avaliacao = (SELECT MAX(avaliacao)FROM aluno_habilidade);" );
        }
        catch (SQLException ex) {
            System.out.println("Erro ao consultar o maior id na tabela contato");
        } 
        return res;
    }
    
    public static ResultSet obtemMenorAvaliacao() {
        ResultSet res = null;
        Connection conexao = ConexaoBD.habilidadesBD();
        try {
            Statement comando = conexao.createStatement();
             res = comando.executeQuery( "SELECT *  FROM aluno_habilidade WHERE avaliacao = (SELECT MIN(avaliacao)FROM aluno_habilidade);" );
        }
        catch (SQLException ex) {
            System.out.println("Erro ao consultar o maior id na tabela contato");
        } 
        return res;
    }
    
    public static int incluirAvaliacao(String ra, int habilidade, int avaliacao) {
        int codErro = 0;
        Connection conexao = ConexaoBD.habilidadesBD();
        
        
        try { //exemplo:  INSERT INTO contato VALUES (3, 'Mário', '(31)3443-1123');    
            String sql = "INSERT INTO aluno_habilidade  VALUES (?, ?, ?);" ; 
            PreparedStatement comando = conexao.prepareStatement( sql );
            comando.setString(1,ra);
            comando.setInt(2, habilidade);
            comando.setInt(3, avaliacao);
            comando.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Erro ao inserir avaliaçao: "+ex.toString());
            codErro = 1;
        } 
        return codErro;
    }
    
    public static ResultSet obtemTodasAvaliacoes() {
        ResultSet resultado=null;
        Connection conexao = ConexaoBD.habilidadesBD();
        try {
            Statement comando = conexao.createStatement();
            resultado = comando.executeQuery( "SELECT * FROM aluno_habilidade ORDER BY ra_aluno, id_habilidade;" );
        }
        catch (SQLException ex) {
            System.out.println("Erro ao consultar na tabela de aluno habilidade.");
        } 
        return resultado;        
    }
    
    public static ResultSet obtemAvaliacoesAluno(String aluno) {
        ResultSet resultado=null;
        Connection conexao = ConexaoBD.habilidadesBD();
        try {
            Statement comando = conexao.createStatement();
            resultado = comando.executeQuery( "SELECT H.id as id, H.descricao as descricao, AH.avaliacao as avaliacao FROM aluno_habilidade AH, habilidade H, aluno A WHERE H.id=AH.id_habilidade AND A.ra = AH.ra_aluno AND A.nome='"+aluno+"' ORDER BY descricao" );
        }
        catch (SQLException ex) {
            System.out.println("Erro ao consultar na tabela de aluno habilidade.");
        } 
        return resultado;        
    }
    
    public static ResultSet obtemHabilidadesQueAlunoNaoTem(String nomeAluno) {
        ResultSet resultado=null;
        Connection conexao = ConexaoBD.habilidadesBD();
        try {
            Statement comando = conexao.createStatement();
            resultado = comando.executeQuery( "SELECT descricao FROM habilidade WHERE id NOT IN (SELECT H.id FROM habilidade H, aluno_habilidade AH, aluno A WHERE H.id=AH.id_habilidade AND A.ra = AH.ra_aluno AND A.nome='"+nomeAluno+"') ORDER BY descricao" );
        }
        catch (SQLException ex) {
            System.out.println("Erro ao consultar na tabela de aluno habilidade.");
        } 
        return resultado;          
    }
    
    public static int obtemID(String descHabilidade) {
        Connection conexao = ConexaoBD.habilidadesBD();
        int id=-1;
        
        try {
            String sql = "SELECT id FROM habilidade WHERE descricao = ? ;" ; 
            PreparedStatement comando = conexao.prepareStatement( sql );
            comando.setString(1, descHabilidade);
            ResultSet res = comando.executeQuery();
            if(res.next()) {
                id = res.getInt("id");
            }
        }
        catch (SQLException ex) {
            System.out.println("Erro ao obter ID da habilidade: "+ex.toString());
        }       
        return id;
    }
    
    public static String obtemRA(String nomeAluno) {
        Connection conexao = ConexaoBD.habilidadesBD();
        String ra="";
        
        try {
            String sql = "SELECT ra FROM aluno WHERE nome = ? ;" ; 
            PreparedStatement comando = conexao.prepareStatement( sql );
            comando.setString(1, nomeAluno);
            ResultSet res = comando.executeQuery();
            if(res.next()) {
                ra = res.getString("ra");
            }
        }
        catch (SQLException ex) {
            System.out.println("Erro ao obter RA do aluno: "+ex.toString());
        }       
        return ra;        
    }
    
    public static int excluirAvaliacao(String ra, int habilidade) {
        int codErro = 0;
        Connection conexao = ConexaoBD.habilidadesBD();
        
        try {
            String sql = "DELETE FROM aluno_habilidade WHERE ra_aluno = ? AND id_habilidade=?;" ; 
            PreparedStatement comando = conexao.prepareStatement( sql );
            comando.setString(1, ra);
            comando.setInt(2,habilidade);
  
            comando.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Erro ao excluir avaliação: "+ex.toString());
            codErro = 1;
        } 
        return codErro;        
    }
    
    public static int alterarAvaliacao(String ra, int avaliacao, int habilidade) {
        int codErro = 0;
        Connection conexao = ConexaoBD.habilidadesBD();
        
        try {
            String sql = "UPDATE aluno_habilidade SET avaliacao=? WHERE ra_aluno=? AND id_habilidade=? ;" ; 
            PreparedStatement comando = conexao.prepareStatement( sql );
            comando.setInt(1, avaliacao);
            comando.setString(2, ra);
            comando.setInt(3, habilidade);
            comando.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Erro ao atualizar contato: "+ex.toString());
            codErro = 1;
        } 
        return codErro;
    }

   

    
}
