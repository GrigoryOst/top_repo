package HomeWorks.modul_8_isklucenia;

/*Задание 2
        Создать метод, принимающий на вход число. В случае, если число отрицательное,
        в методе должно быть брошено проверяемое исключение.
        Если число больше 100, должно быть брошено непроверяемое исключение.
        Создать свои исключения для данного примера.*/

public class Main2 {
    public static void main(String[] args) {
        try {
            checkNumber(-1); // Проверяемое исключение
            checkNumber(101); // Непроверяемое исключение
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkNumber(int number) throws Exception {
        if (number < 0) {
            throw new CheckedExc("Число отрицательное");
        }
        if (number > 100) {
            throw new UncheckedExc("Число больше 100");
        }
    }
}

class CheckedExc extends Exception {
    public CheckedExc(String message) {
        super(message);
    }
}

class UncheckedExc extends RuntimeException {
    public UncheckedExc(String message) {
        super(message);
    }
}
