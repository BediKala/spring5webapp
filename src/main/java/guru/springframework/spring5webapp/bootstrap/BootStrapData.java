package guru.springframework.spring5webapp.bootstrap;

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
        Publisher publisher = new Publisher("Verlag","Gerhardstraße","Völklingen","66333");
        publisherRepository.save(publisher);

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthor().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        Author bedi = new Author("Bedirhan","Kalabalik");
        Book abc = new Book("HTW","434543523");
        bedi.getBooks().add(abc);
        abc.getAuthor().add(bedi);
        authorRepository.save(bedi);
        bookRepository.save(abc);
        abc.setPublisher(publisher);
        publisher.getBooks().add(abc);

        Author cartman = new Author("Eric" , "Cartman");
        authorRepository.save(cartman);

        System.out.println("starts in BootStrap..");
        System.out.println(publisher);
        System.out.println("Publisher number of books: "+ publisher.getBooks().size());
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of books: " + bookRepository.count());
    }
}
