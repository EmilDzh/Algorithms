package lesson8;

import java.util.Arrays;

public class Hw {

    public static void main(String[] args) {

        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;

        double result = fractionalKnapsack(weights, values, capacity);
        System.out.println(result);

    }// main

    public static int fractionalKnapsack(int[] weights, int[] values, int capacity) {
        // Создаем массив для хранения отношения весов к стоимостям
        double[] ratios = new double[weights.length];

        // Вычисляем отношение веса к стоимости для каждого предмета
        for (int i = 0; i < weights.length; i++) {
            ratios[i] = (double) weights[i] / values[i];
        }

        // Инициализируем общую стоимость рюкзака
        int totalValue = 0;

        // Пока у нас есть вместимость в рюкзаке
        while (capacity > 0) {

            // Инициализируем переменные для хранения индекса лучшего предмета
            // и соответствующего ему отношения веса к стоимости
            int bestItem = -1;
            double bestRatio = 0;

            // Проходимся по всем предметам
            for (int i = 0; i < weights.length; i++) {
                // Если у предмета еще остались вес и его отношение веса к стоимости больше текущего лучшего
                if (weights[i] > 0 && ratios[i] > bestRatio) {
                    bestRatio = ratios[i];
                    bestItem = i;
                }
            }

            // Если такого предмета не нашлось, то выходим из цикла
            if (bestItem == -1)
                break;

            // Вычисляем, сколько предмета мы можем взять в рюкзак
            int fraction = Math.min(weights[bestItem], capacity);

            // Увеличиваем общую стоимость, добавляя стоимость предмета, умноженную на долю, которую мы взяли
            totalValue += fraction * ratios[bestItem];

            // Уменьшаем вес предмета и вместимость рюкзака на взятый предмет
            weights[bestItem] -= fraction;
            capacity -= fraction;
        }

        // Возвращаем общую стоимость предметов в рюкзаке

        return totalValue;


    }
}
