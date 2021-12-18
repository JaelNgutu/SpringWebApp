package group.springframework.spring5webapp.bootstrap;

import group.springframework.spring5webapp.domain.Author;
import group.springframework.spring5webapp.domain.Book;
import group.springframework.spring5webapp.repository.AuthorRepository;
import group.springframework.spring5webapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author jael = new Author("Jael","Ngutu");
        Book sampleBook = new Book("java programming","fbf283");
        jael.getBooks().add(sampleBook);
        sampleBook.getAuthors().add(jael);

        authorRepository.save(jael);
        bookRepository.save(sampleBook);

        Author lucy = new Author("Lucy","May");
        Book sampleBook2 = new Book("java programming 2","fbf283k");
        lucy.getBooks().add(sampleBook2);
        sampleBook2.getAuthors().add(lucy);

        authorRepository.save(lucy);
        bookRepository.save(sampleBook2);

        System.out.println("started in boostrap");
        System.out.println("Number of books:" + bookRepository.count());

    }
}
