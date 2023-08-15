package lesson7.hw;

public class hwTester {
    public static void main(String[] args) {
        myDoublyLinkedList myDoublyLinkedList = new myDoublyLinkedList();
        myDoublyLinkedList.push(2);
        myDoublyLinkedList.push(3);
        myDoublyLinkedList.push(4);
        myDoublyLinkedList.push(5);
        System.out.println(myDoublyLinkedList);
        myDoublyLinkedList.poll();
        System.out.println(myDoublyLinkedList);

        myArrayStack myArrayStack = new myArrayStack(5);

        myArrayStack.push(5);
        myArrayStack.push(6);
        myArrayStack.push(7);
        myArrayStack.push(8);
        System.out.println(myArrayStack);
        myArrayStack.pop();
        System.out.println(myArrayStack);
        System.out.println(myArrayStack.peek());

    }
}
