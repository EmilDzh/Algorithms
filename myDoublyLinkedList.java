package lesson7.hw;

// 1 уровень сложности: 1. Прочитать статьи про стек и очередь https://thecode.media/stack/ https://codechick.io/tutorials/dsa/dsa-queue
//
//
//Повторить код, написанный на занятии, разобраться с ним
//
//Добавить реализацию метода poll() для очереди
//
//* Попробовать реализовать стек и очередь на базе массива
public class myDoublyLinkedList {

    private int size;

    private Node head;
    private Node tail;


    private class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }

        }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = null;
        newNode.prev = tail;

        if (tail != null) {
            tail.next = newNode;
        }

        tail = newNode;

        if (head == null) {
            head = newNode;
        }
        size++;
    }

        public int get(int index) {
            if (size < 0 || size >= index) {
                throw new IndexOutOfBoundsException();
            }
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        }

        public void add(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
        }

        /*
        int value = head.value; - Получаем значение из головы списка.

        head = head.next; - Перемещаем голову на следующий узел, тем самым "отцепляя" текущую голову от списка.

        if (head != null) { head.prev = null; } - Если есть новая голова (список не пуст),

        то убираем связь с предыдущей головой, так как она больше не является предыдущей.

        else { tail = null; } - Если список стал пустым, обнуляем хвост, так как теперь в списке нет элементов.

        size--; - Уменьшаем размер списка, так как один элемент был успешно извлечен.

         */

        public Integer poll() {
            if (head == null) {
                return null;
            }
            int value = head.value;
            head = head.next;

            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            size--;
            return value;
        }

        public int size() {
            return size;
        }

        @Override
        public String toString() {
            if (head == null) {
                return "DoubleLinkedList is empty";
            }

            StringBuilder sb = new StringBuilder("[");
            Node current = head;
            while (current != null) {
                sb.append(current.value);
                if (current.next != null) {
                    sb.append(", ");
                }
                current = current.next;
            }
            sb.append("]");

            return sb.toString();
        }




}
