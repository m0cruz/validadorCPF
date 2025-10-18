import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        String CPF;
        int resto1 = 0, resto2 = 0;
        int numeroAtual = 0;
        int valorCalculo = 0, valorValidador1 = 0, valorValidador2 = 0;

        Scanner EntradaCPF = new Scanner(System.in);
        
        try{
            System.out.println("Entre com o número do CPF, sem pontuações ou travesão!");
            CPF = EntradaCPF.nextLine();

            if (!(CPF.length() == 11)) {
                System.out.println("A sequência digitada é inválida!");
            }

            for (int i = 0; i < 9; i++) {
                numeroAtual = Character.getNumericValue(CPF.charAt(i));
                valorCalculo += numeroAtual * (10-i);
                System.out.printf("%d : %d +%d\n", i, valorCalculo, numeroAtual);
            }

            resto1 = valorCalculo % 11;

            if (resto1 < 2) {
                valorValidador1 = 0;
            } else {
                valorValidador1 = 11 - resto1;
            }

            if (!(valorValidador1 == Character.getNumericValue(CPF.charAt(9)))) {
                System.out.println("O CPF não é válido! 1");
                return;
            }

            valorCalculo = 0;

            for (int i = 0; i < 10; i++) {
                numeroAtual = Character.getNumericValue(CPF.charAt(i));
                valorCalculo += numeroAtual * (11-i);
                System.out.printf("%d : %d +%d\n", i, valorCalculo, numeroAtual);
            }

            resto2 = valorCalculo % 11;

            if (resto2 < 2) {
                valorValidador2 = 0;
            } else {
                valorValidador2 = 11 - resto2;
            }

            if (!(valorValidador2 == Character.getNumericValue(CPF.charAt(10)))) {
                System.out.println("O CPF não é válido! 2");
                return;
            }

        } catch (Exception e) {
            System.out.println("Um erro ocorreu!");
        }

        
        System.out.println("O CPF é válido!");
    
    }
}
