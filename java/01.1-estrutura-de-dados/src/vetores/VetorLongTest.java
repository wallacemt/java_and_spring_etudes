package vetores;

public class VetorLongTest {
    //Tempo de execucao: 2445ms
    private static final int SIZE = 100000;

    public static void main(String[] args) {
        long[] array = new long[SIZE];

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                array[i] += j;
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Tempo de execucao: " + (endTime - startTime) + "ms");
    }


}
