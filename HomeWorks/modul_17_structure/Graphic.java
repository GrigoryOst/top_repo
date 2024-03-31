package HomeWorks.modul_17_structure;

import java.util.ArrayList;
import java.util.List;

// Интерфейс графического элемента
interface Graphic {
    void draw();
}

// Класс круга
class Circle implements Graphic {
    // Метод для рисования круга
    public void draw() {
        System.out.println("Рисование круга");
    }
}

// Класс прямоугольника
class Rectangle_ implements Graphic {
    // Метод для рисования прямоугольника
    public void draw() {
        System.out.println("Рисование прямоугольника");
    }
}

// Класс группы элементов
class Group implements Graphic {
    private List<Graphic> graphics = new ArrayList<>();

    // Метод для добавления элемента в группу
    public void add(Graphic graphic) {
        graphics.add(graphic);
    }

    // Метод для рисования группы элементов
    public void draw() {
        for (Graphic graphic : graphics) {
            graphic.draw();
        }
    }
}

// Класс файла
class File {
    private int size;

    // Конструктор класса File
    public File(int size) {
        this.size = size;
    }

    // Метод для получения размера файла
    public int getSize() {
        return size;
    }
}

// Класс директории
class Directory {
    private List<File> files = new ArrayList<>();

    // Метод для добавления файла в директорию
    public void addFile(File file) {
        files.add(file);
    }

    // Метод для получения размера директории
    public int getSize() {
        int totalSize = 0;
        for (File file : files) {
            totalSize += file.getSize();
        }
        return totalSize;
    }
}