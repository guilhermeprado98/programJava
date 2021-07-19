/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.PedidoModel;
import java.sql.ResultSet;

/**
 *
 * @author Ryan Alves
 */
public class PedidoController {

    PedidoModel pedidoModel;

    public PedidoController() {
        pedidoModel = new PedidoModel();
    }

    public ResultSet getPedidos() {
        return pedidoModel.getPedidos();
    }
    public ResultSet getPedidosTable() {
        return pedidoModel.getPedidosTable();
    }

    public ResultSet getPessoas() {
        return pedidoModel.getPessoas();
    }

    public ResultSet getPacs() {
        return pedidoModel.getPacs();
    }

    public ResultSet getFuncs() {
        return pedidoModel.getFuncs();
    }

    public ResultSet getEquipamentos() {
        return pedidoModel.getEquipamentos();
    }

    public ResultSet getStatus() {
        return pedidoModel.getStatus();
    }
    
    public void salvar(int id, int idEq, int idFunc, int idPac, int idStatus, String dtE, String dtS) {
        if(id != 0) {
            pedidoModel.update(id, idEq, idFunc, idPac, idStatus, dtE, dtS);
        } else {
            pedidoModel.insert(idEq, idFunc, idPac, idStatus, dtE, dtS);
        }
    }
    
    public void remover(int id) {
        if(id != 0) {
            pedidoModel.remove(id);
        } 
    }
}
