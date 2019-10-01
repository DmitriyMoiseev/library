package group.library.repository;

import group.library.model.Author;
import group.library.model.Book;

import java.util.List;

public interface AuthorRepository {
    List<Author> allAuthors();
    void add(Author author);
    void delete(Author author);
    void edit(Author author);
    Author getById(int id);
    List<Book> getBooks(Author author);
}
