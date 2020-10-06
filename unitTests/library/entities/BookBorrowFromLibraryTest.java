package library.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import library.entities.IBook.BookState;

class BookBorrowFromLibraryTest {

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }


    Book book = new Book("John Doe", "A Book Vol.1", "callNum1", 1);

    @Test
    void borrowFromLibrary_BookStateAvailable_BookIsOnLoan() {
        
        // Arrange
        book.state = BookState.AVAILABLE;
        
        // Act 
        book.borrowFromLibrary();
        
        // Asserts
        assertEquals(BookState.ON_LOAN, book.state);
        
    }

    @Test
    void borrowFromLibrary_BookStateNotAvailable_ExceptionThrown() {
        
        // Arrange
        book.state = BookState.DAMAGED;
        
        // Act 
        Executable e = () -> book.borrowFromLibrary();
        
        // Asserts
        assertThrows(RuntimeException.class, e);
        
        
    }

}
