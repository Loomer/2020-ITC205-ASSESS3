package library.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import library.entities.IBook.BookState;
import library.entities.ILoan.LoanState;
import library.entities.IPatron.PatronState;
import library.entities.helpers.*;

class LibraryIssueLoanIntegrationTest {
    
    Library library;
    
    private Map<Integer, IBook> catalog;
    private Map<Integer, IPatron> patrons;
    private Map<Integer, ILoan> loans;
    private Map<Integer, ILoan> currentLoans;
    private Map<Integer, IBook> damagedBooks;
    
    static IBookHelper bookHelper;
    static IPatronHelper patronHelper;
    static ILoanHelper loanHelper;
    
    Patron patron;
    Loan loan;
    Book book;
    
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        
        bookHelper = new BookHelper();
        patronHelper = new PatronHelper();
        loanHelper = new LoanHelper();
    }

    @BeforeEach
    void setUp() throws Exception {
        
        patron = new Patron("Smith", "Jane", "jsmith@phaykmail.com", 1L, 1);
        book = new Book("John Doe", "A Book Vol.1", "callNum1", 1);
                
        catalog = new HashMap<>();
        catalog.put(1, book);

        patrons = new HashMap<>();
        patrons.put(1, patron);
        
        loans = new HashMap<>();
        currentLoans = new HashMap<>();
        damagedBooks = new HashMap<>();

        library = new Library(bookHelper, patronHelper, loanHelper);
        library.catalog = catalog;
        library.patrons = patrons;
        library.loans = loans;
        library.currentLoans = currentLoans;
        library.damagedBooks = damagedBooks;
    }

    @Test
    void issueLoanIntegration_HappyDay() {
        
        // Arrange
        book.state = BookState.AVAILABLE;
        patron.state = PatronState.CAN_BORROW;
             
        // Act
        ILoan loan = library.issueLoan(book, patron);
        
                        
        // Asserts
        assertEquals(book, loan.getBook());
        assertEquals(patron, loan.getPatron());
        assertTrue(library.currentLoans.size() == 0);
        assertTrue(library.loans.size() == 0);
        
        
    }

    @Test
    void issueLoanIntegration_PatronRestricted_ExceptionThrown() {
        
        // Arrange
        book.state = BookState.AVAILABLE;
        patron.state = PatronState.RESTRICTED;
             
        // Act
        Executable e = () -> library.issueLoan(book, patron);
                
        // Asserts
        assertThrows(RuntimeException.class, e);
        assertTrue(library.currentLoans.size() == 0);
        assertTrue(library.loans.size() == 0);
        
    }

    @Test
    void issueLoanIntegration_BookDamaged_ExceptionThrown() {
        
        // Arrange
        book.state = BookState.DAMAGED;
        patron.state = PatronState.RESTRICTED;
             
        // Act
        Executable e = () -> library.issueLoan(book, patron);
                
        // Asserts
        assertThrows(RuntimeException.class, e);
        assertTrue(library.currentLoans.size() == 0);
        assertTrue(library.loans.size() == 0);
        
    }
}
