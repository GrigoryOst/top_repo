package final_project;

import java.util.List;
import java.util.Scanner;

// Главный класс приложения
public class ComicShopApp {
    private static ComicStore store = new ComicStore();
    private static Scanner scanner = new Scanner(System.in);
    private static final String STORE_FILE = "comic_store.txt";


    public static void main(String[] args) {
        boolean authenticated = false;
        while (!authenticated) {
            System.out.println("Добро пожаловать в магазин комиксов!");
            System.out.println("1. Войти");
            System.out.println("2. Зарегистрироваться");
            System.out.print("Выберите опцию: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Введите логин: ");
                String username = scanner.nextLine();
                System.out.print("Введите пароль: ");
                String password = scanner.nextLine();
                authenticated = store.authenticateUser(username, password);
                if (!authenticated) {
                    System.out.println("Неверный логин или пароль!");
                }
            } else if (choice == 2) {
                System.out.print("Выберите логин: ");
                String username = scanner.nextLine();
                System.out.print("Выберите пароль: ");
                String password = scanner.nextLine();
                store.registerUser(username, password);
                System.out.println("Регистрация успешна. Теперь вы можете войти.");
            }
        }

        System.out.println("Аутентификация прошла успешно!");

        // Основной цикл приложения
        while (true) {
            System.out.println("\nМеню управления магазином:");
            System.out.println("1. Добавить комикс");
            System.out.println("2. Удалить комикс");
            System.out.println("3. Поиск комиксов");
            System.out.println("4. Применить скидку");
            System.out.println("5. Продать комикс");
            System.out.println("6. Сохранить состояние магазина");
            System.out.println("7. Загрузить состояние магазина");
            System.out.println("8. Редактировать информацию о комиксе");
            System.out.println("9. Выйти");
            System.out.print("Выберите опцию: ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 1:
                    addComic();
                    break;
                case 2:
                    removeComic();
                    break;
                case 3:
                    searchComics();
                    break;
                case 4:
                    applyDiscount();
                    break;
                case 5:
                    sellComic();
                    break;
                case 6:
                    saveStoreState();
                    break;
                case 7:
                    loadStoreState();
                    break;
                case 8:
                    editComic();
                    break;
                case 9:
                    System.out.println("Выход из программы...");
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private static void addComic() {
        System.out.println("Добавление нового комикса:");
        System.out.print("Введите название: ");
        String title = scanner.nextLine();
        System.out.print("Введите автора: ");
        String author = scanner.nextLine();
        System.out.print("Введите издательство: ");
        String publisher = scanner.nextLine();
        System.out.print("Введите количество страниц: ");
        int pageCount = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите жанр: ");
        String genre = scanner.nextLine();
        System.out.print("Введите год издания: ");
        int year = scanner.nextInt();
        System.out.print("Введите себестоимость: ");
        double costPrice = scanner.nextDouble();
        System.out.print("Введите цену продажи: ");
        double salePrice = scanner.nextDouble();
        System.out.print("Является ли комикс продолжением? (true/false): ");
        boolean isSequel = scanner.nextBoolean();
        System.out.print("Общее количество на складе?: ");
        int quantity = scanner.nextInt();

        Comic comic = new Comic(title, author, publisher, pageCount, genre, year, costPrice, salePrice, isSequel, quantity);
        store.addComic(comic);
        System.out.println("Комикс успешно добавлен!");
    }

    private static void removeComic() {
        System.out.print("Введите название комикса для удаления: ");
        String title = scanner.nextLine();
        store.removeComic(title);
        System.out.println("Комикс удален, если он был в списке.");
    }

    private static void searchComics() {
        System.out.print("Введите название комикса для поиска: ");
        String title = scanner.nextLine();
        System.out.print("Введите автора комикса для поиска: ");
        String author = scanner.nextLine();
        System.out.print("Введите жанр комикса для поиска: ");
        String genre = scanner.nextLine();

        List<Comic> foundComics = store.searchComics(title, author, genre);
        if (foundComics.isEmpty()) {
            System.out.println("Комиксы не найдены.");
        } else {
            System.out.println("Найденные комиксы:");
            for (Comic comic : foundComics) {
                System.out.println(comic.getInfo());
            }
        }
    }

    private static void applyDiscount() {
        System.out.print("Введите жанр для скидки: ");
        String genre = scanner.nextLine();
        System.out.print("Введите размер скидки (в процентах): ");
        double discount = scanner.nextDouble();
        store.applyDiscount(genre, discount);
        System.out.println("Скидка применена ко всем комиксам в жанре " + genre);
    }

    private static void sellComic() {
        System.out.print("Введите название комикса для продажи: ");
        String title = scanner.nextLine();
        store.sellComic(title);
    }

    private static void saveStoreState() {
        store.saveStateToFile(STORE_FILE);
        System.out.println("Состояние магазина сохранено в файл.");
    }

    private static void loadStoreState() {
        store.loadStateFromFile(STORE_FILE);
        System.out.println("Состояние магазина загружено из файла.");
    }

    private static void editComic() {
        System.out.print("Введите название комикса, который хотите редактировать: ");
        String title = scanner.nextLine();

        System.out.print("Введите новое название комикса: ");
        String newTitle = scanner.nextLine();

        System.out.print("Введите имя автора комикса: ");
        String author = scanner.nextLine();

        System.out.print("Введите название издательства: ");
        String publisher = scanner.nextLine();

        System.out.print("Введите количество страниц: ");
        int pageCount = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите жанр комикса: ");
        String genre = scanner.nextLine();

        System.out.print("Введите год издания: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите себестоимость комикса: ");
        double costPrice = scanner.nextDouble();

        System.out.print("Введите цену продажи: ");
        double salePrice = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Является ли комикс продолжением? (да/нет): ");
        boolean isSequel = scanner.nextLine().equalsIgnoreCase("да");

        System.out.print("Введите количество комиксов на складе: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        // Создаем новый объект Comic с полученными данными
        Comic newComic = new Comic(newTitle, author, publisher, pageCount, genre, year, costPrice, salePrice, isSequel, quantity);

        // Вызываем метод для редактирования информации о комиксе
        store.editComic(title, newComic);
        System.out.println("Информация о комиксе обновлена.");
    }


}