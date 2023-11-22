package ie.atu.bookappmoremicroservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public boolean bookExists(String title) {
        return bookRepository.existsByTitle(title);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }
}