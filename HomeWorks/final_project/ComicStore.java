package final_project;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Класс ComicStore для управления магазином комиксов
public class ComicStore {
    // Список комиксов в магазине
    private List<Comic> comics = new ArrayList<>();
    private final Map<String, String> userCredentials = new HashMap<>();

    // Метод для добавления нового комикса в магазин
    public void addComic(Comic comic) {
        comics.add(comic); // Добавляем комикс в список
    }

    // Метод для удаления комикса из магазина по названию
    public void removeComic(String title) {
        comics.removeIf(comic -> comic.getTitle().equals(title)); // Удаляем комикс с заданным названием
    }

    // Метод для редактирования информации о комиксе
    public void editComic(String title, Comic newComic) {
        for (int i = 0; i < comics.size(); i++) { // Перебираем все комиксы
            if (comics.get(i).getTitle().equals(title)) { // Если находим нужный
                comics.set(i, newComic); // Заменяем его на новый
                break;
            }
        }
    }

    // Метод для продажи комикса
    public void sellComic(String title) {
        // Поиск комикса по названию
        for (Comic comic : comics) {
            if (comic.getTitle().equals(title)) {
                // Проверка наличия комикса на складе
                if (comic.getQuantity() > 0) {
                    // Уменьшение количества комикса на складе
                    comic.setQuantity(comic.getQuantity() - 1);
                    System.out.println("Комикс продан: " + title);
                } else {
                    System.out.println("Комикс " + title + " отсутствует на складе.");
                }
                return;
            }
        }
        System.out.println("Комикс с названием " + title + " не найден.");
    }


    // Метод для проведения акции на комиксы
    public void applyDiscount(String genre, double discount) {
        for (Comic comic : comics) {
            if (comic.getGenre().equals(genre)) {
                double newPrice = comic.getSalePrice(10.0) * (1 - discount / 100);
                comic.setSalePrice(newPrice);
            }
        }
    }

    // Метод для поиска комиксов по параметрам
    public List<Comic> searchComics(String title, String author, String genre) {
        return comics.stream()
                .filter(comic -> comic.getTitle().contains(title) || comic.getAuthor().contains(author) || comic.getGenre().contains(genre))
                .collect(Collectors.toList());
    }

    public ComicStore() {
        loadUserCredentials();
    }

    // Метод для загрузки учетных данных пользователей из файла
    private void loadUserCredentials() {
        try (BufferedReader reader = new BufferedReader(new FileReader("credentials.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    userCredentials.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для сохранения учетных данных пользователя в файл
    private void saveUserCredentials(String username, String password) {
        try (FileWriter writer = new FileWriter("credentials.txt", true)) {
            writer.write(username + ":" + password + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для регистрации пользователя
    public void registerUser(String username, String password) {
        userCredentials.put(username, password);
        saveUserCredentials(username, password);
    }

    // Метод для аутентификации пользователя
    public boolean authenticateUser(String username, String password) {
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }


    // Метод для сохранения состояния магазина в файл
    public void saveStateToFile(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(comics);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для загрузки состояния магазина из файла
    public void loadStateFromFile(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            comics = (List<Comic>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
