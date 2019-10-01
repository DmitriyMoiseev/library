package group.library.repository;

import group.library.model.Author;
import group.library.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Author> allAuthors() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Author").list();
    }

    @Override
    public void add(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(author);
    }

    @Override
    public void delete(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(author);
    }

    @Override
    public void edit(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.update(author);
    }

    @Override
    public Author getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Author.class, id);
    }

    @Override
    public List<Book> getBooks(Author author){
        List<Book> books = author.getBooks();
        return books;
    }

}
