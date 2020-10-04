package library.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;

import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import library.entities.helpers.LoanHelper;

@ExtendWith(MockitoExtension.class)
class LibraryIssueLoanTest {
    
    
    @Mock LoanHelper mockLoanHelper;
    @Mock ILoan mockLoan;
    @Mock IPatron mockPatron;
    @Mock IBook mockBook;
    
    @InjectMocks
    Library library;
    
    @Test
    void issueLoan_NullBook_ExceptionThrown() {
        
        // Arrange
        mockBook = null;              
        
        // Act
        Executable e = () -> library.issueLoan(mockBook, mockPatron);
        
        // Asserts
        assertThrows(RuntimeException.class, e);
    }

    @Test
    void issueLoan_NullPatron_ExceptionThrown() {
        
        // Arrange
        mockPatron = null;  
        
        // Act
        Executable e = () -> library.issueLoan(mockBook, mockPatron);
        
        // Asserts
        assertThrows(RuntimeException.class, e);
    }
    
    @Test
    void issueLoan_RestrictedPatron_ExceptionThrown() {
        
        // Arrange
        when(mockPatron.hasOverDueLoans()).thenReturn(true); 
        
        // Act        
        Executable e = () -> library.issueLoan(mockBook, mockPatron);
        
        // Asserts
        assertThrows(RuntimeException.class, e);
    }
    
    @Test
    void issueLoan_DamagedBook_ExceptionThrown() {
        
        // Arrange
        when(mockBook.isDamaged()).thenReturn(true); 
        
        // Act        
        Executable e = () -> library.issueLoan(mockBook, mockPatron);
        
        // Asserts
        assertThrows(RuntimeException.class, e);
    }
    
    @Test
    void issueLoan_BookIsOnLoan_ExceptionThrown() {
        
        // Arrange
        when(mockBook.isAvailable()).thenReturn(true); 
        
        // Act        
        Executable e = () -> library.issueLoan(mockBook, mockPatron);
        
        // Asserts
        assertThrows(RuntimeException.class, e);
    }
}
