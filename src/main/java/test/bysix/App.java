package test.bysix;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
    public static void main( String[] args ) {

        if (args.length == 2) {
            try {

                // trigger exercise 1
                if (args[0].equals("ex1")) {
                    ExerciseOne.printNumbers(Integer.parseInt(args[1]));
                }

                // trigger exercise 2
                if (args[0].equals("ex2")) {
                    List<ExerciseTwo.Country> countries = parseJson(args[1]);
                    ExerciseTwo.run(countries);
                }

                System.exit(0);
            } catch (Exception e) {
                showUsage();
                return;
            }
        }
        showUsage();
    }

    private static List<ExerciseTwo.Country> parseJson(String arg) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<ExerciseTwo.Country>> typeReference = new TypeReference<List<ExerciseTwo.Country>>() {};
        List<ExerciseTwo.Country> countries = mapper.readValue(arg, typeReference);
        return countries;
    }


    private static void showUsage() {
        System.out.println("Usage: java -jar {path to jar} [ex1, ex2] {value}");
        System.out.println("For ex1, {value} must be a positive Integer");
        System.out.println("For ex2, {value} must be a String with a valid JSON with data");
        System.exit(-1);
    }
}



