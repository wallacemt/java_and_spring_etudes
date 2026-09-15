import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.offer("Client 1");
        queue.offer("Client 2");
        System.out.printf(queue.poll());


    }
}