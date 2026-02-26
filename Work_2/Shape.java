package Work_2;

public interface Shape {
    double calculateArea();
    double calculatePerimeter();

    String getFillColor();
    String getBorderColor();

    default void printInfo() {
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Цвет фона: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println("----------------------------");
    }
}

