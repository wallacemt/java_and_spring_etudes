public class Pessoa {
    private String name;
    private int age;
    private double height;
    private double weight;

    // public Pessoa() {
    // this.name = "Jhon Doe";
    // this.age = 0;
    // this.height = 0.0;
    // this.weight = 0.0;
    // }

    public Pessoa(String name, int age, double height, double weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return this.height;
    }

    public double calcImc() {
        return this.weight / (this.height * this.height);
    }

    public String classificaoDeImc() {
        double imc = calcImc();

        if(imc < 18.5) return "Abaixo do peso";
        if(imc < 25.0) return "Peso Normal";
        if(imc < 30) return "Sobrepeso";

        return "Obesidade";
    }
}
