package com.dsa.comvivaUdemyProjects.booksManagement;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

public class Book {

    int id;
    String name;
    Author[] authors;
    Publisher publisher;
    int publisherYear;
    int amountOfPages;
    BigDecimal price;
    CoverType coverType;

    public Book(int id, String name, Author[] authors, Publisher publisher, int publisherYear,
                int amountOfPages, BigDecimal price, CoverType coverType) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.publisherYear = publisherYear;
        this.amountOfPages = amountOfPages;
        this.price = price;
        this.coverType = coverType;
    }
    public Book(int id, String name, Author[] authors, Publisher publisher) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.publisherYear = 0; // Default value
        this.amountOfPages = 0; // Default value
        this.price = BigDecimal.ZERO; // Default value
        this.coverType = null; // Default value
    }

    // Constructor with only essential attributes
    public Book(int id, String name, Author[] authors) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.publisher = null; // Default value
        this.publisherYear = 0; // Default value
        this.amountOfPages = 0; // Default value
        this.price = BigDecimal.ZERO; // Default value
        this.coverType = null; // Default value
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                publisherYear == book.publisherYear &&
                amountOfPages == book.amountOfPages &&
                Objects.equals(name, book.name) &&
                Arrays.equals(authors, book.authors) &&
                Objects.equals(publisher, book.publisher) &&
                Objects.equals(price, book.price) &&
                coverType == book.coverType;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, publisher, publisherYear, amountOfPages, price, coverType);
        result = 31 * result + Arrays.hashCode(authors);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", publisher=" + publisher +
                ", publisherYear=" + publisherYear +
                ", amountOfPages=" + amountOfPages +
                ", price=" + price +
                ", coverType=" + coverType +
                '}';
    }

    public Author[] getAuthors() {
        return authors;
    }
    public Publisher getPublisher() {
        return publisher;
    }

    public int getPublisherYear() {
        return publisherYear;
    }
}
