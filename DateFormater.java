import java.util.ArrayList;
import java.util.List;

// divide into smaller parts, //seperate  object for writing and reading
public class DateFormater {
    static List<String> convertDate(List<String> allLines) {
        List<String> result = new ArrayList<>();
        String[] regex = { "\\d{2}/\\d{2}/\\d{4} \\w+", "\\d{2}/\\d{1}/\\d{4} \\w+", "\\d{4}-\\d{2}-\\d{2} \\w+",
                "\\w+ \\d{2}.\\d{2}.\\d{4}" };
        String[] pattern = { "(\\d{2})/(\\d{2})/(\\d{4}) (\\w+)", "(\\d{2})/(\\d{1})/(\\d{4}) (\\w+)",
                "(\\d{4})-(\\d{2})-(\\d{2}) (\\w+)", "(\\w+) (\\d{2}).(\\d{2}).(\\d{4})" };
        MyData lastWrittenDate = null;
        for (String line : allLines) {
            for (int i = 0; i < regex.length; i++) {
                if (line.matches(regex[i])) {
                    MyData mydata = MyData.parseDate(line, pattern[i]);
                    if (mydata != null && !mydata.isEqual(lastWrittenDate)) {
                        result.add(mydata.formatAsString() + System.lineSeparator());
                        lastWrittenDate = mydata;
                    }
                    break;
                }
            }
        }
        return result;
    }
}
