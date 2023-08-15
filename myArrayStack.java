package lesson7.hw;

public class myArrayStack {
    private int maxSize;
    private int top;
    private int[] stackArr;

    public myArrayStack(int size) {
        maxSize = size;
        stackArr = new int[maxSize];
        top = -1;// Stack пуст
    }

    public void push(int value) {
        if (top - 1 == maxSize)
            throw new IndexOutOfBoundsException();
        stackArr[++top] = value;
    }

    public int pop() {
        if (top == -1)
            throw new IndexOutOfBoundsException("Stack пуст");
        return stackArr[top--];
    }

    public int peek() {
        if (top == -1) {
            throw new IndexOutOfBoundsException("Stack пуст");
        }

        return stackArr[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String toString() {
        if (top == -1) {
            return "Stack is empty";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            sb.append(stackArr[i]);
            if (i < top) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
