package library.entities;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import library.entities.ILoan.LoanState;;

@ExtendWith(MockitoExtension.class)
class LoanCommitTest {
    
    @Mock IBook mockBook;
    @Mock IPatron mockPatron;
    
    Loan loan;
  

    @Test
    void commit_LoanIdIsNull_ExceptionThrown() {
        
        // Arrange
        loan = new Loan(mockBook, mockPatron);
        loan.state = LoanState.OVER_DUE;
        
        // Act
        Executable e = () -> loan.commit(0, new Date(1532516399));
        
        // Asserts
        assertThrows(RuntimeException.class, e);
        
    }
    
    @Test
    void commit_BookIsNull_ExceptionThrown() {
        
        // Arrange
        loan = new Loan(null, mockPatron);
        loan.state = LoanState.PENDING;
        
        // Act
        Executable e = () -> loan.commit(0, new Date(1532516399));
        
        // Asserts
        assertThrows(RuntimeException.class, e);
        
    }
    
    @Test
    void commit_PatronIsNull_ExceptionThrown() {
        
        // Arrange
        loan = new Loan(mockBook, null);
        loan.state = LoanState.PENDING;
        
        // Act
        Executable e = () -> loan.commit(0, new Date(1532516399));
        
        // Asserts
        assertThrows(RuntimeException.class, e);
        
    }
    
    @Test
    void commit_LoanIsNotPending_ExceptionThrown() {
        
        // Arrange
        loan = new Loan(mockBook, mockPatron);
        loan.state = LoanState.OVER_DUE;
        
        // Act
        Executable e = () -> loan.commit(0, new Date(1532516399));
        
        // Asserts
        assertThrows(RuntimeException.class, e);
        
    }
    
    @Test
    void commit_LoanIsPending_UpdatedLoanStateToCurrent() {
        
        // Arrange
        loan = new Loan(mockBook, mockPatron);
        loan.state = LoanState.PENDING;
        
        // Act
        loan.commit(0, new Date(1532516399));
        
        // Asserts
        assertEquals(LoanState.CURRENT, loan.state);
        
    }
    
    @Test
    void commit_LoanIsPending_CallsTakeOutLoan() {
        
        // Arrange
        loan = new Loan(mockBook, mockPatron);
        loan.state = LoanState.PENDING;
        
        // Act
        loan.commit(0, new Date(1532516399));
        
        // Asserts
        verify(mockPatron).takeOutLoan(loan);
        
    }
    
    @Test
    void commit_LoanIsPending_CallsBorrowFromLibrary() {
        
        // Arrange
        loan = new Loan(mockBook, mockPatron);
        loan.state = LoanState.PENDING;
        
        // Act
        loan.commit(0, new Date(1532516399));
        
        // Asserts
        verify(mockBook).borrowFromLibrary();
        
    }
    
}