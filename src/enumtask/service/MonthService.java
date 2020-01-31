package enumtask.service;

import enumtask.exception.DayIsOutOfBoundsException;
import enumtask.exception.NoSuchMonthException;
import enumtask.model.Month;

import java.util.Arrays;

public class MonthService {
    public boolean isHoliday(Month month, int day) {
        if (month == null) {
            throw new NoSuchMonthException();
        }
        if (day < 1 || day > month.getNumberOfDays(month)) {
            throw new DayIsOutOfBoundsException();
        }
        for (int i = 0; i < getNumberOfHolidaysInMonth(month); i++) {
            if (month.getHolidaysInMonth(month)[i] == day) {
                return true;
            }
        }
        return false;
    }

    public int getNumberOfHolidaysInMonth(Month month) {
        if (month == null) {
            throw new NoSuchMonthException();
        }
        return month.getHolidaysInMonth(month).length;
    }

    public static void printHolidaysOfMonth(Month month) {
        if (month == null) {
            throw new NoSuchMonthException();
        }
        System.out.println("Holidays of " + month.name().toLowerCase() + " are " +
                Arrays.toString(month.getHolidaysInMonth(month)) + "\n");
    }

    public String traverseAndPrintMonthNames(Month month) {
        if (month == null) {
            throw new NoSuchMonthException();
        }
        String myString = "";
        for (int i = month.name().length() - 1; i >= 0; i--) {
            myString += month.name().charAt(i);
        }
        return myString.toLowerCase();
    }
}
