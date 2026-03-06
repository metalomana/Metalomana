package Work_5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Student> students = new HashSet<>();

        students.add(new Student("Иван", "A1", 1, Arrays.asList(5, 4, 4)));
        students.add(new Student("Мария", "A1", 1, Arrays.asList(2, 3, 2)));
        students.add(new Student("Алексей", "B2", 2, Arrays.asList(3, 3, 4)));
        students.add(new Student("Ольга", "B2", 2, Arrays.asList(5, 5, 5)));

        System.out.println("До удаления:");
        students.forEach(System.out::println);

        StudentService.removeLowAverageStudents(students);

        System.out.println("\nПосле удаления студентов со средним < 3:");
        students.forEach(System.out::println);

        StudentService.promoteStudents(students);

        System.out.println("\nПосле перевода на следующий курс:");
        students.forEach(System.out::println);

        System.out.println("\nСтуденты 2 курса:");
        StudentService.printStudents(students, 2);
    }
}
