package runners;


import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.ReportHelper;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestRunner {


    @Test
    public void testParallel() {
        System.out.println("Started execution......");
        Results results = Runner.path("classpath:Features").tags("@evnChange").outputCucumberJson(true).parallel(5);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());

    }

    @BeforeAll
    public static void setPrerequesites() {

        System.setProperty("karate.env", System.getProperty("env"));

    }
    @AfterAll
    public static void tearDown() {
        ReportHelper.createCucumberReport();
    }


}