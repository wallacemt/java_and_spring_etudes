public class Main {
    public static void main(String[] args) {
        int age = 18;

        if (age >= 18) {
            System.out.println("Você é maior de idade.");
        } else {
            System.out.println("Você é menor de idade!");
        }

        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        int sumPair = 0;
        int sumEven = 0;

        for (int num : nums) {
            if (num % 2 == 0) {

                sumPair += num;

            } else {
                sumEven += num;
            }
        }

        System.out.println("Soma dos pares é: " + sumPair);
        System.out.println("Soma dos impares é: " + sumEven);

    }
}
