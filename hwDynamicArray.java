package lesson6.HW;

public class hwDynamicArray {
    private int[] data;
    private int size;
    private static final int INITIALCAPACITY = 4;

    public hwDynamicArray() {
        data = new int[INITIALCAPACITY];
    }

    public int size() {
        return size;
    }

    public int get(int index) {
        if (index < 0 || index > data.length)
            throw new IndexOutOfBoundsException();
        return data[index];
    }

    public void add(int value) {
        if (size == data.length) {
            increaseCapasity();
        }
        data[size] = value;
        size++;
    }

    private void increaseCapasity() {
        int[] newData = new int[INITIALCAPACITY * 2];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;

    }

    public void add(int index, int value) {
        if (index < 0 || index > data.length)
            throw new IndexOutOfBoundsException();
        if (size == data.length) {
            increaseCapasity();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }

    //сложность алгоритма O(n)

    public void remove(int index) {
        if (index < 0 || index > data.length)
            throw new IndexOutOfBoundsException();
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1)
                sb.append(", ");

        }

        return sb.append("]").toString();
    }
}
