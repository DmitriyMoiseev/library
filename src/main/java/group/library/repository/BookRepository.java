package group.library.repository;

import group.library.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> allBooks();
    void add(Book book);
    void delete(Book book);
    void edit(Book book);
    Book getById(int id);
}
