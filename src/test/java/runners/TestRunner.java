package runners;


import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.BeforeAll;

public class TestRunner {


    @Karate.Test
    public Karate testParallel(){
        return Karate.run("classpath:Features")
                .outputCucumberJson(true)
                .tags("@Test1");

    }



    @BeforeAll
    public static void setPrerequesites(){

        System.setProperty("karate.env",System.getProperty("env"));



    }
}