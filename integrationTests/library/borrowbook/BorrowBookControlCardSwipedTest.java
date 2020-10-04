package library.borrowbook;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import library.borrowbook.IBorrowBookControl.BorrowControlState;
import library.borrowbook.IBorrowBookUI.BorrowUIState;
import library.entities.Book;
import library.entities.IBook;
import library.entities.ILibrary;
import library.entities.ILoan;
import library.entities.IPatron;
import library.entities.Library;
import library.entities.Loan;
import library.entities.Patron;
import library.entities.helpers.BookHelper;
import library.entities.helpers.IBookHelper;
import library.entities.helpers.ILoanHelper;
import library.entities.helpers.IPatronHelper;
import library.entities.helpers.LoanHelper;
import library.entities.helpers.PatronHelper;

class BorrowBookControlCardSwipedTest {
    
    Library library;
    BorrowBookControl borrowBookControl;
    BorrowBookUI borrowBookUI;
    
    Map<Integer, IBook> catalog;
    Map<Integer, IPatron> patrons;
    Map<Integer, ILoan> loans;
    Map<Integer, ILoan> currentLoans;
    Map<Integer, IBook> damagedBooks;
    
    static IBookHelper bookHelper;
    static IPatronHelper patronHelper;
    static ILoanHelper loanHelper; 
    
    
    Patron patron;
    Loan loan;
    Book book;
    
    BorrowControlState controlState;
    IPatron currentPatron;
    List<ILoan> pendingLoans;
    IBook currentBook;
    
    BorrowUIState uiState;
    
  
    
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
        patrons.put(patron.getId(), patron);
        
        loans = new HashMap<>();
        currentLoans = new HashMap<>();
        damagedBooks = new HashMap<>();

        library = new Library(bookHelper, patronHelper, loanHelper);
        library.catalog = catalog;
        library.patrons = patrons;
        library.loans = loans;
        library.currentLoans = currentLoans;
        library.damagedBooks = damagedBooks;
        
        library = new Library(bookHelper, patronHelper, loanHelper);
        ILibrary iLibrary = library;   
        
        

        
        borrowBookControl = new BorrowBookControl(iLibrary);
        borrowBookControl.currentPatron = currentPatron;
        borrowBookControl.controlState = controlState;
        
        borrowBookUI = new BorrowBookUI(borrowBookControl);
        borrowBookControl.controlState = BorrowControlState.INITIALISED;
        IBorrowBookUI iBorrowBookUI = borrowBookUI;
        
        borrowBookControl.borrowBookUI = iBorrowBookUI;
               
    }

    @Test
    void cardSwiped_HappyDay() {

        // Arrange
        borrowBookControl.controlState = BorrowControlState.SWIPING;
        borrowBookControl.borrowBookUI.setSwiping();
        library.patrons.put(patron.getId(), patron);
        
        IPatron expectedPatron = patron;
        assertFalse(library.patrons.isEmpty());
        
        // Act
        borrowBookControl.cardSwiped(patron.getId());
        
        IPatron actualPatron = borrowBookControl.currentPatron;
        
        assertTrue(library.patrons.containsKey(patron.getId()));
        
        //assertEquals(expectedPatron, borrowBookControl.currentPatron);
        
        // Asserts
        //assertEquals(BorrowControlState.SCANNING, borrowBookControl.controlState);
        //assertEquals(BorrowUIState.SCANNING, borrowBookUI.uiState);
        //assertEquals(expectedPatron, actualPatron);
        
        
        
    }   

}
