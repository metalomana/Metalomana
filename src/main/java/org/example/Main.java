package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите программу:");
        System.out.println("1 - Факториал числа");
        System.out.println("2 - Площадь треугольника");
        System.out.println("3 - Арифметические операции");
        System.out.println("4 - Сравнение чисел");

        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Введите число: ");
                int n = scanner.nextInt();

                if (n < 0) {
                    System.out.println("Факториал отрицательного числа не определён");
                } else {
                    long result = FactorialProgram.factorial(n);
                    System.out.println("Факториал = " + result);
                }
                break;

            case 2:
                System.out.print("Введите сторону a: ");
                double a = scanner.nextDouble();

                System.out.print("Введите сторону b: ");
                double b = scanner.nextDouble();

                System.out.print("Введите сторону c: ");
                double c = scanner.nextDouble();

                double area = TriangleAreaProgram.calculateArea(a, b, c);

                System.out.println("Площадь треугольника = " + area);
                break;

            case 3:
                System.out.print("Введите первое число: ");
                int x = scanner.nextInt();

                System.out.print("Введите второе число: ");
                int y = scanner.nextInt();

                System.out.println("Сложение: " + ArithmeticProgram.add(x, y));
                System.out.println("Вычитание: " + ArithmeticProgram.subtract(x, y));
                System.out.println("Умножение: " + ArithmeticProgram.multiply(x, y));

                try {
                    System.out.println("Деление: " + ArithmeticProgram.divide(x, y));
                } catch (ArithmeticException e) {
                    System.out.println("Ошибка: деление на ноль");
                }

                break;

            case 4:
                System.out.print("Введите первое число: ");
                int a1 = scanner.nextInt();

                System.out.print("Введите второе число: ");
                int b1 = scanner.nextInt();

                System.out.println(CompareNumbersProgram.compare(a1, b1));
                break;

            default:
                System.out.println("Неверный выбор");
        }

        scanner.close();
    }
}
