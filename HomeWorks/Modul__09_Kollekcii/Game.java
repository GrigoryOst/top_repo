package HomeWorks.Modul__09_Kollekcii;

import java.util.HashMap;
import java.util.Map;

public class Game {
    String name; // Название игры
    Map<String, Integer> playerRatings; // Словарь для хранения рейтинга игроков

    // Конструктор класса Game
    public Game(String name) {
        this.name = name; // Присваиваем значение аргумента name полю name объекта
        this.playerRatings = new HashMap<>(); // Инициализируем словарь рейтингов как пустой словарь
    }

    // Метод для добавления рейтинга игроку
    public void addRating(String playerNickname, int rating) {
        if (playerNickname != null && !playerNickname.isEmpty()) { // Проверяем, что никнейм не null и не пустой
            playerRatings.put(playerNickname, rating); // Добавляем рейтинг игрока в словарь
        } else {
            throw new IllegalArgumentException("Никнейм не может быть null или пустым"); // Если никнейм null или пустой, выбрасываем исключение
        }
    }
}

