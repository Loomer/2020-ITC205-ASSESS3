package library.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

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
    void checkOverDue_currentDateBeforeDueDate_False() {

        // Arrange
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
        loan.dueDate = new Date(dueDateMilliSec);
        Date currentDate = new Date(dueDateMilliSec - 100);
        
        // Act
        boolean bool = loan.checkOverDue(currentDate);
        
        // Asserts
        assertFalse(bool);
        
    }

}
