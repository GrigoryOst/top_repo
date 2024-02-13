package HomeWorks.Modul17_Patterns.Factory;


public class StudentFactory extends FactoryMethod{
    @Override
    public Student createStudent() {
        // Возвращает объект UndergraduateStudent
        return new UndergraduateStudent();
    }
}
