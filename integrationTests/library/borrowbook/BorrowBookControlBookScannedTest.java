package library.borrowbook;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import library.borrowbook.IBorrowBookControl.BorrowControlState;
import library.borrowbook.IBorrowBookUI.BorrowUIState;
import library.entities.Book;
import library.entities.IBook;
import library.entities.IBook.BookState;
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

@ExtendWith(MockitoExtension.class)
class BorrowBookControlBookScannedTest {
    
    Library library;
    Map<Integer, IBook> catalog;
    Map<Integer, IPatron> patrons;
    Map<Integer, ILoan> loans;
    Map<Integer, ILoan> currentLoans;
    Map<Integer, IBook> damagedBooks;
    static IBookHelper bookHelper;
    static IPatronHelper patronHelper;
    static ILoanHelper loanHelper;
    Book book; @Mock Book mockBook2;  @Mock Book mockBook3;  
    Patron patron;
    Loan Loan; @Mock ILoan mockLoan1; @Mock ILoan mockLoan2;  
    
    
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
        book = new Book("John Doe", "Some Book Vol.1", "callNum1", 1);
                
        catalog = new HashMap<>(); patrons = new HashMap<>(); loans = new HashMap<>();
        currentLoans = new HashMap<>(); damagedBooks = new HashMap<>();
        
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
        borrowBookControl.pendingLoans = pendingLoans;
        
        iBorrowBookControl = borrowBookControl;
        
        
        borrowBookUI = new BorrowBookUI(iBorrowBookControl);
        //iBorrowBookUI = borrowBookUI;
        //borrowBookControl.borrowBookUI = iBorrowBookUI;
        
        
        
    }

    @Test
    void bookScanned_BookAvailableUnderLoanLimit_MakesPendingLoanUIAndCtrlStateScanning() {

        // Arrange
        borrowBookControl.controlState = BorrowControlState.SCANNING;
        borrowBookUI.uiState = BorrowUIState.SCANNING;
        borrowBookControl.pendingLoans.clear();
        borrowBookControl.currentPatron = patron;
        library.catalog.put(book.getId(), book);
        
        IBook expectedBook = book;
        IPatron expectedPatron = patron;
        
               
        // Act
        borrowBookControl.bookScanned(book.getId());
        
        ILoan actualLoan = borrowBookControl.pendingLoans.get(0);
                
        // Asserts
        assertEquals(BorrowControlState.SCANNING, borrowBookControl.controlState);
        assertEquals(BorrowUIState.SCANNING, borrowBookUI.uiState);
        assertFalse(borrowBookControl.pendingLoans.isEmpty());
        assertEquals(expectedBook, actualLoan.getBook());
        assertEquals(expectedPatron, actualLoan.getPatron());
  
    }
    
    @Test
    void bookScanned_BookAvailableReachingLoanLimit_MakesPendingLoanUIAndCtrlStateFinalising() {

        // Arrange
        borrowBookControl.controlState = BorrowControlState.SCANNING;
        borrowBookUI.uiState = BorrowUIState.SCANNING;
        borrowBookControl.pendingLoans.add(mockLoan1);
        //borrowBookControl.pendingLoans.add(mockLoan2);
        borrowBookControl.currentPatron = patron;
        library.catalog.put(book.getId(), book);
        
        when(mockLoan1.getBook()).thenReturn(mockBook2);
        //when(mockLoan2.getBook()).thenReturn(mockBook3);
        
        
        IBook expectedBook = book;
        IPatron expectedPatron = patron;
        
        Integer id = 1;
               
        // Act
        borrowBookControl.bookScanned(id);
        
        ILoan actualLoan = borrowBookControl.pendingLoans.get(1);
                
        // Asserts
        assertEquals(BorrowControlState.FINALISING, borrowBookControl.controlState);
        assertEquals(BorrowUIState.FINALISING, borrowBookUI.uiState);
        assertEquals(ILibrary.LOAN_LIMIT, borrowBookControl.pendingLoans.size());
        assertFalse(borrowBookControl.pendingLoans.isEmpty());
        assertEquals(expectedBook, actualLoan.getBook());
        assertEquals(expectedPatron, actualLoan.getPatron());
        
  
    }
    
    @Test
    void bookScanned_BookIdNotFound_NoLoanUICtrlStateScanning() {

        // Arrange
        borrowBookControl.controlState = BorrowControlState.SCANNING;
        borrowBookUI.uiState = BorrowUIState.SCANNING;
        borrowBookControl.pendingLoans.clear();
        borrowBookControl.currentPatron = patron;
        library.catalog.put(book.getId(), book);
              
        // Act
        borrowBookControl.bookScanned(book.getId()+ 1);
              
        // Asserts
        assertEquals(BorrowControlState.SCANNING, borrowBookControl.controlState);
        assertEquals(BorrowUIState.SCANNING, borrowBookUI.uiState);
        assertTrue(borrowBookControl.pendingLoans.isEmpty());
        
   
    }
    
    @Test
    void bookScanned_BookNotAvailable_NoLoanUICtrlStateScanning() {

        // Arrange
        borrowBookControl.controlState = BorrowControlState.SCANNING;
        borrowBookUI.uiState = BorrowUIState.SCANNING;
        borrowBookControl.pendingLoans.clear();
        borrowBookControl.currentPatron = patron;
        book.state = BookState.ON_LOAN;
        library.catalog.put(book.getId(), book);
              
        // Act
        borrowBookControl.bookScanned(book.getId());
              
        // Asserts
        assertEquals(BorrowControlState.SCANNING, borrowBookControl.controlState);
        assertEquals(BorrowUIState.SCANNING, borrowBookUI.uiState);
        assertTrue(borrowBookControl.pendingLoans.isEmpty());
        
   
    }
    
    @Test
    void bookScanned_NoPatron_ExceptionThrown() {

        // Arrange
        borrowBookControl.controlState = BorrowControlState.SCANNING;
        borrowBookUI.uiState = BorrowUIState.SCANNING;
        borrowBookControl.pendingLoans.clear();
        library.catalog.put(book.getId(), book);
              
        // Act
        Executable e = () -> borrowBookControl.bookScanned(book.getId());
              
        // Asserts
        assertThrows(RuntimeException.class, e);
   
    }
}