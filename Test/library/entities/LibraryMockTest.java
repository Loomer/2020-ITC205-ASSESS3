package library.entities;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import library.entities.ILibrary;
import library.entities.ILoan.LoanState;
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
    
    @Spy Map<Integer, ILoan> loans;
    
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
    void testPatronCanBorrowWhenHasLoanIsOverDue() {
        
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
    }
    
    @Test
    void testPatronCanBorrowWhenLoanLimitReached() {
        
        // arrange
        int numOfLoans = ILibrary.LOAN_LIMIT + 1;
        double finesOwed = ILibrary.MAX_FINES_OWED - 1;
        boolean hasODLoans = false;
        
        Mockito.lenient().when(mockPatron.getNumberOfCurrentLoans()).thenReturn(numOfLoans);
        Mockito.lenient().when(mockPatron.getFinesPayable()).thenReturn(finesOwed);
        Mockito.lenient().when(mockPatron.hasOverDueLoans()).thenReturn(hasODLoans);
                
        // act
        boolean canBorrow = library.patronCanBorrow(mockPatron);
        
        // assert
        assertFalse(canBorrow);
        
    }
    
    @Test
    void testPatronCanBorrowWhenMaxFinesOwedExceed() {
        
        // arrange
        int numOfLoans = ILibrary.LOAN_LIMIT - 1;
        double finesOwed = ILibrary.MAX_FINES_OWED + 1;
        boolean hasODLoans = false;
        
        
        Mockito.lenient().when(mockPatron.getNumberOfCurrentLoans()).thenReturn(numOfLoans);
        Mockito.lenient().when(mockPatron.getFinesPayable()).thenReturn(finesOwed);
        Mockito.lenient().when(mockPatron.hasOverDueLoans()).thenReturn(hasODLoans);
                
        // act
        boolean canBorrow = library.patronCanBorrow(mockPatron);
        
        // assert
        assertFalse(canBorrow);
    }
    
    @Test
    void testPatronCanBorrowWhenMaxFinesOwedEquals() {
        
        // arrange
        int numOfLoans = ILibrary.LOAN_LIMIT - 1;
        double finesOwed = ILibrary.MAX_FINES_OWED;
        boolean hasODLoans = false;
        
        
        Mockito.lenient().when(mockPatron.getNumberOfCurrentLoans()).thenReturn(numOfLoans);
        Mockito.lenient().when(mockPatron.getFinesPayable()).thenReturn(finesOwed);
        Mockito.lenient().when(mockPatron.hasOverDueLoans()).thenReturn(hasODLoans);
                
        // act
        boolean canBorrow = library.patronCanBorrow(mockPatron);
        
        // assert
        assertFalse(canBorrow);
    }
    
    
    // passed
    @Test
    void testCommitLoanIfLoanAddedToCurrentLoanList() {
    
        //Arrange
        int bookId = 1;
        when(mockLoan.getBook()).thenReturn(mockBook);
        when(mockBook.getId()).thenReturn(bookId);
        when(mockLoan.getPatron()).thenReturn(mockPatron);
        
        //Act
        library.commitLoan(mockLoan);
           
        //Asserts
        ILoan loan = library.getCurrentLoanByBookId(bookId);
        assertEquals(loan, mockLoan);
          
        }
    
    // failed
    @Test
    void testCommitLoanIfLoanAddedToMemberBorrowingRecord() {
    
        //Arrange
        int bookId = 1;
        when(mockLoan.getBook()).thenReturn(mockBook);
        when(mockBook.getId()).thenReturn(bookId);
        when(mockLoan.getPatron()).thenReturn(mockPatron);
        
        //Act
        library.commitLoan(mockLoan);
        
        //Asserts
        ILoan loan = loans.get(bookId);
        assertEquals(loan, mockLoan);
                  
        }
    
    // failed
    @Test
    void testCommitLoanIfBookStateIsOnLoan() {
    
        //Arrange
        int bookId = 1;
        when(mockLoan.getBook()).thenReturn(mockBook);
        when(mockBook.getId()).thenReturn(bookId);
        when(mockLoan.getPatron()).thenReturn(mockPatron);
        
        //Act
        library.commitLoan(mockLoan);
           
        //Asserts
        assertTrue(library.getCurrentLoanByBookId(bookId).getBook().isOnLoan());
                          
        }


    }