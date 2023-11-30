package com.dsa.comvivaUdemyProjects.booksManagement;

import java.util.ArrayList;


public class BookService {
    public Book[] filterBooksByAuthor(Author author, Book[] books) {
        if (books == null) {
            return new Book[0]; // Return an empty book array if books is null
        }

        ArrayList<Book> filteredBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.getAuthors() != null) {
                for (Author bookAuthor : book.getAuthors()) {
                    if (bookAuthor != null && bookAuthor.equals(author)) {
                        filteredBooks.add(book);
                        break;
                    }
                }
            }
        }

        return filteredBooks.toArray(new Book[0]);
    }

    public Book[] filterBooksByPublisher(Publisher publisher, Book[] books) {
        if (books == null) {
            return new Book[0]; // Return an empty book array if books is null
        }

        ArrayList<Book> filteredBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.getPublisher() != null && book.getPublisher().equals(publisher)) {
                filteredBooks.add(book);
            }
        }

        return filteredBooks.toArray(new Book[0]);
    }

    public Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) {
        if (books == null) {
            return new Book[0]; // Return an empty book array if books is null
        }

        ArrayList<Book> filteredBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.getPublisherYear() >= yearFromInclusively) {
                filteredBooks.add(book);
            }
        }

        if (filteredBooks.isEmpty()) {
            return new Book[0]; // Return an empty book array if no books match the specified condition
        }

        return filteredBooks.toArray(new Book[0]);

    }
}
