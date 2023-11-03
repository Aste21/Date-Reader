import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileManager {
    public static List<String> readFileIntoArray(String inputFileName) throws IOException {
        Path pathInput = Path.of(inputFileName);
        List<String> allLines;
        allLines = Files.readAllLines(pathInput);
        return allLines;
    }

    public static void writeFileFromArray(String outputFileName, List<String> outputArray) throws IOException {
        Path pathOutput = Path.of(outputFileName);
        Files.writeString(pathOutput, "");
        for (String line : outputArray) {

            Files.writeString(pathOutput, line, StandardOpenOption.APPEND);

        }
    }
}

// try {
// allLines = Files.readAllLines(pathInput);
// } catch (IOException e) { // checked vs runtime
// throw new IOException(e); // e.printstacktrace / msg to user
// }