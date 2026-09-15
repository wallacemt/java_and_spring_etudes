import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static void main(String[] args) {
        PriorityQueue<Task> queueTask = new PriorityQueue<Task>();

        queueTask.add(new Task("Responder emails", 3));
        queueTask.add(new Task("Corrigir Bugs", 1));
        queueTask.add(new Task("Planejamento Sprint", 2));

        System.out.println("Tarefas por ordem de prioridade");

        while (!queueTask.isEmpty()) {
            System.out.println(queueTask.poll());
        }

    }
}