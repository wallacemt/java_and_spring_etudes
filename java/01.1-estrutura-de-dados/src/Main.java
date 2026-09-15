public class Main {
    static void main(String[] args) {
        try {
            Vector names = new Vector(2);

            names.add("manoel");
            names.add("joana");
            names.add("larissa");
            names.add("ana");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}