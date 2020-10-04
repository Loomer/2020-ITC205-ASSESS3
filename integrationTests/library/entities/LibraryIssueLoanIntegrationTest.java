package library.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

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

    @AfterAll
    static void tearDownAfterClass() throws Exception {
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

    @AfterEach
    void tearDown() throws Exception {
    }

        @Test
    void test() {
        
        // Arrange
        ILoan expectedLoan = new Loan(book, patron);
        
        // Act
        ILoan actualLoan = library.issueLoan(book, patron);
                
        // Asserts
        assertEquals(expectedLoan, actualLoan);
        
    }

}
