import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Solution {
    /**
     * Returns the absolute number of days between date1 and date2.
     * Dates are in "YYYY-MM-DD" format and guaranteed valid between 1971 and 2100.
     */
    public int daysBetweenDates(String date1, String date2) {
        LocalDate d1 = LocalDate.parse(date1);
        LocalDate d2 = LocalDate.parse(date2);
        // ChronoUnit.DAYS.between returns a long; take absolute value and cast to int
        return (int) Math.abs(ChronoUnit.DAYS.between(d1, d2));
    }
}
