package Work_6;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "123-45-67");
        phoneBook.add("Иванов", "987-65-43");
        phoneBook.add("Петров", "555-55-55");
        phoneBook.add("Сидоров", "111-22-33");

        printPhones(phoneBook, "Иванов");
        printPhones(phoneBook, "Петров");
        printPhones(phoneBook, "Смирнов");
    }

    private static void printPhones(PhoneBook phoneBook, String lastName) {
        List<String> phones = phoneBook.get(lastName);

        if (phones.isEmpty()) {
            System.out.println("Фамилия " + lastName + " не найдена.");
        } else {
            System.out.println("Телефоны для " + lastName + ":");
            for (String phone : phones) {
                System.out.println(phone);
            }
        }

        System.out.println();
    }
}
