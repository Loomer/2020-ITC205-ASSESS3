package library.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import library.entities.ILoan.LoanState;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

class PatronHasOverDueLoansTest {

    
    @Mock IBook mockBook;
    @Mock IPatron mockPatron;
    
    
    @InjectMocks
    Patron patron;
    
    Loan loan1 = new Loan(mockBook, mockPatron);
    Loan loan2 = new Loan(mockBook, mockPatron);
    Loan loan3 = new Loan(mockBook, mockPatron);
    
    ILoan iLoan1 = loan1;
    ILoan iLoan2 = loan2;
    ILoan iLoan3 = loan3;
    

    @BeforeEach
    void setUp() throws Exception {
        patron = patron = new Patron("Smith", "Jane", "jsmith@phaykmail.com", 1L, 1);
        patron.loans = new HashMap<Integer, ILoan>();
    }


    @Test
    void hasOverDueLoans_AllLoansNotOverDue_False() {
        
        // Arrange
        loan1.state = LoanState.CURRENT;
        loan2.state = LoanState.CURRENT;
        loan3.state = LoanState.CURRENT;
        
        patron.loans.put(1, iLoan1);
        patron.loans.put(2, iLoan2);
        patron.loans.put(3, iLoan3);
                
        // Act
        boolean bool = patron.hasOverDueLoans();
        
        // Asserts
        assertFalse(bool);

    }
    
    @Test
    void hasOverDueLoans_AllLoansOverDue_True() {
        
        // Arrange
        loan1.state = LoanState.OVER_DUE;
        loan2.state = LoanState.OVER_DUE;
        loan3.state = LoanState.OVER_DUE;
        
        patron.loans.put(1, iLoan1);
        patron.loans.put(2, iLoan2);
        patron.loans.put(3, iLoan3);
                
        // Act
        boolean bool = patron.hasOverDueLoans();
        
        // Asserts
        assertTrue(bool);

    }
    
    @Test
    void hasOverDueLoans_OneLoanOverDue_True() {
        
        // Arrange
        loan1.state = LoanState.OVER_DUE;
        loan2.state = LoanState.OVER_DUE;
        loan3.state = LoanState.OVER_DUE;
        
        patron.loans.put(1, iLoan1);
        patron.loans.put(2, iLoan2);
        patron.loans.put(3, iLoan3);
                
        // Act
        boolean bool = patron.hasOverDueLoans();
        
        // Asserts
        assertTrue(bool);

    }


}
