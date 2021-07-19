package visao;

import java.util.Scanner;
import dados.DadosContato;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VisaoContato {
    public static void incluirContato() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("=== Inclusão de novo contato ===");
        System.out.println("Digite o primeiro nome :");
        String nome = teclado.next();
        System.out.println("Digite o telefone (sem espaços) :");
        String telefone = teclado.next();
        int erro = DadosContato.incluirContato(nome, telefone);
        if (erro == 0) {
            System.out.println("Dados armazenados com sucesso.");
        }
        else {
            System.out.println("Erro ao armazenar os dados.");
        }
    }
    
    public static void listarTodosContatos() {
        ResultSet contatos = DadosContato.obtemTodosContatos();
        if (contatos == null) {
            System.out.println("Não há contatos armazenados");
            return;
        }
        try {
            System.out.println("ID  Nome    Telefone");
            while(contatos.next()) {
                int id = contatos.getInt("id");
                String nome = contatos.getString("nome");
                String telefone = contatos.getString("telefone");
                System.out.println(id+"\t"+nome+"\t"+telefone);
            }
        }
        catch (SQLException ex) {
            System.out.println("Erro ao acessar dados da tabela");
            System.exit(1);
        }
    }
    
    public static void excluirContato() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("=== Exclusão de contato ===");
        System.out.println("Digite o código do contato a excluir :");
        int cod = teclado.nextInt();
        int erro = DadosContato.excluirContato(cod);
        if (erro == 0) {
            System.out.println("Contato excluído com sucesso.");
        }
        else {
            System.out.println("Erro ao excluir o contato.");
        }
    }
    
    public static void alterarContato() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("=== Alteração de contato ===");
        System.out.println("Digite o id do contato a ser alterado: ");
        int id = teclado.nextInt();        
        System.out.println("Digite o primeiro nome :");
        String nome = teclado.next();
        System.out.println("Digite o telefone (sem espaços) :");
        String telefone = teclado.next();
        int erro = DadosContato.alterarContato(id, nome, telefone);
        if (erro == 0) {
            System.out.println("Dados atualizados com sucesso.");
        }
        else {
            System.out.println("Erro ao atualizar os dados do contato.");
        }
    }
    
    public static void listarContatosPorTelefone() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("=== Pesquisa contato por telefone ===");
        System.out.println("Digite o telefone do contato (ou parte dele) : ");
        String n = teclado.next();
        ResultSet contatos = DadosContato.obtemContatosPorTelefone(n);
        if (contatos == null) {
            System.out.println("\nNão há contatos armazenados (VERIFIQUE SE FALTA IMPLEMENTAR ALGO NO CÓDIGO)\n");
            return;
        }
        try {
            System.out.println("ID  Nome    Telefone");
            while(contatos.next()) {
                int id = contatos.getInt("id");
                String nome = contatos.getString("nome");
                String telefone = contatos.getString("telefone");
                System.out.println(id+"\t"+nome+"\t"+telefone);
            }
        }
        catch (SQLException ex) {
            System.out.println("Erro ao acessar dados da tabela");
            System.exit(1);
        }
    }        
}
