package library.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import library.entities.ILoan.LoanState;
import library.entities.IPatron.PatronState;

class PatronTakeOutLoanTest {

    
    @Mock IBook mockBook;
    @Mock IPatron mockPatron;
    
    
    @InjectMocks
    Patron patron;
    
    Loan loan = new Loan(mockBook, mockPatron);
     
    ILoan iLoan = loan;
    

    @BeforeEach
    void setUp() throws Exception {
        patron = patron = new Patron("Smith", "Jane", "jsmith@phaykmail.com", 1L, 1);
        patron.loans = new HashMap<Integer, ILoan>();
        loan.loanId = 1;
    }

    @Test
    void takeOutLoan_HappyDay_LoanAddedToRecord() {
        
        // Arrange
        assertTrue(patron.loans.isEmpty());
        patron.state = PatronState.CAN_BORROW;
        loan.state = LoanState.CURRENT;
        
        // Act
        patron.takeOutLoan(iLoan);
        
        // Asserts
        assertFalse(patron.loans.isEmpty());
        assertEquals(iLoan, patron.loans.get(1));
        
        
        
    }
    
    @Test
    void takeOutLoan_PatronCannotBorrow_ExceptionThrown() {
        
        // Arrange
        assertTrue(patron.loans.isEmpty());
        patron.state = PatronState.RESTRICTED;
        loan.state = LoanState.CURRENT;
        
        // Act
        Executable e = () -> patron.takeOutLoan(iLoan);
        
        // Asserts
        assertThrows(RuntimeException.class, e);
        
        
    }

    @Test
    void takeOutLoan_NullLoan_ExceptionThrown() {
        
        // Arrange
        assertTrue(patron.loans.isEmpty());
        patron.state = PatronState.CAN_BORROW;
        loan.state = LoanState.CURRENT;
        
        // Act
        Executable e = () -> patron.takeOutLoan(null);
        
        // Asserts
        assertThrows(RuntimeException.class, e);
        
        
    }
    
    @Test
    void takeOutLoan_LoanExistsInBorrowingRcord_ExceptionThrown() {
        
        // Arrange
        assertTrue(patron.loans.isEmpty());
        patron.state = PatronState.CAN_BORROW;
        loan.state = LoanState.CURRENT;
        
        
        // Act
        patron.takeOutLoan(iLoan);
        Executable e = () -> patron.takeOutLoan(iLoan);
        
        // Asserts
        assertThrows(RuntimeException.class, e);
        
        
    }
    
    @Test
    void takeOutLoan_LoanIsNotCurrent_ExceptionThrown() {
        
        // Arrange
        assertTrue(patron.loans.isEmpty());
        patron.state = PatronState.CAN_BORROW;
        loan.state = LoanState.PENDING;
        
        
        // Act
        Executable e = () -> patron.takeOutLoan(iLoan);
        
        // Asserts
        assertThrows(RuntimeException.class, e);
        
        
    }
}
