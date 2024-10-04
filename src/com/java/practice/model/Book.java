package com.java.practice.model;

public class Book implements Comparable<Book>{
    private String title;
    private Double price;

    public Book(String title, Double price) {
        this.title = title;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Book otherBook) {
        return this.title.compareTo(otherBook.getTitle());
//        return otherBook.getPrice().compareTo(price);
    }
}
