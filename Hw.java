package Lesson3.Hw;

public class Hw {
    public static void main(String[] args) {
        //уровень сложности: 1. Написать рекурсивный метод получения чисел Фибоначчи
        System.out.println(fibonachi(10));


    }

    static int  fibonachi(int n){

        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        else{
            return fibonachi(n - 1) + fibonachi(n - 2);
        }

    }
}
