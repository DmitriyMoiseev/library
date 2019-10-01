package group.library.service;

import group.library.model.Author;
import group.library.model.Book;
import group.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    @Transactional
    public List<Author> allAuthors() {
        return authorRepository.allAuthors();
    }

    @Override
    @Transactional
    public void add(Author author) {
        authorRepository.add(author);
    }

    @Override
    @Transactional
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    @Override
    @Transactional
    public void edit(Author author) {
        authorRepository.edit(author);
    }

    @Override
    @Transactional
    public Author getById(int id) {
        return authorRepository.getById(id);
    }

    @Override
    @Transactional
    public List<Book> getBooks(Author author) {
        return authorRepository.getBooks(author);
    }

}
