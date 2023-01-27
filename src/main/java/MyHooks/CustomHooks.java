package MyHooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CustomHooks {

    @Before
    public void setup(){
        System.out.println("Starting The TestCase...");
    }

    @After
    public void tearDown(){
        System.out.println("Ending The TestCase");
    }
}
