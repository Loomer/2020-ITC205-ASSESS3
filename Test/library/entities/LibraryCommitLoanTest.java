package library.entities;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LibraryCommitLoanTest {

    @Mock IPatron mockPatron;
    @Mock IBook mockBook;
    @Spy ILoan mockLoan;
    
    @InjectMocks
    Library library;
    
    
    @Test
    void commitLoan_InvalidLoan_ExceptionThrown() {
                
        // Arrange
                
        // Act
        Executable e = () -> library.commitLoan(null);
           
        // Asserts
        assertThrows(RuntimeException.class, e);
          
        }

    @Test
    void commitLoan_VaildLoan_CallsCommitMethod() {
                
        // Arrange
        when(mockLoan.getBook()).thenReturn(mockBook);
        when(mockBook.getId()).thenReturn(1);
        when(mockLoan.getPatron()).thenReturn(mockPatron);
        
        // Act
        library.commitLoan(mockLoan);
           
        // Asserts
        verify(mockLoan).commit(anyInt(), any());
          
        }
    
    @Test
    void commitLoan_VaildLoan_LoanAddedToCurrentLoanList() {
    
        // Arrange
        
        when(mockLoan.getBook()).thenReturn(mockBook);
        when(mockBook.getId()).thenReturn(1);
        when(mockLoan.getPatron()).thenReturn(mockPatron);
        
        // Act
        library.commitLoan(mockLoan);
           
        // Asserts
        ILoan loan = library.getCurrentLoanByBookId(1);
        assertEquals(loan, mockLoan);
          
        }
    
    @Test
    void commitLoan_VaildLoan_LoanAddedToFullLoanList() {
    
        // Arrange
        when(mockLoan.getBook()).thenReturn(mockBook);
        when(mockBook.getId()).thenReturn(1);
        when(mockLoan.getPatron()).thenReturn(mockPatron);
        
        // Act
        library.commitLoan(mockLoan);
           
        // Asserts
        assertFalse(library.loans.isEmpty());
        assertEquals(library.loans.get(1), mockLoan);
          
        }
}
