package HomeWorks.Modul17_Patterns;

public class StudentB {
    private String firstName;
    private String lastName;
    private int age;

    private StudentB(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    // Внутренний класс Builder
    public static class Builder {
        private String firstName;  // Поле для имени студента
        private String lastName;  // Поле для фамилии студента
        private int age;  // Поле для возраста студента

        // Методы для установки значений полей класса Builder
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        // Метод build(), который возвращает готовый объект Student
        public StudentB build() {
            return new StudentB(firstName, lastName, age);
        }
    }
}
