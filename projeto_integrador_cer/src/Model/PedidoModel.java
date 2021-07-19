/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PedidoModel {

    private Connection con = null;

    public PedidoModel() {
        con = Banco.conectarBD();
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
            comando.executeUpdate("INSERT INTO contato VALUES (" + id + ", '" + nome + "','" + telefone + "');");
            //INSERT INTO contato VALUES (3, 'Beltrano','(31)3443-5656');
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir contato");
        }
    }

    public ResultSet getPedidosTable() {
        try {
            Statement comando = con.createStatement();
            return comando.executeQuery(
                    "SELECT peds.id AS ID, equi.nome AS Equipamento, func.nome AS 'Funcionário', pac.nome AS Paciente FROM tb_pedidos as peds "
                    + "JOIN tb_equipamento as equi ON equi.id = peds.idEquipamento "
                    + "JOIN tb_pessoa as func ON func.id = peds.idFuncionario "
                    + "JOIN tb_pessoa as pac ON pac.id = peds.idPaciente ");
        } catch (SQLException ex) {
            System.out.println("Erro :" + ex.toString());
        }
        return null;
    }

    public ResultSet getPedidos() {
        try {
            Statement comando = con.createStatement();
            return comando.executeQuery(
                    "SELECT * FROM tb_pedidos ");
        } catch (SQLException ex) {
            System.out.println("Erro :" + ex.toString());
        }
        return null;
    }

    public ResultSet getPessoas() {
        try {
            Statement comando = con.createStatement();
            return comando.executeQuery(
                    "SELECT * FROM tb_pessoa");
        } catch (SQLException ex) {
            System.out.println("Erro :" + ex.toString());
        }
        return null;
    }
    
    
    public ResultSet getFuncs() {
        try {
            Statement comando = con.createStatement();
            return comando.executeQuery(
                    "SELECT * FROM tb_pessoa WHERE tipoId = 1");
        } catch (SQLException ex) {
            System.out.println("Erro :" + ex.toString());
        }
        return null;
    }
    
    
    public ResultSet getPacs() {
        try {
            Statement comando = con.createStatement();
            return comando.executeQuery(
                    "SELECT * FROM tb_pessoa WHERE tipoId = 2");
        } catch (SQLException ex) {
            System.out.println("Erro :" + ex.toString());
        }
        return null;
    }

    public ResultSet getEquipamentos() {
        try {
            Statement comando = con.createStatement();
            return comando.executeQuery(
                    "SELECT * FROM tb_equipamento");
        } catch (SQLException ex) {
            System.out.println("Erro :" + ex.toString());
        }
        return null;
    }

    public ResultSet getStatus() {
        try {
            Statement comando = con.createStatement();
            return comando.executeQuery(
                    "SELECT * FROM tb_status");
        } catch (SQLException ex) {
            System.out.println("Erro :" + ex.toString());
        }
        return null;
    }

    public void update(int id, int idEq, int idFunc, int idPac, int idStatus, String dtE, String dtS) {

        try {
            Statement comando = con.createStatement();
            comando.executeUpdate(
                    "UPDATE tb_pedidos"
                    + " SET idEquipamento = " + idEq
                    + ", idFuncionario = " + idFunc
                    + ", idPaciente = " + idPac
                    + ", idStatus = " + idStatus
                    + ", dataEntrega = '" + dtE + "' "
                    + ", dataSolicitacao = '" + dtS + "' "
                    + " WHERE id = " + id);
        } catch (SQLException ex) {
            System.out.println("Erro :" + ex.toString());
        }
    }
    
    public void insert(int idEq, int idFunc, int idPac, int idStatus, String dtE, String dtS) {

        try {
            Statement comando = con.createStatement();
            String sql = "INSERT INTO tb_pedidos"
                    + " VALUES ( NULL, " + idEq
                    + ", " + idFunc
                    + ", " + idPac
                    + ", " + idStatus
                    + ", '" + dtE
                    + "', '" + dtS
                    + "')";
            System.out.println(sql);
            comando.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Erro :" + ex.toString());
        }
    }
    
    
    public void remove(int id) {

        try {
            Statement comando = con.createStatement();
            comando.execute( "DELETE FROM tb_pedidos WHERE id = " + id);
        } catch (SQLException ex) {
            System.out.println("Erro :" + ex.toString());
        }
    }
}
