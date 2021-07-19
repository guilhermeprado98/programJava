/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplobd2;


import java.sql.*;
import java.util.Scanner;


/**
 *
 * @author mvdsi
 */
public class ExemploBD2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("consulta id=1 :"+consultaID(1));
        System.out.println("consulta id=7 :"+consultaID(7));
    }
    
    
    
    public static Connection conectarBD() {
        Connection con=null;
        try {
            if ( con == null ) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/BD_contato?useTimezone=true&serverTimezone=UTC", "root", "");
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
    
    public static void inserirContato(Connection con) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Inserção de novo contato");
        System.out.println("Digite o id do contato:");
        int id = teclado.nextInt();
        System.out.println("Digite o primeiro nome:");
        String nome = teclado.next();
        System.out.println("Digite o telefone (sem espaços):");
        String telefone = teclado.next();

        try {
            Statement comando = con.createStatement();
            comando.executeUpdate( "INSERT INTO contato VALUES ("+id+", '"+nome+"','"+telefone+"');" );
                                  //INSERT INTO contato VALUES (3, 'Beltrano','(31)3443-5656');
        }
        catch (SQLException ex) {
            System.out.println("Erro ao inserir contato");
        }        
    }
    public static boolean consultaID(int id) {
        boolean presente = false;
        
        try {
            Connection con = conectarBD();
            Statement comando = con.createStatement();
            ResultSet resultado;
            resultado = comando.executeQuery("SELECT * FROM contato WHERE id="+id);
            if (resultado.next()) {
                presente = true;
            }
        }
        catch (SQLException ex) {
            System.out.println("Erro :" + ex.toString());
        }        
        return presente;
    }
} 