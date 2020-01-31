package enumtask.main;

import enumtask.model.Month;
import enumtask.service.MonthService;

public class Main {
    public static void main(String[] args) {

        MonthService monthService = new MonthService();

        System.out.println(monthService.isHoliday(Month.APRIL, 1));
        System.out.println(monthService.isHoliday(Month.MARCH, 21));
        System.out.println(monthService.isHoliday(Month.MARCH, 8));
        System.out.println(monthService.getNumberOfHolidaysInMonth(Month.MAY));
        System.out.println(Month.getNumberOfDays(Month.JUNE));
        MonthService.printHolidaysOfMonth(Month.APRIL);

        System.out.println("Traversed names of months:");
        System.out.println(monthService.traverseAndPrintMonthNames(Month.January));
        System.out.println(monthService.traverseAndPrintMonthNames(Month.FEBRUARY));
        System.out.println(monthService.traverseAndPrintMonthNames(Month.MARCH));
        System.out.println(monthService.traverseAndPrintMonthNames(Month.APRIL));
        System.out.println(monthService.traverseAndPrintMonthNames(Month.MAY));
    }
}
