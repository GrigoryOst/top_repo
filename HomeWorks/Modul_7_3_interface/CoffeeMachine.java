package HomeWorks.Modul_7_3_interface;

/*Завод выпускает разные модели кофемашин, с различными характеристиками.
Кофемашина загружается молотым кофе и водой.
Максимальные значения загрузки зависят от модели.
На приготовление одной чашки тратится:
эспрессо – 22 г молотого кофе и 30 мл;
американо – 22 г молотого кофе и 100 мл воды.
Отработанное кофе сбрасывается в специальный бак, емкость бака зависит от модели.
Кофемашина может выдавать различные ошибки при работе.
Отсутствует вода.
Отсутствует молотое кофе.
Переполнен бак с отработанным кофе.
Кофемашина имеет кнопки:
включения;
выключения;
Приготовить эспрессо;
Приготовить американо;
Очистка бака отработанного кофе.
После модернизации, завод начал выпускать новые кофемашины,
        позволяющие кроме предыдуших функций готовить капучино и лате.
Добавилась встроенная емкость для молока, размер емкости зависит от марки кофемашины.
Добавилась ошибка:
Отсутствует молоко.
Добавились кнопки:
Приготовить лате;
Приготовить капучино.
Количество молока, которое тратится на приготовление капучино и лате,
        задается во время приготовления.
        Количество потребляемого кофе и воды,
        как при приготовлении чашки эспрессо.*/
class CoffeeMachine {
    private int maxCoffee; // Максимальное количество молотого кофе
    private int maxWater; // Максимальное количество воды
    private int maxCoffeeWaste; // Максимальная емкость бака с отработанным кофе
    private int maxMilk; // Максимальное количество молока
    private boolean hasPower; // Наличие питания
    private boolean hasWater; // Наличие воды
    private boolean hasCoffee; // Наличие молотого кофе
    private boolean hasCoffeeWaste; // Наличие отработанного кофе
    private boolean hasMilk; // Наличие молока

    // Конструктор для инициализации максимальных значений и начального состояния кофемашины
    public CoffeeMachine(int maxCoffee, int maxWater, int maxCoffeeWaste,
                         int maxMilk, boolean hasPower, boolean hasWater,
                         boolean hasCoffee, boolean hasCoffeeWaste, boolean hasMilk) {
        this.maxCoffee = maxCoffee;
        this.maxWater = maxWater;
        this.maxCoffeeWaste = maxCoffeeWaste;
        this.maxMilk = maxMilk;
        hasPower = false;
        hasWater = false;
        hasCoffee = false;
        hasCoffeeWaste = false;
        hasMilk = false;
    }

    // Метод для включения кофемашины
    public void powerOn() {
        hasPower = true;
        System.out.println("Кофемашина включена");
    }

    // Метод для выключения кофемашины
    public void powerOff() {
        hasPower = false;
        System.out.println("Кофемашина выключена");
    }

    // Метод для загрузки молотого кофе
    public void loadCoffee() {
        if (hasPower && !hasCoffee) {
            hasCoffee = true;
            System.out.println("Молотый кофе загружен");
        } else {
            System.out.println("Ошибка: Кофемашина выключена или уже загружен молотый кофе");
        }
    }

    // Метод для загрузки воды
    public void loadWater() {
        if (hasPower && !hasWater) {
            hasWater = true;
            System.out.println("Вода загружена");
        } else {
            System.out.println("Ошибка: Кофемашина выключена или уже загружена вода");
        }
    }

    // Метод для загрузки молока
    public void loadMilk() {
        if (hasPower && !hasMilk) {
            hasMilk = true;
            System.out.println("Молоко загружено");
        } else {
            System.out.println("Ошибка: Кофемашина выключена или уже загружено молоко");
        }
    }

    // Метод для приготовления эспрессо
    public void makeEspresso() {
        if (hasPower && hasWater && hasCoffee) {
            if (hasMilk) {
                System.out.println("Приготовлено эспрессо с молоком");
            } else {
                System.out.println("Приготовлено эспрессо");
            }
            hasWater = false;
            hasCoffee = false;
        } else {
            System.out.println("Ошибка: Отсутствует вода или молотый кофе");
        }
    }

    // Метод для приготовления капучино
    public void makeCappuccinoOrLatte(int milkAmount) {
        if (hasPower && hasWater && hasCoffee && hasMilk) {
            if (milkAmount == 100) {
                System.out.println("Приготовлено капучино");
            } else if (milkAmount > 100) {
                System.out.println("Приготовлено латте");
            }
            hasWater = false;
            hasCoffee = false;
            hasMilk = false;
        } else {
            System.out.println("Ошибка: Отсутствует вода, молотый кофе или молоко");
        }
    }


    // Метод для сброса отработанного кофе
    public void emptyCoffeeWaste() {
        if (hasPower && hasCoffeeWaste) {
            hasCoffeeWaste = false;
            System.out.println("Отработанный кофе сброшен");
        } else {
            System.out.println("Ошибка: Кофемашина выключена или отработанный кофе уже сброшен");
        }
    }

    // Метод для проверки состояния кофемашины
    public void checkStatus() {
        System.out.println("Максимальное количество молотого кофе: " + maxCoffee);
        System.out.println("Максимальное количество воды: " + maxWater);
        System.out.println("Максимальная емкость бака с отработанным кофе: " + maxCoffeeWaste);
        System.out.println("Максимальное количество молока: " + maxMilk);
        System.out.println("Состояние питания: " + (hasPower ? "Включено" : "Выключено"));
        System.out.println("Состояние воды: " + (hasWater ? "Загружена" : "Отсутствует"));
        System.out.println("Состояние молотого кофе: " + (hasCoffee ? "Загружен" : "Отсутствует"));
        System.out.println("Состояние отработанного кофе: " + (hasCoffeeWaste ? "Загружен" : "Отсутствует"));
        System.out.println("Состояние молока: " + (hasMilk ? "Загружено" : "Отсутствует"));
    }
}