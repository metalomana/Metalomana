package Work_4;

public class Main {

    public static int processArray(String[][] array)
            throws MyArraySizeException, MyArrayDataException {

        if (array.length != 4) {
            throw new MyArraySizeException(
                    "Неверное количество строк: " + array.length + ". Ожидалось 4."
            );
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException(
                        "Неверное количество столбцов в строке " + i +
                                ": " + array[i].length + ". Ожидалось 4."
                );
            }
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            "Неверные данные в ячейке [" + i + "][" + j + "]: "
                                    + array[i][j]
                    );
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = processArray(array);
            System.out.println("Сумма элементов массива: " + result);

        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера массива: " + e.getMessage());

        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных массива: " + e.getMessage());
        }
        try {
            String[] testArray = {"A", "B", "C"};

            System.out.println(testArray[5]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Перехвачено исключение ArrayIndexOutOfBoundsException!");
            System.out.println("Попытка доступа к несуществующему индексу.");
        }
    }
}
