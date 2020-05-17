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
public class BootStrap implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootStrap(BookRepository bookRepository,
                     AuthorRepository authorRepository,
                     PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Publisher tataMcgrawHill = new Publisher("Tata Mcgraw Hill", "121 Dickenson Road" ,"Bengaluru" ,"KA" ,"560001");
        publisherRepository.save(tataMcgrawHill);

        Book wingsOfFire = new Book("Wings of Fire", "ISBN000001");
        Author abdulKalam = new Author("Abdul", "Kalam");
        wingsOfFire.getAuthorSet().add(abdulKalam);
        wingsOfFire.setPublisher(tataMcgrawHill);
        abdulKalam.getBookSet().add(wingsOfFire);
        authorRepository.save(abdulKalam);
        bookRepository.save(wingsOfFire);

        Book experimentsWithTruth = new Book("My Experiments with Truth", "ISBN000011001");
        Author gandhi = new Author("Mohandas", "Gandhi");
        experimentsWithTruth.getAuthorSet().add(gandhi);
        experimentsWithTruth.setPublisher(tataMcgrawHill);
        gandhi.getBookSet().add(experimentsWithTruth);
        authorRepository.save(gandhi);
        bookRepository.save(experimentsWithTruth);

        System.out.println("Book Count:"+ bookRepository.count());
        System.out.println("Author Count:"+ authorRepository.count());
        System.out.println("Publisher Count:"+ publisherRepository.count());

    }
}
