import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String inputFileName = "InputData.txt";
        String outputFileName = "MyData.txt";
        int rewrittenDates = convertDate(inputFileName, outputFileName);
        System.out.println("Number of rewritten dates: " + rewrittenDates);
    }

    static int convertDate(String inputFileName, String outputFileName) {
        int rewrittenDates = 0;
        Path pathInput = Path.of(inputFileName);
        Path pathOutput = Path.of(outputFileName);

        try {
            List<String> allLines = Files.readAllLines(pathInput);
            String[] regex = { "\\d{2}/\\d{2}/\\d{4} \\w+", "\\d{2}/\\d{1}/\\d{4} \\w+", "\\d{4}-\\d{2}-\\d{2} \\w+", "\\w+ \\d{2}.\\d{2}.\\d{4}" };
            String[] pattern = { "(\\d{2})/(\\d{2})/(}\\d{4) (\\w+)", "(\\d{2})/(\\d{1})/(\\d{4}) (\\w+)", "(\\d{4})-(\\d{2})-(\\d{2}) (\\w+)", "(\\w+) (\\d{2}).(\\d{2}).(\\d{4})" };
            for (String line : allLines) {
                for (int i = 0; i < regex.length; i++) {
                    if (line.matches(regex[i]))
                    {
                        System.out.println(line+"   "+i);
                        MyData mydata = MyData.parseDate(line, pattern[i], i);
                        System.out.println(mydata.formatAsString());
                        if (mydata != null) {
                            Files.writeString(pathOutput, mydata.formatAsString() + System.lineSeparator(), StandardOpenOption.APPEND);
                            rewrittenDates += 1;
                        }
                        break;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return rewrittenDates;
    }
}
