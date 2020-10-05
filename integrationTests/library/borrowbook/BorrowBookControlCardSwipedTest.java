package library.borrowbook;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import library.borrowbook.IBorrowBookControl.BorrowControlState;
import library.borrowbook.IBorrowBookUI.BorrowUIState;
import library.entities.Book;
import library.entities.IBook;
import library.entities.ILibrary;
import library.entities.ILoan;
import library.entities.IPatron;
import library.entities.IPatron.PatronState;
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
    Map<Integer, IBook> catalog;
    Map<Integer, IPatron> patrons;
    Map<Integer, ILoan> loans;
    Map<Integer, ILoan> currentLoans;
    Map<Integer, IBook> damagedBooks;
    static IBookHelper bookHelper;
    static IPatronHelper patronHelper;
    static ILoanHelper loanHelper;
    Book book;
    Patron patron;
    Loan Loan;  
    
    
    BorrowBookControl borrowBookControl; IBorrowBookControl iBorrowBookControl;
    ILibrary iLibrary;
    IPatron currentPatron;
    BorrowControlState controlState;
    List<ILoan> pendingLoans;
    IBook currentBook;
    
    
    BorrowBookUI borrowBookUI; IBorrowBookUI iBorrowBookUI;
    // Scanner input;
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
        patrons = new HashMap<>();
        loans = new HashMap<>(); currentLoans = new HashMap<>(); damagedBooks = new HashMap<>();
        
        library = new Library(bookHelper, patronHelper, loanHelper);
        library.catalog = catalog;
        library.patrons = patrons;
        library.loans = loans;
        library.currentLoans = currentLoans;
        library.damagedBooks = damagedBooks;
        
        
        
        //iborrowBookUI
        iLibrary = library;
        //currentPatron;
        //controlState
        pendingLoans = new ArrayList<>();
        //currentBook
        
        borrowBookControl = new BorrowBookControl(iLibrary);
        //borrowBookControl.controlState = controlState.INITIALISED;
        
        iBorrowBookControl = borrowBookControl;
        
        
        borrowBookUI = new BorrowBookUI(iBorrowBookControl);
        //iBorrowBookUI = borrowBookUI;
        //borrowBookControl.borrowBookUI = iBorrowBookUI;
        
        
        
    }

    @Test
    void cardSwiped_HappyDay() {

        // Arrange
        borrowBookControl.controlState = BorrowControlState.SWIPING;
        borrowBookUI.uiState = BorrowUIState.SWIPING;
        library.patrons.put(patron.getId(), patron);
        
        IPatron expectedPatron = patron;
               
        // Act
        borrowBookControl.cardSwiped(patron.getId());
        
        IPatron actualPatron = borrowBookControl.currentPatron;
                
        // Asserts
        assertEquals(BorrowControlState.SCANNING, borrowBookControl.controlState);
        assertEquals(BorrowUIState.SCANNING, borrowBookUI.uiState);
        assertEquals(expectedPatron, actualPatron);
  
    }
    
    @Test
    void cardSwiped_UIIsNotInScanningState_ExceptionThrown() {

        // Arrange
        borrowBookControl.controlState = BorrowControlState.SWIPING;
        borrowBookUI.uiState = null;
        library.patrons.put(patron.getId(), patron);
        
        // Act
        Executable e = () -> borrowBookControl.cardSwiped(patron.getId());
        
        // Asserts
        assertThrows(RuntimeException.class, e);
        assertNull(borrowBookControl.currentPatron);
  
    }
    
    @Test
    void cardSwiped_ControlStateIsNotInScanningState_ExceptionThrown() {


        // Arrange
        borrowBookControl.controlState = null;
        borrowBookUI.uiState = BorrowUIState.SWIPING;
        library.patrons.put(patron.getId(), patron);
        
        // Act
        Executable e = () -> borrowBookControl.cardSwiped(patron.getId());
        
        // Asserts
        assertThrows(RuntimeException.class, e);
        assertNull(borrowBookControl.currentPatron);
  
    }    
    
    @Test
    void cardSwiped_PatronIdNotInteger_ExceptionThrown() {

        // Arrange
        borrowBookControl.controlState = BorrowControlState.SWIPING;
        borrowBookUI.uiState = BorrowUIState.SWIPING;
        library.patrons.put(patron.getId(), patron);
        
        Integer id = null;
               
        // Act
        Executable e = () -> borrowBookControl.cardSwiped(id);
        
        // Asserts
        assertThrows(RuntimeException.class, e);
        assertNull(borrowBookControl.currentPatron);
  
    }
    
    @Test
    void cardSwiped_PatronIdNotFound_UIAndCtrlStateSwiping() {

        // Arrange
        borrowBookControl.controlState = BorrowControlState.SWIPING;
        borrowBookUI.uiState = BorrowUIState.SWIPING;
        library.patrons.put(1, patron);
        
        Integer id = 2;
               
        // Act
        borrowBookControl.cardSwiped(id);
                
        // Asserts
        assertEquals(BorrowControlState.SWIPING, borrowBookControl.controlState);
        assertEquals(BorrowUIState.SWIPING, borrowBookUI.uiState);
        assertNull(borrowBookControl.currentPatron);
  
    }
    
    @Test
    void cardSwiped_PatronIsRestricted_UIAndCtrlStateRestricted() {

        // Arrange
        borrowBookControl.controlState = BorrowControlState.SWIPING;
        borrowBookUI.uiState = BorrowUIState.SWIPING;
        patron.finesPayable = ILibrary.MAX_FINES_OWED + 1;
        library.patrons.put(patron.getId(), patron);
        
        // Act
        borrowBookControl.cardSwiped(patron.getId());
                
        // Asserts
        assertTrue(!library.patrons.isEmpty());
        assertEquals(BorrowControlState.RESTRICTED, borrowBookControl.controlState);
        assertEquals(BorrowUIState.RESTRICTED, borrowBookUI.uiState);
        
  
    }
}
