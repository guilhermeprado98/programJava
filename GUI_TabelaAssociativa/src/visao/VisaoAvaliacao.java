package visao;

import java.util.Scanner;
import dados.DadosHabilidade;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VisaoAvaliacao {
    public static void incluirAvaliacao() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("=== Incluir Nova Avaliação ===");
        System.out.println("Digite o RA do novo aluno :");
        String ra = teclado.next();
        System.out.println("Digite a habilliade do aluno(numeraçao) :");
        int habilidade = teclado.nextInt();
        System.out.println("Digite a avaliacao do aluno :");
        int avaliacao = teclado.nextInt();
        int erro = DadosHabilidade.incluirAvaliacao(ra, habilidade, avaliacao);
        if (erro == 0) {
            System.out.println("Dados armazenados com sucesso.");
        }
        else {
            System.out.println("Erro ao armazenar os dados.");
        }
        
        System.out.println("\n");
    }
    
    
    public static void excluirAvaliacao() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("=== Excluir Avaliacao ===");
        System.out.println("Digite o RA do aluno:");
        String ra = teclado.next();
        System.out.println("Digite a habilidade (numero) que será excluida:");
        int habilidade= teclado.nextInt();
        int erro = DadosHabilidade.excluirAvaliacao(ra, habilidade);
        if (erro == 0) {
            System.out.println("Avaliaçao da habilidade "+ habilidade +" do RA:"+ ra +" foi excluído com sucesso.");
        }
        else {
            System.out.println("Erro ao excluir o contato.");
        }
        
        System.out.println("\n");
    }
    
    public static void alterarAvaliacao() {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("=== Alterar Avaliaçoes dos Alunos ===");
        System.out.println("Digite o RA do aluno: ");
        String ra = teclado.next();        
        System.out.println("Digite a habilidade:");
        int habilidade = teclado.nextInt();
        System.out.println("Digite a avalição a ser altera:");
        int avaliacao = teclado.nextInt();
        int erro = DadosHabilidade.alterarAvaliacao(ra, avaliacao, habilidade);
        if (erro == 0) {
            System.out.println("Dados atualizados com sucesso.");
        }
        else {
            System.out.println("Erro ao atualizar os dados da avaliação.");
        }
        
        System.out.println("\n");
    }
    
    public static void listarTodasAvaliacoes() {
        
        ResultSet avaliacao = DadosHabilidade.obtemTodasAvaliacoes();
        if (avaliacao == null) {
            System.out.println("Não há avalição de alunos armazenadas");
            return;
        }
        try {
            System.out.println("=== Avaliações dos Alunos ===");
            System.out.println("RA      Habilidade    Avalição");
            while(avaliacao.next()) {
                String RA = avaliacao.getString("ra_aluno");
                int Habilidade = avaliacao.getInt("id_habilidade");
                int Avalição = avaliacao.getInt("avaliacao");
                System.out.println(RA+"\t"+Habilidade+"\t"+Avalição); 
            }
            
            System.out.println("\n");
        }
        catch (SQLException ex) {
            System.out.println("Erro ao acessar dados da tabela");
            System.exit(1);
        }
    }
   
    public static void obtemMaiorAvaliacao() {
        
        ResultSet avaliacao = DadosHabilidade.obtemMaiorAvaliacao();
        if (avaliacao == null) {
            System.out.println("Não há avalição de alunos armazenadas");
            return;
        }
        try {
            System.out.println("=== Maior Avaliação ===");
            System.out.println("RA      Habilidade    Avalição");
            while(avaliacao.next()) {
                String RA = avaliacao.getString("ra_aluno");
                int Habilidade = avaliacao.getInt("id_habilidade");
                int Avalição = avaliacao.getInt("avaliacao");
                System.out.println(RA+"\t"+Habilidade+"\t"+Avalição); 
            }
            
            System.out.println("\n");
        }
        catch (SQLException ex) {
            System.out.println("Erro ao acessar dados da tabela");
            System.exit(1);
        }
        
    }
    
    public static void obtemMenorAvaliacao() {
        
        ResultSet avaliacao = DadosHabilidade.obtemMenorAvaliacao();
        if (avaliacao == null) {
            System.out.println("Não há avalição de alunos armazenadas");
            return;
        }
        try {
            System.out.println("=== Menor Avaliação ===");
            System.out.println("RA      Habilidade    Avalição");
            while(avaliacao.next()) {
                String RA = avaliacao.getString("ra_aluno");
                int Habilidade = avaliacao.getInt("id_habilidade");
                int Avalição = avaliacao.getInt("avaliacao");
                System.out.println(RA+"\t"+Habilidade+"\t"+Avalição); 
            }
            
            System.out.println("\n");
        }
        catch (SQLException ex) {
            System.out.println("Erro ao acessar dados da tabela");
            System.exit(1);
        }
        
    }
    
}
