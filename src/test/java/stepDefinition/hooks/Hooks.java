package stepDefinition.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp(){
        System.out.println("before");
    }

    @After
    public void tearDown(){
        System.out.println("after");
    }
}
