/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ryan Alves
 */
public class Banco {

    public static Connection conectarBD() {
        Connection con = null;
        try {
            if (con == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/clinica_att?useTimezone=true&serverTimezone=UTC", "root", "");
            }
        } catch (SQLException e) {
            System.out.println("Erro de conexão com o banco" + e.toString());
            System.exit(1);
        } catch (ClassNotFoundException e) {
            System.out.println("Erro: driver do banco não encontrado");
            System.exit(1);
        }
        return con;
    }
}
