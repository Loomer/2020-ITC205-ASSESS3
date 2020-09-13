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

import library.entities.helpers.IBookHelper;
import library.entities.helpers.ILoanHelper;
import library.entities.helpers.IPatronHelper;

@ExtendWith(MockitoExtension.class)
class LibraryMockTest {
    
    @Mock IBookHelper mockBookHelper;
    @Mock IPatronHelper mockPatronHelper;
    @Mock ILoanHelper mockLoanHelper;
    
    @Mock IPatron mockPatron;
    
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
        //patron =
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testLibraryAllParamsOK() {
        
        //arrange
        String ln = "Smith";
        String fn = "John";
        String email = "jsmith@phaykmail.com";
        long phNum = 1234567890;
        int id = 1;
        
        when(mockPatronHelper.makePatron(ln, fn, email, phNum, id)).thenReturn(mockPatron);
        
        //act
        IPatron patron = library.addPatron(ln, fn, email, phNum);
        
        // assert
        assertNotNull(patron);
        List<IPatron> plist = library.getPatronList();
        assertTrue(plist.size() == 1);
    }

}
