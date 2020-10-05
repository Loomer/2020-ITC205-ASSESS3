package library.borrowbook;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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

class BorrowBookControlCommitLoansTest {
    
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
