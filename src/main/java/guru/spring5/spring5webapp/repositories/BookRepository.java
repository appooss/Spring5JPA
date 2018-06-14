package guru.spring5.spring5webapp.repositories;

import guru.spring5.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
