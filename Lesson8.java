package lesson8;

import java.util.*;

public class Lesson8 {
    public static void main(String[] args) {
        // 1 - выбор задач
        List<Integer> tasks = new ArrayList<>(Arrays.asList(3, 2, 1, 4, 5));
        int maxTime = 9;

        List<Integer> resolved = taskSelection(tasks, maxTime);
        System.out.println(resolved);

    }

    public static List<Integer> taskSelection(List<Integer> tasks, int maxTime) {
        List<Integer> result = new ArrayList<>();
        int resultTime = 0;

        LinkedList<Integer> sortedTask = new LinkedList<>(tasks);
        Collections.sort(sortedTask);
        while (maxTime > resultTime && maxTime - resultTime >= sortedTask.peek()) {
            int taskTime = sortedTask.pop();
            result.add(taskTime);
            resultTime = resultTime + taskTime;
        }

        return result;
    }

    public static List<Integer> coinChange(List<Integer> coins, int amount) {
        List<Integer> result = new ArrayList<>();
        int resultSum = 0;

        Collections.sort(coins);
        for (int i = coins.size() - 1; i <= 0; i--) {
             while (amount >= coins.get(i)){
                 amount -= coins.get(i);
                 result.add(coins.get(i));

             }
        }
        if (amount == 0) {
            return result;
        }
        return Collections.EMPTY_LIST;
    }
}
