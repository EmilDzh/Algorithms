package lesson9.hw;

public class hw {

    public static void main(String[] args) {
        int[] lock = {2, 3, 4, 5};
        int[] code = {5, 4, 3, 2};

        int rotations = codedLock(lock, code);
        System.out.println("Total : " + rotations);


        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 5;

        int maxValue = knapsack(weights, values, capacity);
        System.out.println("Максимальная стоимость: " + maxValue);
    }

    public static int codedLock(int[] lock, int[] code) {
        int rotations = 0;

        for (int i = 0; i < lock.length; i++) {
            int a = lock[i];
            int b = code[i];

            // Вычисляем разницу между текущими позициями барабанов
            int diff = Math.abs(a - b);

            // Находим минимальное количество поворотов для достижения нужной позиции
            int minRotations = Math.min(diff, 10 - diff);

            rotations += minRotations;
        }

        return rotations;
    }

    public static int knapsack(int[] weights, int[] values, int capasity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capasity + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= capasity; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        printMatrix(dp);
        return dp[n][capasity];
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // Переход на следующую строку после завершения строки матрицы
        }
    }
}
