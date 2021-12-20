package group.springframework.spring5webapp.bootstrap;

import group.springframework.spring5webapp.domain.Author;
import group.springframework.spring5webapp.domain.Book;
import group.springframework.spring5webapp.domain.Publisher;
import group.springframework.spring5webapp.repository.AuthorRepository;
import group.springframework.spring5webapp.repository.BookRepository;
import group.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("Nairobi publishers");
        publisher.setCity("Nairobi");
        publisher.setState("NRB");

        publisherRepository.save(publisher);

        Author jael = new Author("Jael","Ngutu");
        Book sampleBook = new Book("java programming","fbf283");
        jael.getBooks().add(sampleBook);
        sampleBook.getAuthors().add(jael);

        sampleBook.setPublisher(publisher);
        publisher.getBooks().add(sampleBook);

        authorRepository.save(jael);
        bookRepository.save(sampleBook);
        publisherRepository.save(publisher);

        Author lucy = new Author("Lucy","May");
        Book sampleBook2 = new Book("angular programming 2","fbf283k");
        lucy.getBooks().add(sampleBook2);
        sampleBook2.getAuthors().add(lucy);

        sampleBook2.setPublisher(publisher);
        publisher.getBooks().add(sampleBook2);



        authorRepository.save(lucy);
        bookRepository.save(sampleBook2);
        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());


        System.out.println("Number of books:" + bookRepository.count());
        System.out.println("Publisher no of books " + publisher.getBooks().size());

    }
}
