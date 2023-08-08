package lesson6.HW;

public class hwTester {
    public static void main(String[] args) {
        hwDynamicArray arr = new hwDynamicArray();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        System.out.println(arr);//[1, 2, 3, 4, 5]
        arr.add(-1);
        System.out.println(arr);//[1, 2, 3, 4, 5, -1]
        arr.add(2,-25);
        System.out.println(arr);//[1, 2, -25, 3, 4, 5, -1]
        arr.remove(3);
        System.out.println(arr);//[1, 2, -25, 4, 5, -1]

    }
}
