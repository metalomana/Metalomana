package org.example;

import java.util.Scanner;

public class CompareNumbersProgram {

    public static String compare(int a, int b) {

        if (a > b) {
            return "Первое число больше второго";
        } else if (a < b) {
            return "Первое число меньше второго";
        } else {
            return "Числа равны";
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int a = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int b = scanner.nextInt();

        System.out.println(compare(a, b));
    }
}
