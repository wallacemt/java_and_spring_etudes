import java.util.HashMap;

public class HashMapTest {

    private static final int SIZE = 100000;

    static void main(String[] args) {
        HashMap<Integer, Product> maps = new HashMap<Integer, Product>();

        for (int i = 1; i <= SIZE; i++) {
            maps.put(i, new Product(i, "produto_" + i, i * 20.00));
        }

        long startTime = System.currentTimeMillis();

        int searchItem = SIZE;

        for (int qtd = 0; qtd < SIZE; qtd++) {
            Product p = maps.get(searchItem);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Tempo de execucao: " + (endTime - startTime) + "ms");

    }

}
