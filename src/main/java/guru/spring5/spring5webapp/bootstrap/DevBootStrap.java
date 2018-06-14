package guru.spring5.spring5webapp.bootstrap;

import guru.spring5.spring5webapp.model.Author;
import guru.spring5.spring5webapp.model.Book;
import guru.spring5.spring5webapp.model.Publisher;
import guru.spring5.spring5webapp.repositories.AuthorRepository;
import guru.spring5.spring5webapp.repositories.BookRepository;
import guru.spring5.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    public void initData(){
        //Eric
        Author eric= new Author("Eric", "Evans");
        Publisher pub1= new Publisher("Wrox", "adrress1");
        Book book1 = new Book("Domain Driven Design","1234",pub1);
        publisherRepository.save(pub1);
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(book1);
        //Rod
        Author rod= new Author("Rod", "Johnson");
        Book book2= new Book("J2EE Guide","1458",pub1);
        rod.getBooks().add(book2);
        authorRepository.save(rod);
        bookRepository.save(book2);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
