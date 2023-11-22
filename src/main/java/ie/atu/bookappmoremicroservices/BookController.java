package ie.atu.bookappmoremicroservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        if (bookService.bookExists(book.getTitle())) {
            return ResponseEntity.badRequest().body("Book with title '" + book.getTitle() + "' already exists");
        }

        bookService.addBook(book);
        return ResponseEntity.ok("Book added successfully");
    }
}