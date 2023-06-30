import java.util.Scanner;

public class ProjetoSantander {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double[] salarioBruto = new double[5];
        double[] salarioLiquido = new double[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o salário bruto do funcionário " + (i + 1) + ": ");
            salarioBruto[i] = scanner.nextDouble();
        }

        for (int i = 0; i < 5; i++) {
            salarioLiquido[i] = calculoSalarioLiquido(salarioBruto[i]);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Funcionário " + (i + 1) + ":");
            System.out.printf("Salário bruto: R$ %.2f\n", salarioBruto[i]);
            System.out.printf("Desconto INSS: R$ %.2f\n", descontoInss(salarioBruto[i]));
            System.out.printf("Desconto Imposto de Renda: R$ %.2f\n", descontoImpostoDeRenda(salarioBruto[i]));
            System.out.printf("Salário líquido: R$ %.2f\n", salarioLiquido[i]);
            System.out.println();
        }

        scanner.close();
    }
    public static double descontoInss(double salarioBruto) {
        if (salarioBruto <= 1212.00) {
            return salarioBruto * 0.075;
        } else if (salarioBruto <= 2427.35) {
            return salarioBruto * 0.09;
        } else if (salarioBruto <= 3641.03) {
            return salarioBruto * 0.12;
        } else {
            return salarioBruto * 0.14;
        }
    }

    public static double descontoImpostoDeRenda(double salarioBruto) {
        if (salarioBruto <= 1903.98) {
            return 0;
        } else if (salarioBruto <= 2826.65) {
            return salarioBruto * 0.075;
        } else if (salarioBruto <= 3751.05) {
            return salarioBruto * 0.15;
        } else if (salarioBruto <= 4664.68) {
            return salarioBruto * 0.225;
        } else {
            return salarioBruto * 0.275;
        }
    }

    public static double calculoSalarioLiquido(double salarioBruto) {
        double descontoINSS = descontoInss(salarioBruto);
        double descontoIR = descontoImpostoDeRenda(salarioBruto);
        return salarioBruto - descontoINSS - descontoIR;
    }

}

