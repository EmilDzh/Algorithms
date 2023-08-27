package lesson9;

public class Lesson9 {
    public static void main(String[] args) {
        int[] lock = {2, 3, 4, 5};
        int[] code = {5, 4, 3, 2};
        System.out.println(codedLock(lock, code));

    }

    public static int codedLock(int[] lock, int[] code) {
        int rotations = 0;

        for (int i = 0; i < lock.length; i++) {
            int a = lock[i];
            int b = code[i];

            int rotateA = b - a > 0 ? b - a : b - a + 10;
            int rotateB = a - b > 0 ? a - b : a - b + 10;

            rotations += Math.min(rotateA, rotateB);

        }
        return rotations;
    }
}
