package library.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import library.entities.IBook.BookState;
import library.entities.ILoan.LoanState;
import library.entities.IPatron.PatronState;


class LibraryCommitLoanIntegrationTest {

    Patron patron;
    Book book;
    Loan loan;
    
    @BeforeEach
    void setUp() throws Exception {
        
       patron = new Patron("Smith", "Jane", "jsmith@phaykmail.com", 1L, 1);
       book = new Book("John Doe", "A Book Vol.1", "callNum1", 1);
       }
    
    @Test
    void commitLoanIntegration_HappyDay() {
        
        // Arrange
        patron.state = PatronState.CAN_BORROW;
        book.state = BookState.AVAILABLE;
        Loan loan = new Loan(book, patron);
        loan.state = LoanState.PENDING;
                        
        // Act
        loan.commit(1, new Date(1532516399));
                
        // Asserts
        assertEquals(patron.loans.get(1), loan);
        assertEquals(BookState.ON_LOAN, book.state);
        assertEquals(LoanState.CURRENT, loan.state);
        
        
    }
          
    @Test
    void commitLoanIntegration_LoanStateOverdue_ExceptionThrown() {
        
        // Arrange
        patron.state = PatronState.CAN_BORROW;
        book.state = BookState.AVAILABLE;
        Loan loan = new Loan(book, patron);
        loan.state = LoanState.OVER_DUE;
                        
        // Act
        Executable e = () -> loan.commit(1, new Date(1532516399));
                
        // Asserts
        assertThrows(RuntimeException.class, e);
            
    }

    @Test
    void commitLoanIntegration_LoanStateCurrent_ExceptionThrown() {
        
        // Arrange
        patron.state = PatronState.CAN_BORROW;
        book.state = BookState.AVAILABLE;
        Loan loan = new Loan(book, patron);
        loan.state = LoanState.CURRENT;
                        
        // Act
        Executable e = () -> loan.commit(1, new Date(1532516399));
                
        // Asserts
        assertThrows(RuntimeException.class, e);
            
    }

    @Test
    void commitLoanIntegration_LoanStateDischarged_ExceptionThrown() {
        
        // Arrange
        patron.state = PatronState.CAN_BORROW;
        book.state = BookState.AVAILABLE;
        Loan loan = new Loan(book, patron);
        loan.state = LoanState.DISCHARGED;
                        
        // Act
        Executable e = () -> loan.commit(1, new Date(1532516399));
                
        // Asserts
        assertThrows(RuntimeException.class, e);
            
    }
    
    @Test
    void commitLoanIntegration_PatronStateRestricted_ExceptionThrown() {
        
        // Arrange
        patron.state = PatronState.RESTRICTED;
        book.state = BookState.AVAILABLE;
        Loan loan = new Loan(book, patron);
        loan.state = LoanState.PENDING;
                        
        // Act
        Executable e = () -> loan.commit(1, new Date(1532516399));
                
        // Asserts
        assertThrows(RuntimeException.class, e);
            
    }
        
    @Test
    void commitLoanIntegration_BookStateDamaged_ExceptionThrown() {
        
        // Arrange
        patron.state = PatronState.CAN_BORROW;
        book.state = BookState.DAMAGED;
        Loan loan = new Loan(book, patron);
        loan.state = LoanState.PENDING;
                        
        // Act
        Executable e = () -> loan.commit(1, new Date(1532516399));
                
        // Asserts
        assertThrows(RuntimeException.class, e);
            
    }
          
    @Test
    void commitLoanIntegration_BookStateOnLoan_ExceptionThrown() {
        
        // Arrange
        patron.state = PatronState.CAN_BORROW;
        book.state = BookState.ON_LOAN;
        Loan loan = new Loan(book, patron);
        loan.state = LoanState.PENDING;
                        
        // Act
        Executable e = () -> loan.commit(1, new Date(1532516399));
                
        // Asserts
            assertThrows(RuntimeException.class, e);
            
    }
    
    @Test
    void commitLoanIntegration_hasValidLoan_LoanAddedToMemberBorrowingRecord() {
    
        // Arrange
        patron = new Patron("Smith", "Jane", "jsmith@phaykmail.com", 1L, 1);
        patron.state = PatronState.CAN_BORROW;
        
        book = new Book("John Doe", "A Book Vol.1", "callNum1", 1);
        Loan loan = new Loan(book, patron);
                        
        // Act
        loan.commit(1, new Date(1532516399));
                
        // Asserts
        assertEquals(patron.loans.get(1), loan);
                          
        }
    
    @Test
    void commitLoanIntegration_hasValidLoan_BookStateIsOnLoan() {
        
        // Arrange
        patron = new Patron("Smith", "Jane", "jsmith@phaykmail.com", 1L, 1);
        patron.state = PatronState.CAN_BORROW;
        
        book = new Book("John Doe", "A Book Vol.1", "callNum1", 1);
        Loan loan = new Loan(book, patron);
                        
        // Act
        loan.commit(1, new Date(1532516399));
                
        // Asserts
        assertEquals(BookState.ON_LOAN, book.state);
    }
    
    @Test
    void commitLoanIntegration_hasValidLoan_LoanStateIsUpdatedToCurrent() {
        
        // Arrange
        patron = new Patron("Smith", "Jane", "jsmith@phaykmail.com", 1L, 1);
        patron.state = PatronState.CAN_BORROW;
        
        book = new Book("John Doe", "A Book Vol.1", "callNum1", 1);
        Loan loan = new Loan(book, patron);
                        
        // Act
        loan.commit(1, new Date(1532516399));
                
        // Asserts
        assertEquals(LoanState.CURRENT, loan.state);
    }
}
