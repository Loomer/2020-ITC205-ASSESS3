package library.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import library.entities.IBook.BookState;
import library.entities.IPatron.PatronState;

class LoanCommitIntegrationTest {

    Patron patron;
    Book book;
    Loan loan;
    
    @BeforeEach
    void setUp() throws Exception {
        
       patron = new Patron("Smith", "Jane", "jsmith@phaykmail.com", 1L, 1);
       book = new Book("John Doe", "A Book Vol.1", "callNum1", 1);
       }
    
    @Test
    void commitIntegration_hasValidLoan_LoanAddedToMemberBorrowingRecord() {
    
        // Arrange
        patron.state = PatronState.CAN_BORROW;
        Loan loan = new Loan(book, patron);
                        
        // Act
        loan.commit(1, new Date(1532516399));
                
        // Asserts
        assertEquals(patron.loans.get(1), loan);
                          
        }

    @Test
    void commitIntegration_hasValidLoan_BookStateIsUpdatedToOnLoan() {
    
        // Arrange
        patron.state = PatronState.CAN_BORROW;
        Loan loan = new Loan(book, patron);
                        
        // Act
        loan.commit(1, new Date(1532516399));
                
        // Asserts
        assertEquals(BookState.ON_LOAN, book.state);
                          
        }
}
