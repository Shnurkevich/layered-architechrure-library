package by.htp.library.bean;

import java.util.Objects;

public class Book {
    private static final long serialVersionUID = 1L;

    private long idBook;
    private String bookName;
    private String author;
    private int numberOfPages;
    private int year;

    public Book() {
    }

    public Book(long idBook, String bookName, String author, int numberOfPages, int year) {
        this.idBook = idBook;
        this.bookName = bookName;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.year = year;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return idBook == book.idBook && numberOfPages == book.numberOfPages && year == book.year && Objects.equals(bookName, book.bookName) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBook, bookName, author, numberOfPages, year);
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", year=" + year +
                '}';
    }
}
