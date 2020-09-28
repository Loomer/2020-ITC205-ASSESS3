package library.entities;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import library.entities.ILibrary;
import library.entities.helpers.IBookHelper;
import library.entities.helpers.ILoanHelper;
import library.entities.helpers.IPatronHelper;

@ExtendWith(MockitoExtension.class)
class LibraryMockTest {
    
    @Mock IBookHelper mockBookHelper;
    @Mock IPatronHelper mockPatronHelper;
    @Mock ILoanHelper mockLoanHelper;
    
    @Mock IPatron mockPatron;
    @Mock IBook mockBook;
    @Mock ILoan mockLoan;
    
    @InjectMocks
    Library library;
    
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testPatronCanBorrowNormalFlow() {
        
        // arrange
        int numOfLoans = ILibrary.LOAN_LIMIT - 1;
        double finesOwed = ILibrary.MAX_FINES_OWED - 1;
        boolean hasODLoans = false;
        
        when(mockPatron.getNumberOfCurrentLoans()).thenReturn(numOfLoans);
        when(mockPatron.getFinesPayable()).thenReturn(finesOwed);
        when(mockPatron.hasOverDueLoans()).thenReturn(hasODLoans);
                
        // act
        boolean canBorrow = library.patronCanBorrow(mockPatron);
        
        // assert
        assertTrue(canBorrow);
    }
    
    
    @Test
    void testPatronCanBorrowWhenLoanIsOverDue() {
        
        // arrange
        int numOfLoans = ILibrary.LOAN_LIMIT - 1;
        double finesOwed = ILibrary.MAX_FINES_OWED - 1;
        boolean hasODLoans = true;
        
        when(mockPatron.getNumberOfCurrentLoans()).thenReturn(numOfLoans);
        when(mockPatron.getFinesPayable()).thenReturn(finesOwed);
        when(mockPatron.hasOverDueLoans()).thenReturn(hasODLoans);
                
        // act
        boolean canBorrow = library.patronCanBorrow(mockPatron);
        
        // assert
        assertFalse(canBorrow);
        assertTrue(3 > ILibrary.LOAN_LIMIT);
    }
    
    @Test
    void testPatronCanBorrowWhenLoanLimitReached() {
        
        // arrange
        int numOfLoans = ILibrary.LOAN_LIMIT + 1;
        double finesOwed = ILibrary.MAX_FINES_OWED - 1;
        boolean hasODLoans = false;
        
        when(mockPatron.getNumberOfCurrentLoans()).thenReturn(numOfLoans);
        when(mockPatron.getFinesPayable()).thenReturn(finesOwed);
        when(mockPatron.hasOverDueLoans()).thenReturn(hasODLoans);
                
        // act
        boolean canBorrow = library.patronCanBorrow(mockPatron);
        
        // assert
        assertFalse(canBorrow);
        
    }
    
    @Test
    void testPatronCanBorrowWhenMaxFinesOwed() {
        
        // arrange
        int numOfLoans = ILibrary.LOAN_LIMIT - 1;
        double finesOwed = ILibrary.MAX_FINES_OWED + 1;
        boolean hasODLoans = false;
        
        
        when(mockPatron.getNumberOfCurrentLoans()).thenReturn(numOfLoans);
        when(mockPatron.getFinesPayable()).thenReturn(finesOwed);
        when(mockPatron.hasOverDueLoans()).thenReturn(hasODLoans);
                
        // act
        boolean canBorrow = library.patronCanBorrow(mockPatron);
        
        // assert
        assertFalse(canBorrow);
    }
    
    @Test
    void testCommitLoan() {
    
        //Arrange
        int bookId = 1;
        when(mockLoan.getBook()).thenReturn(mockBook);
        when(mockBook.getId()).thenReturn(bookId);
        when(mockLoan.getPatron()).thenReturn(mockPatron);
        
        //Act
        library.commitLoan(mockLoan);
           
        //Asserts
        verify(mockLoan).commit(anyInt(), any());
        ILoan loan = library.getCurrentLoanByBookId(bookId);
        assertEquals(loan, mockLoan);
          
        }
    }