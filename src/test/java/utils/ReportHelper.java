package utils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.reducers.ReducingMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReportHelper {


    public static void createCucumberReport() {
        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<>();
        String projectName = "API Testing";
        try {
            jsonFiles.addAll(Files.walk(Paths.get("./target")).filter(e -> e.getFileName().toString().endsWith("json")).map(f -> f.toAbsolutePath().toString()).toList());
        } catch (Exception ignoreException) {
        }


        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
        configuration.addReducingMethod(ReducingMethod.MERGE_FEATURES_BY_ID);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
    }

}
