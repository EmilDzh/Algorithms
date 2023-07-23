package lesson5.HW;

import java.util.Arrays;
import java.util.Random;

public class hw {
    public static void main(String[] args) {
        int[] arr = {1, 22, 33, -22, -1, 0, 44, 5};
        bubleSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {-2, 3, -4, 55, -1, -1, 33, 55};

        shakerSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {1, -4, 3, -5, -22};
        selectionSort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = new int[10];
        Random rnd = new Random();
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = rnd.nextInt(35) - 10;
        }
        //Алгоритм быстрой сортировки требует, чтобы low и high были индексами границ сортируемой части массива.
        quickSort(arr3, 0, arr3.length - 1);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {1, 2, 55, 66, 31, -2, 3, -5, -2};
        mergeSort(arr4);
        System.out.println(Arrays.toString(arr4));


    } // end of main

    //сложность алгоритма O(n^2)

    public static void bubleSort(int[] a) {
        int temp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                }
            }
        }
    }

    //сложность алгоритма O(n^2)
    public static void shakerSort(int[] a) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int temp;
            for (int i = right; i > left; i--) {
                if (a[i - 1] > a[i]) {
                    temp = a[i - 1];
                    a[i - 1] = a[i];
                    a[i] = temp;
                }
            }
            left++;

            for (int j = left; j < right; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            right--;
        }
    }

    //сложность алгоритма O(n^2)

    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }
    }

    //в лучшем случае сложность алгоритма O(n log n)
    //в худшем случае сложность алгоритма O(n^2) - когда опорный элемент находится в конце массива

    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(a, low, high);

            quickSort(a, low, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // сложность алгоритма O(n log n)

    public static void mergeSort(int[] a) {
        if (a.length <= 1)
            return;

        int middle = a.length / 2;
        int[] left = Arrays.copyOfRange(a, 0, middle);
        int[] right = Arrays.copyOfRange(a, middle, a.length);

        mergeSort(left);
        mergeSort(right);

        merge(a, left, right);

    }

    public static void merge(int[] a, int[] left, int[] right) {
        int l = 0; // Индекс для перебора элементов левой части
        int r = 0; // Индекс для перебора элементов правой части
        int c = 0; // Индекс для перебора элементов итогового массива

        // Слияние элементов левой и правой частей в итоговый массив
        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                a[c++] = left[l++];
            } else {
                a[c++] = right[r++];
            }
        }
        
        // Добавление оставшихся элементов из левой и правой частей, если таковые остались
        while (l < left.length) {
            a[c++] = left[l++];
        }

        while (r < right.length) {
            a[c++] = right[r++];
        }


    }


}
