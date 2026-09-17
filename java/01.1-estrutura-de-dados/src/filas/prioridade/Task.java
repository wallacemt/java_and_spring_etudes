package filas.prioridade;

public class Task implements Comparable<Task> {
    String name;
    int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }


    @Override
    public int compareTo(Task t) {
        return Integer.compare(this.priority, t.priority);
    }

    @Override
    public String toString() {
        return "Prioridade: " + priority + " - Tarefa: " + name;
    }
}
