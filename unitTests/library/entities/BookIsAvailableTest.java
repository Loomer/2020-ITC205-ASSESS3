package library.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import library.entities.IBook.BookState;

class BookIsAvailableTest {

    Book book = new Book("John Doe", "A Book Vol.1", "callNum1", 1);

    @Test
    void isAvailable_BookStateAvailable_True() {
        
        // Arrange
        book.state = BookState.AVAILABLE;
        
        // Act // Asserts
        assertTrue(book.isAvailable());
        
    }

    @Test
    void isAvailable_BookStateNotAvailable_False() {
        
        // Arrange
        book.state = BookState.DAMAGED;
        
        // Act // Asserts
        assertFalse(book.isAvailable());
        
        
    }
}
