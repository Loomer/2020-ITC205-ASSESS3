package library.entities;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import library.entities.ILibrary;


@ExtendWith(MockitoExtension.class)
class LibraryPatronCanBorrowTest {

    
    @Mock IPatron mockPatron;
    @Mock IBook mockBook;
    @Mock ILoan mockLoan;
    
    @InjectMocks
    Library library;
    

    @Test
    void patronCanBorrow_HappyDay_True() {
        
        // Arrange
        when(mockPatron.getNumberOfCurrentLoans()).thenReturn(ILibrary.LOAN_LIMIT - 1);
        when(mockPatron.getFinesPayable()).thenReturn(ILibrary.MAX_FINES_OWED - 1);
        when(mockPatron.hasOverDueLoans()).thenReturn(false);
        
        // Act
        boolean canBorrow = library.patronCanBorrow(mockPatron);
        
        // Assert
        assertTrue(canBorrow);
    }

    @Test
    void patronCanBorrow_HasOverdueLoans_False() {
        
        // Arrange
        when(mockPatron.getNumberOfCurrentLoans()).thenReturn(ILibrary.LOAN_LIMIT - 1);
        when(mockPatron.getFinesPayable()).thenReturn(ILibrary.MAX_FINES_OWED - 1);
        when(mockPatron.hasOverDueLoans()).thenReturn(true);
        
        // Act
        boolean canBorrow = library.patronCanBorrow(mockPatron);
        
        // Assert
        assertFalse(canBorrow);
    }
    
    @Test
    void patronCanBorrow_AtLoanLimit_False() {
        
        // Arrange
        when(mockPatron.getNumberOfCurrentLoans()).thenReturn(ILibrary.LOAN_LIMIT);
        when(mockPatron.getFinesPayable()).thenReturn(ILibrary.MAX_FINES_OWED - 1);
        when(mockPatron.hasOverDueLoans()).thenReturn(false);
        
        // Act
        boolean canBorrow = library.patronCanBorrow(mockPatron);
        
        // Assert
        assertFalse(canBorrow);
    }
    
    @Test
    void patronCanBorrow_ExceedsLoanLimit_False() {
        
        // Arrange
        Mockito.lenient().when(mockPatron.getNumberOfCurrentLoans()).thenReturn(ILibrary.LOAN_LIMIT + 1);
        Mockito.lenient().when(mockPatron.getFinesPayable()).thenReturn(ILibrary.MAX_FINES_OWED - 1);
        Mockito.lenient().when(mockPatron.hasOverDueLoans()).thenReturn(false);
        
        // Act
        boolean canBorrow = library.patronCanBorrow(mockPatron);
        
        // Assert
        assertFalse(canBorrow);
    }
    
    @Test
    void patronCanBorrow_AtMaxFineThreshold_True() {
        
        // Arrange
        Mockito.lenient().when(mockPatron.getNumberOfCurrentLoans()).thenReturn(ILibrary.LOAN_LIMIT - 1);
        Mockito.lenient().when(mockPatron.getFinesPayable()).thenReturn(ILibrary.MAX_FINES_OWED);
        Mockito.lenient().when(mockPatron.hasOverDueLoans()).thenReturn(false);
        
        // Act
        boolean canBorrow = library.patronCanBorrow(mockPatron);
        
        // Assert
        assertTrue(canBorrow);
    }
    
    @Test
    void patronCanBorrow_ExceedsMaxFineThreshold_False() {
        
        // Arrange
        Mockito.lenient().when(mockPatron.getNumberOfCurrentLoans()).thenReturn(ILibrary.LOAN_LIMIT - 1);
        Mockito.lenient().when(mockPatron.getFinesPayable()).thenReturn(ILibrary.MAX_FINES_OWED);
        Mockito.lenient().when(mockPatron.hasOverDueLoans()).thenReturn(false);
        
        // Act
        boolean canBorrow = library.patronCanBorrow(mockPatron);
        
        // Assert
        assertFalse(canBorrow);
    }
}
