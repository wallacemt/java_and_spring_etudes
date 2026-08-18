public class Main {
    public static void separator() {
        String separ = "";
        for (int i = 0; i < 20; i++) {
            separ += "=";
        }
        System.out.println(separ);
    }

    public static void main(String[] args) {

        System.out.println("==SISNTAXE BASICA==");

        System.out.println("Pode ser impresso na tela insto alem de numeros como: " + 33);
        separator();
        int age = 25;
        int actualYear = 2026;
        System.out.println("Sua idade é " + age + "anos");
        System.out.println("O ano é " + actualYear);

        separator();

        double altura = 2.10;
        double PI = 3.14;
        System.out.println("Altura " + altura + "PI: " + PI);

        separator();

        boolean isLogged = true;
        boolean isAdmin = false;

        System.out.println("Esta logado? " + isLogged);
        System.out.println("E admin? " + isAdmin);

        separator();

        int x = 20, y = 20, z = 30;

        System.out.println(x + " " + y + " " + z);

        separator();

        int a = 10;
        int b = 3;

        System.out.println("A - B = " + (a - b));
        System.out.println("A + B = " + (a + b));
        System.out.println("A / B = " + (a / b));
        System.out.println("A * B = " + (a * b));
    }
}