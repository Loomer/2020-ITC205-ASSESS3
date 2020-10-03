package library.entities;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import library.entities.IBook.BookState;
import library.entities.ILibrary;
import library.entities.IPatron.PatronState;
import library.entities.helpers.IBookHelper;
import library.entities.helpers.ILoanHelper;
import library.entities.helpers.IPatronHelper;

@ExtendWith(MockitoExtension.class)
class LibraryIntegTest2 {
    
    Patron patron;
    Book book;
    Loan loan;
    Library library;
    
    @BeforeEach
    void setUp() throws Exception {
        
       }

    @AfterEach
    void tearDown() throws Exception {
    }
    
        
    @Test
    void testCommitLoanIfLoanAddedToMemberBorrowingRecord() {
    
        //Arrange
        patron = new Patron("LN", "FN", "EM", 1L, 1);
        patron.state = PatronState.CAN_BORROW;
        
        book = new Book("au1", "ti1", "cno1", 1);
        assertTrue(book.state == BookState.AVAILABLE);
        
        Loan loan = new Loan(book,patron);
                
        //Act
        int loanId = 1;
        Date dueDate = new Date();
        dueDate.setTime(1532516399);
        Executable e = () -> loan.commit(loanId, dueDate);
        loan.commit(loanId, dueDate);
                
        //Asserts
        assertThrows(RuntimeException.class, e);
        assertFalse(patron.loans.isEmpty());
                          
        }
}