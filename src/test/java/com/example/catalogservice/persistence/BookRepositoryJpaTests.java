package com.example.catalogservice.persistence;

import java.time.Year;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.catalogservice.domain.Book;

@DataJpaTest // Identifies a test class the focuses on JPA components.
@Import(JpaConfig.class) // Imports JPA configuration. Needed to enable auditing.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Disables the default behavior relying on an embedded test database since you’re using Testcontainers.
public class BookRepositoryJpaTests {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	void findBookByIsbnWhenExisting() {
		String bookIsbn = "1234561235";
		Book expectedBook = new Book(bookIsbn, "Title", "Author", Year.of(2000), 12.90);
		entityManager.persist(expectedBook);
		
		Optional<Book> actualBook = bookRepository.findByIsbn(bookIsbn);
		
		assertThat(actualBook).isPresent();
		assertThat(actualBook.get().getIsbn()).isEqualTo(expectedBook.getIsbn());
	}
	
}