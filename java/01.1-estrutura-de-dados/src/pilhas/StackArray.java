package pilhas;

public class StackArray {

    private int[] data;
    private int top;

    public StackArray(int size){
        data = new int[size];

        top =-1;
    }

    public void push(int value){
        if(top == data.length -1) {
            throw  new RuntimeException("Overflow");
        }
        data[++top] = value;
    }

    public int pop(){
        if(top == -1){
            throw  new RuntimeException("Underflow");
        }

        return data[top--];
    }


    public int peak() {
        return data[top];
    }
}
