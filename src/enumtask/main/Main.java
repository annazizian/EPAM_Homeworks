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
        monthService.traverseAndPrintMonthName(Month.JANUARY);
        monthService.traverseAndPrintMonthName(Month.FEBRUARY);
        monthService.traverseAndPrintMonthName(Month.MARCH);
        monthService.traverseAndPrintMonthName(Month.APRIL);
        monthService.traverseAndPrintMonthName(Month.MAY);

        System.out.println("\nAll months of the year:");
        monthService.printAllMonths();
    }
}
