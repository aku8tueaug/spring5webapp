package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.HelperClass.Address;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in BootStrap");

        Publisher gp = new Publisher("Geeta Press", "Gorakhpur", "Gorakhpur", "UP" , "822101");
        publisherRepository.save(gp);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(gp);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        gp.getBooks().add(ddd);
        publisherRepository.save(gp);

        Author rod = new Author("Rod", "Jhonson");
        Book noEjb = new Book("J2EE without EJB", "123456");
        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);
        noEjb.setPublisher(gp);
        authorRepository.save(rod);
        bookRepository.save(noEjb);
        gp.getBooks().add(noEjb);
        publisherRepository.save(gp);
        System.out.println("Number of publisher : " + publisherRepository.count());
        System.out.println("Number of books publisher published : " + gp.getBooks().size());

        System.out.println("Number of Books : " + bookRepository.count());


    }
}
