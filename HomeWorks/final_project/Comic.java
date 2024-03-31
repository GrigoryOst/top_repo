package final_project;

import java.io.Serializable;

public class Comic implements Serializable {
    // Поля класса для хранения информации о комиксе
    private String title; // Название комикса
    private String author; // ФИО художника/автора
    private String publisher; // Название издательства комикса
    private int pageCount; // Количество страниц
    private String genre; // Жанр
    private int year; // Год издания
    private double costPrice; // Себестоимость
    private double salePrice; // Цена для продажи
    private boolean isSequel; // Является ли комикс продолжением какого-то другого комикса или серии комиксов
    private int quantity; // Количество комиксов на складе

    // Конструктор класса
    public Comic (String title, String author, String publisher, int pageCount, String genre, int year, double costPrice, double salePrice, boolean isSequel, int quantity) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pageCount = pageCount;
        this.genre = genre;
        this.year = year;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.isSequel = isSequel;
        this.quantity = quantity;
    }

    // Геттеры и сеттеры для полей класса

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getSalePrice(double v) {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public boolean isSequel() {
        return isSequel;
    }

    public void setSequel(boolean sequel) {
        isSequel = sequel;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getInfo() {
        return String.format("Название: %s, Автор: %s, Издательство: %s, Страниц: %d, Жанр: %s, Год: %d, Себестоимость: %.2f, Цена продажи: %.2f, Продолжение: %b, Количество: %d",
                title, author, publisher, pageCount, genre, year, costPrice, salePrice, isSequel, quantity);
    }

}
