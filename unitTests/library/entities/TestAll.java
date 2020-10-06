package library.entities;


import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;

@RunWith(JUnitPlatform.class)

//@SelectClasses({BorrowBookControl.class})
@SelectPackages({"library.entities", "library.borrowbook"})

class TestAll {}
