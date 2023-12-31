import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyData {
    int day;
    int month;
    int year;
    String dayOfTheWeek;

    public MyData(int day, int month, int year, String dayOfTheWeek) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.dayOfTheWeek = dayOfTheWeek;
    }


    public static MyData parseDate(String input, String patternString) {
        int groupDay, groupMonth, groupYear, groupDayOfTheWeek;
        switch (patternString) {
            case "(\\d{2})/(\\d{2})/(\\d{4}) (\\w+)", "(\\d{2})/(\\d{1})/(\\d{4}) (\\w+)" -> {
                groupDay = 1;
                groupMonth = 2;
                groupYear = 3;
                groupDayOfTheWeek = 4;
            }
            case "(\\d{4})-(\\d{2})-(\\d{2}) (\\w+)" -> {
                groupDay = 3;
                groupMonth = 2;
                groupYear = 1;
                groupDayOfTheWeek = 4;
            }
            case "(\\w+) (\\d{2}).(\\d{2}).(\\d{4})" -> {
                groupDay = 2;
                groupMonth = 3;
                groupYear = 4;
                groupDayOfTheWeek = 1;
            }
            default -> {
                return null;
            }
        }
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return new MyData(
                    Integer.parseInt(matcher.group(groupDay)),
                    Integer.parseInt(matcher.group(groupMonth)),
                    Integer.parseInt(matcher.group(groupYear)),
                    matcher.group(groupDayOfTheWeek));
        } else {
            return null; // Handle the case where no match is found.
        }
    }

    public String formatAsString() {
        return String.format("day = %02d, month = %02d, year = %04d, weekday = %s", day, month, year, dayOfTheWeek);
    }

    public boolean isEqual(MyData secondData) {
        if (secondData == null) {
            return false;
        }
        if (day == secondData.day && month == secondData.month && year == secondData.year
                && dayOfTheWeek.equals(secondData.dayOfTheWeek)) {
            return true;
        }
        return false;
    }
}
