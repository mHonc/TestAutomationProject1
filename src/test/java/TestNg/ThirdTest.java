package TestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ThirdTest {

    @Test
    public void firstTest(){
        System.out.println("First");
    }

    @Test(dependsOnMethods = {"firstTest"})
    public void secondTest(){
        System.out.println("Second");
    }

    @Test(dependsOnMethods = {"secondTest"})
    public void thirdTest(){
        System.out.println("Third");
    }

    @Test(dataProvider = "data")
    public void dpTest(String val){
        System.out.println(val);
    }

    @DataProvider(name = "data")
    public Object[][] dataProvider(){
        return new Object[][] {{"First"},{"Second"},{"Third"}};
    }
}
