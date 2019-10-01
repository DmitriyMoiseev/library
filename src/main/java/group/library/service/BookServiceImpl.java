package group.library.service;

import group.library.model.Book;
import group.library.repository.BookRepository;
import group.library.repository.BookRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public List<Book> allBooks() {
        return bookRepository.allBooks();
    }

    @Override
    @Transactional
    public void add(Book book) {
        bookRepository.add(book);
    }

    @Override
    @Transactional
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    @Transactional
    public void edit(Book book) {
        bookRepository.edit(book);
    }

    @Override
    @Transactional
    public Book getById(int id) {
        return bookRepository.getById(id);
    }
}
