package HomeWorks.Modul__09_Kollekcii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingSystem {
    List<Player> players; // Список всех игроков в системе
    List<Game> games; // Список всех игр в системе

    // Конструктор класса RatingSystem
    public RatingSystem() {
        players = new ArrayList<>(); // Инициализируем список игроков как пустой список
        games = new ArrayList<>(); // Инициализируем список игр как пустой список
    }

    // Метод для регистрации нового игрока в системе
    public void registerPlayer(String nickname) {
        for (Player player : players) { // Проходим по всем игрокам в списке
            if (player.nickname.equals(nickname)) { // Если никнейм игрока совпадает с аргументом nickname, выбрасываем исключение
                throw new IllegalArgumentException("Никнейм уже занят!");
            }
        }
        Player newPlayer = new Player(nickname); // Создаем нового игрока с никнеймом nickname
        players.add(newPlayer); // Добавляем нового игрока в список
    }

    // Метод для добавления новой игры в систему
    public void addGame(String gameName) {
        for (Game game : games) { // Проходим по всем играм в списке
            if (game.name.equals(gameName)) { // Если название игры совпадает с аргументом gameName, выбрасываем исключение
                throw new IllegalArgumentException("Игра с таким названием уже существует!");
            }
        }
        Game newGame = new Game(gameName); // Создаем новую игру с названием gameName
        games.add(newGame); // Добавляем новую игру в список
    }

    // Метод для добавления рейтинга игроку
    public void addRating(String playerNickname, String gameName, int rating) {
        for (Player player : players) { // Проходим по всем игрокам в списке
            if (player.nickname.equals(playerNickname)) { // Если никнейм игрока совпадает с аргументом playerNickname
                for (Game game : player.games) { // Проходим по всем играм, в которые играет игрок
                    if (game.name.equals(gameName)) { // Если название игры совпадает с аргументом gameName
                        game.addRating(playerNickname, rating); // Добавляем рейтинг игроку
                        return; // Завершаем метод
                    }
                }
                throw new IllegalArgumentException("Игрок не играет в эту игру!"); // Если игрок не играет в эту игру, выбрасываем исключение
            }
        }
        throw new IllegalArgumentException("Игрок с таким никнеймом не зарегистрирован!"); // Если игрок с таким никнеймом не зарегистрирован, выбрасываем исключение
    }

    // Метод для вывода списка всех игр
    public void printGames() {
        System.out.println("Список всех игр:");
        for (Game game : games) { // Проходим по всем играм в списке
            System.out.println(game.name); // Выводим название каждой игры
        }
    }

    // Метод для вывода рейтинга игрока в определенной игре
    public void printRating(String playerNickname, String gameName) {
        for (Player player : players) { // Проходим по всем игрокам в списке
            if (player.nickname.equals(playerNickname)) { // Если никнейм игрока совпадает с аргументом playerNickname
                for (Game game : player.games) { // Проходим по всем играм, в которые играет игрок
                    if (game.name.equals(gameName)) { // Если название игры совпадает с аргументом gameName
                        System.out.println("Рейтинг игрока " + playerNickname + " в игре " + gameName + ": " + game.playerRatings.get(playerNickname)); // Выводим рейтинг игрока
                        return; // Завершаем метод
                    }
                }
            }
        }
        System.out.println("Не найдено информации о рейтинге игрока " + playerNickname + " в игре " + gameName); // Если информация о рейтинге не найдена, выводим сообщение
    }

    // Метод для вывода топ игроков с учетом всех игр
    public void printTopPlayersOverall() {
        System.out.println("Топ игроков с учетом всех игр:");
        Map<String, Integer> overallRatings = new HashMap<>(); // Создаем словарь для хранения общего рейтинга игроков
        for (Player player : players) { // Проходим по всем игрокам в списке
            for (Game game : player.games) { // Проходим по всем играм, в которые играет игрок
                for (Map.Entry<String, Integer> entry : game.playerRatings.entrySet()) {
                    // Добавляем рейтинг игрока в общий рейтинг с учетом всех игр
                    overallRatings.put(entry.getKey(), overallRatings.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }
            }
        }
        // Сортируем общий рейтинг игроков и выводим топ-10 игроков
        overallRatings.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .forEach(entry -> System.out.println("Игрок: " + entry.getKey() + ", Общий рейтинг: " + entry.getValue()));
    }

}
