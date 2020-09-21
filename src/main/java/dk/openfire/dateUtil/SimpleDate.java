package dk.openfire.dateUtil;

public class SimpleDate {

    private static int EPOC = 1970;


    /**
     *
     * @param year
     * @param month index starts at 1
     * @param day index starts at 1
     */
    public SimpleDate(int year, int month, int day) {
        if(!validateDate(year, month, day)) {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    public static boolean validateDate(final int year, final int month, final int day) {
        // Year 0 does not exist
        if(year == 0) {
            return false;
        }

        // Month must be between 1 and 12
        if(month < 1 || month > 12) {
            return false;
        }

        // Day must have a positive value
        if(day < 1) {
            return false;
        }

        // Depending on month day of the length of of the month
        Month m = Month.valueOf(month);
        if(isLeapYear(year) && Month.FEB.equals(m)) {
            if(day > 29) {
                return false;
            }
        } else {
            if(day > m.getDays()) {
                return false;
            }
        }

        return true;
    }

    public int findDifference(SimpleDate other) {
        return 0;
    }

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
