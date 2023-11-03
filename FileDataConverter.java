import java.io.IOException;
import java.util.List;

public class FileDataConverter { // jakis problem z main idk
    public static int fileDataConvert(String inputFileName, String outputFileName) throws IOException
    {
        List<String> resultArray = FileManager.readFileIntoArray(inputFileName);
        resultArray = DateFormater.convertDate(resultArray);
        FileManager.writeFileFromArray(outputFileName, resultArray);
        return resultArray.size();
    }
}
