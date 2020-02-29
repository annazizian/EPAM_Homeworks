package enumtask.model;

import enumtask.exception.NoSuchMonthException;

import java.util.Arrays;

public enum Month {
    JANUARY(31,  1, 6, 28),
    FEBRUARY(29, 14, 21, 23, 28),
    MARCH(31, 8),
    APRIL(30, 1, 7, 13, 24),
    MAY(31, 1, 8, 9, 15, 16, 28),
    JUNE(30, 1, 14),
    JULY(31, 5),
    AUGUST(31),
    SEPTEMBER(30, 1, 21),
    OCTOBER(31, 5),
    NOVEMBER(30, 10),
    DECEMBER(31, 7, 9);

    private int numberOfDays;
    private int[] holidaysInMonth = {};

    public static int getNumberOfDays(Month month) throws NoSuchMonthException {
        if (month == null) {
            throw new NoSuchMonthException("There is no such month");
        }
        return month.numberOfDays;
    }

    public int[] getHolidaysInMonth(Month month) throws NoSuchMonthException {
        if (month == null) {
            throw new NoSuchMonthException("There is no such month");
        }
        return month.holidaysInMonth;
    }

    @Override
    public String toString() {
        return this.name() + " -> " +
                "numberOfDays = " + numberOfDays +
                ", holidaysInMonth = " + Arrays.toString(holidaysInMonth);
    }

    Month(int numberOfDays, int... holidaysInMonth) {
        this.numberOfDays = numberOfDays;
        if (holidaysInMonth != null) {
            this.holidaysInMonth = holidaysInMonth;
        }
    }
}
