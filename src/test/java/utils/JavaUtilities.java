package utils;

import com.intuit.karate.Runner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaUtilities {

    public static Map<String, Object> getEnvVariables(String env) throws IOException {

        /*System.out.println("Changing env to "+ env);
        System.setProperty("karate.env",env);
      System.out.println( System.getProperty("karate.env"));
*/
        Map<String, String> arg = new HashMap<>();
        // List<String> list = Files.readAllLines(Path.of("karate-config.js"));
        String string = Files.readString(Path.of("karate-config.js"));
        int i = string.indexOf("(env=='" + env + "')");
        int i1 = string.indexOf("}", i);

        System.out.println(i);
        System.out.println(i1);

        String envVariables = string.substring(i, i1 + 1).replace("(env=='" + env + "')", "").replaceAll("\\{|}", "").replaceAll("config", "").trim();
        // System.out.println(envVariables);
        String[] split = envVariables.split(";");
        //  Arrays.stream(split).forEach(System.out::println);

        Map<String, Object> collect = Arrays.stream(split).collect(Collectors.toMap(k -> k.substring(1, k.indexOf("=")), j -> j.substring(j.indexOf("=") + 2, j.length() - 1)));


        // System.out.println(collect);

        return collect;

    }

    public static Object doJavaStuff(String env) throws IOException {

        Map<String, Object> envVariables = getEnvVariables(env);
        Map<String, Object> result = Runner.runFeature("classpath:Features/Testing2.feature", envVariables, false);
        return result.get("auth");



    }
    public void changeEnvironment(String env){
        System.setProperty("karate.env",env);
    }

}
