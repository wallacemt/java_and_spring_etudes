package listas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListsPerformTestings {
    static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<Integer>();
        List<Integer> linkedList = new LinkedList<Integer>();

        for (int i = 0; i < 1_000_000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long startArray = System.currentTimeMillis();

        for (int i = 0; i < 1_000; i++) {
            arrayList.get(i * 100);
        }

        long endArray = System.currentTimeMillis();

        long startLinked = System.currentTimeMillis();

        for (int i = 0; i < 1_000; i++) {
            linkedList.get(i * 100);
        }

        long endLinked = System.currentTimeMillis();

        System.out.println("Arraylist - Tempo de acesso: " + (endArray - startArray) + "ms");

        System.out.println("LinkedList - Tempo de acesso: " + (endLinked - startLinked) + "ms");
    }

}
