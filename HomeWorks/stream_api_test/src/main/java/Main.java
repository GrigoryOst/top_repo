import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Создаем список студентов
        List<Student> students = Arrays.asList(
                new Student("Alice", 20),
                new Student("Bob", 22),
                new Student("Charlie", 21),
                new Student("David", 23)
        );

        // Используем Stream API для подсчета среднего возраста
        OptionalDouble averageAge = students.stream()       // Создаем стрим из списка студентов
                .mapToInt(Student::getAge)                      // Преобразуем стрим студентов в стрим их возрастов
                .average();                                     // Считаем средний возраст

        // Проверяем, присутствует ли значение и выводим результат
        if (averageAge.isPresent()) {
            System.out.println("Средний возраст студентов: " + averageAge.getAsDouble());
        } else {
            System.out.println("Список студентов пуст.");
        }
    }
}
