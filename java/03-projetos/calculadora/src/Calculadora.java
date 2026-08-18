import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int op;

        do {
            System.out.println("JAVA CALCULATOR 2000");
            System.out.println("1. Adição (+)");
            System.out.println("2. Subtração (-)");
            System.out.println("3. Multiplicação (*)");
            System.out.println("4. Divisão (/)");
            System.out.println("0. Sair (exit)");
            op = scanner.nextInt();

            double result = 0;
            boolean validOperation = true;
            if (op >= 1 && op <= 4) {
                System.out.println("Digite o primeiro número:");
                double num1 = scanner.nextDouble();

                System.out.println("Digite o segundoo número: ");
                double num2 = scanner.nextDouble();


                switch (op) {
                    case 1:
                        result = makeAdition(num1, num2);
                        validOperation = true;
                        break;
                    case 2:
                        result = makeSubtration(num1, num2);
                        validOperation = true;

                        break;
                    case 3:
                        result = makeMultiplication(num1, num2);
                        validOperation = true;

                        break;
                    case 4:
                        if (num2 == 0) {
                            System.out.println("Não é possível dividir por zero!");
                            validOperation = false;
                        } else {
                            result = makeDivision(num1, num2);
                            validOperation = true;

                        }

                        break;
                    default:
                        break;
                }

            } else {
                System.out.println("Opção Invalida!");
            }

            if (validOperation) {
                System.out.println("O resultado é: " + result);
            }
        } while (op != 0);
        System.out.println("Saindo...");
        scanner.close();
    }

    public static double makeAdition(double a, double b) {
        return a + b;
    }

    public static double makeSubtration(double a, double b) {

        return a - b;
    }

    public static double makeMultiplication(double a, double b) {

        return a * b;
    }

    public static double makeDivision(double a, double b) {

        return a / b;
    }
}
