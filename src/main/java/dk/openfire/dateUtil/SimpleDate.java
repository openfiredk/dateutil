package dk.openfire.dateUtil;

public class SimpleDate {




    public static boolean isLeapYear(int year) {
        /*
         * From https://en.wikipedia.org/wiki/Leap_year#Algorithm:
         * if (year is not divisible by 4) then (it is a common year)
         * else if (year is not divisible by 100) then (it is a leap year)
         * else if (year is not divisible by 400) then (it is a common year)
         * else (it is a leap year)
         */

        if(year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }
}
