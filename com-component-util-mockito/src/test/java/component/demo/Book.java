package component.demo;

import java.util.List;

/**
 * Created by wangjianjun on 2017/8/4.
 */
public class Book {

    private String isbn;
    private String title;
    private List<String> authors;
    private Integer price;

    public Book(String isbn, String title, List<String> authors, Integer price) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", price=" + price +
                '}';
    }
}
