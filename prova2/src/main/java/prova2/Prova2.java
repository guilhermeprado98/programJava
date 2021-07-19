package Prova2;

public class Prova2 {
    
    static int chamada = 1;

    public static void main(String[] args) {
        fatDot(8);
    }
    
    public static void fatDot(int n) {
        System.out.println("digraph g {");
        fat(n);
        System.out.println("}");
    }
    
    public static long fat(int termo) {
        int c = chamada;
        chamada += 1;
        if (termo == 0) {
            System.out.println(c+"[label=\"fat(0)\"]");
            return 1;
        }
        System.out.println(c+"[label=\"fat("+termo+")\"]");
        System.out.println(c+"->"+(c+1));
        return termo * fat(termo-1);
    }
}