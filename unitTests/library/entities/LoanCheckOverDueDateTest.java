package library.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;

import library.entities.ILoan.LoanState;

class LoanCheckOverDueDateTest {

    @Mock IBook mockBook;
    @Mock IPatron mockPatron;
    
    Loan loan;
    long dueDateMilliSec = 1532516399;
    
    @BeforeEach
    void setUp() throws Exception {
        loan = new Loan(mockBook, mockPatron);
    }

    @Test
    void checkOverDue_LoanStateNull_False() {

        // Arrange
        loan.state = null; 
        loan.dueDate = new Date(dueDateMilliSec);
        Date currentDate = new Date(dueDateMilliSec - 100);
        
        // Act
        boolean bool = loan.checkOverDue(currentDate);
        
        // Asserts
        assertFalse(bool);
        
    }

    @Test
    void checkOverDue_currentDateBeforeDueDate_False() {

        // Arrange
        loan.state = LoanState.CURRENT; 
        loan.dueDate = new Date(dueDateMilliSec);
        Date currentDate = new Date(dueDateMilliSec - 100);
        
        // Act
        boolean bool = loan.checkOverDue(currentDate);
        
        // Asserts
        assertFalse(bool);
        
    }


    @Test
    void checkOverDue_currentDateAfterDueDate_True() {

        // Arrange
        loan.dueDate = new Date(dueDateMilliSec);
        Date currentDate = new Date(dueDateMilliSec + 100);
        
        // Act
        boolean bool = loan.checkOverDue(currentDate);
        
        // Asserts
        assertTrue(bool);
        
    }

    @Test
    void checkOverDue_currentDateEqualsDueDate_False() {

        // Arrange
        loan.dueDate = new Date(dueDateMilliSec);
        Date currentDate = new Date(dueDateMilliSec);
        
        // Act
        boolean bool = loan.checkOverDue(currentDate);
        
        // Asserts
        assertFalse(bool);
        
    }

    @Test
    void checkOverDue_DueDateIsNull_ExceptionThrown() {

        // Arrange
        loan.dueDate = null;
        Date currentDate = new Date(dueDateMilliSec);
        
        // Act
        Executable e = () -> loan.checkOverDue(currentDate);
        
        // Asserts
        assertThrows(RuntimeException.class, e);
        
    }
    
    @Test
    void checkOverDue_CurrentDateIsNull_ExceptionThrown() {

        // Arrange
        loan.dueDate = new Date(dueDateMilliSec);
        Date currentDate = null;
        
        // Act
        Executable e = () -> loan.checkOverDue(currentDate);
        
        // Asserts
        assertThrows(RuntimeException.class, e);
        
    }
    
    @Test
    void checkOverDue_LoanStateOverDues_False() {

        // Arrange
        loan.state = LoanState.OVER_DUE;
        loan.dueDate = new Date(dueDateMilliSec);
        Date currentDate = new Date(dueDateMilliSec);
        
        // Act
        boolean bool = loan.checkOverDue(currentDate);
        
        // Asserts
        assertFalse(bool);
        
    }
}
