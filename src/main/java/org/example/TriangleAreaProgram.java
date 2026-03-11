package org.example;

import java.util.Scanner;

public class TriangleAreaProgram {

    public static double calculateArea(double a, double b, double c) {

        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сторону a: ");
        double a = scanner.nextDouble();

        System.out.print("Введите сторону b: ");
        double b = scanner.nextDouble();

        System.out.print("Введите сторону c: ");
        double c = scanner.nextDouble();

        double area = calculateArea(a, b, c);

        System.out.println("Площадь треугольника = " + area);
    }
}
