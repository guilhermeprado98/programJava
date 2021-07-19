package visao;

import java.util.Scanner;


public class VisaoPrincipal {
    public static void main(String [] args) {
        exibeMenu();
    }
    
    
    public static void exibeMenu() {
        //Runtime.getRuntime().exec("cls"); 

        Scanner teclado = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("GERENCIAR CONTATOS");
            System.out.println("------------------");
            System.out.println("Opçoes:");
            System.out.println("0 - Sair");
            System.out.println("1 - Incluir novo contato");
            System.out.println("2 - Excluir contato");
            System.out.println("3 - Alterar dados de contato");
            System.out.println("4 - Listar todos os contatos");
            System.out.println("5 - Listar contatos por telefone");
            System.out.println("Escolha a opção");            
            opcao = teclado.nextInt();
            executaOpcao(opcao);
        } while (opcao != 0);
    }
    
    public static void executaOpcao(int op) {
        switch(op) {
            case 0 : System.exit(0);
            case 1 : VisaoContato.incluirContato(); break;
            case 2 : VisaoContato.excluirContato(); break;
            case 3 : VisaoContato.alterarContato(); break;
            case 4 : VisaoContato.listarTodosContatos(); break;
            case 5 : VisaoContato.listarContatosPorTelefone(); break;
            default : System.out.println("Opção incorreta: escolha entre 0 e 4");
        }
    }
}
