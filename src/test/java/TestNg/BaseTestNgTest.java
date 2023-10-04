package TestNg;

import org.testng.annotations.*;

public class BaseTestNgTest {

    @BeforeTest
    public void beforeTest(){
        System.out.println("Dzialam przed testem");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Dzialam przed metoda");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Dzialam przed klasa");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Dzialam przed pakietem");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Dzialam za testem");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Dzialam za metoda");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Dzialam za klasa");
    }

    @AfterSuite
    public void AfterSuite(){
        System.out.println("Dzialam za pakietem");
    }
}
