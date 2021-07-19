package visao;

import dados.DadosHabilidade;
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
            System.out.println("GERENCIAR AVALIAÇÕES DOS ALUNOS");
            System.out.println("------------------");
            System.out.println("Opçoes:");
            System.out.println("0 - Sair");
            System.out.println("1 - Incluir novas avaliacoes");
            System.out.println("2 - Excluir avaliacoes");
            System.out.println("3 - Alterar dados da avalição");
            System.out.println("4 - Listar todas as avaliações");
            System.out.println("5 - Mostra maior avaliacao");
            System.out.println("6 - Mostra menor avaliacao");
            System.out.println("Escolha a opção");            
            opcao = teclado.nextInt();
            executaOpcao(opcao);
        } while (opcao != 0);
    }
    
    public static void executaOpcao(int op) {
        switch(op) {
            case 0 : System.exit(0);
            case 1 : VisaoAvaliacao.incluirAvaliacao(); break;
            case 2 : VisaoAvaliacao.excluirAvaliacao(); break;
            case 3 : VisaoAvaliacao.alterarAvaliacao(); break;
            case 4 : VisaoAvaliacao.listarTodasAvaliacoes(); break;
            case 5 : VisaoAvaliacao.obtemMaiorAvaliacao(); break;
            case 6 : VisaoAvaliacao.obtemMenorAvaliacao(); break;
            default : System.out.println("Opção incorreta: escolha entre 0 e 6");
        }
    }
}
