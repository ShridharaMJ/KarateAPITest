package runners;


import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.ReportHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestRunner {


    @Test
    public void testParallel() {
        System.out.println("Started execution......");
        Results results = Runner.path("classpath:Features").tags("@V2Posts").outputCucumberJson(true).parallel(10);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());

    }

    @BeforeAll
    public static void setPrerequesites() {
        System.setProperty("env","STAGE");
        System.setProperty("karate.env", System.getProperty("env"));

    }

    @AfterAll
    public static void tearDown() {
        ReportHelper.createCucumberReport();
    }


    public static void main(String[] args) throws IOException {

        List<String> json = Files.walk(Paths.get("./target")).filter(e -> e.getFileName().toString().endsWith("json")).map(f->f.toAbsolutePath().toString()).toList();

    }
    }






