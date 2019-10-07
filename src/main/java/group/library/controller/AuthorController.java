package group.library.controller;

import group.library.model.Author;
import group.library.model.Book;
import group.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public ModelAndView showAllAuthors() {
        List<Author> authors = authorService.allAuthors();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("authors");
        modelAndView.addObject("authorList", authors);
        return modelAndView;
    }

    @RequestMapping(value = "/author/edit/{id}", method = RequestMethod.GET)
    public ModelAndView showEditAuthorPage(@PathVariable("id") int id) {
        Author author = authorService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPageAuthor");
        modelAndView.addObject("author", author);
        return modelAndView;
    }

    @RequestMapping(value = "/author/edit", method = RequestMethod.POST)
    public ModelAndView editAuthor(@ModelAttribute("author") Author author) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/author/");
        authorService.edit(author);
        return modelAndView;
    }

    @RequestMapping(value = "/author/add", method = RequestMethod.GET)
    public ModelAndView showAuthorAddPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPageAuthor");
        return modelAndView;
    }

    @RequestMapping(value = "/author/add", method = RequestMethod.POST)
    public ModelAndView addAuthor(@ModelAttribute("author") Author author) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/author");
        authorService.add(author);
        return modelAndView;
    }

    @RequestMapping(value="/author/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteAuthor(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/author");
        Author author = authorService.getById(id);
        authorService.delete(author);
        return modelAndView;
    }

    @RequestMapping(value="/author/show/{id}", method = RequestMethod.GET)
    public ModelAndView showBooksOfAuthor(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("books");
        Author author = authorService.getById(id);
        List<Book> books = authorService.getBooks(author);
        modelAndView.addObject("booksList", books);
        return modelAndView;
    }
}
