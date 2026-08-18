public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Manoel Gomes", 44, 1.65, 60);

        System.out.println(pessoa.getName());
        System.out.println(pessoa.getAge());
        System.out.println(pessoa.getHeight());
        System.out.println(pessoa.getWeight());

        System.out.println("O Imc é: " + pessoa.calcImc());
        System.out.println("A classificacao do IMC e: " + pessoa.classificaoDeImc());
    }
}
