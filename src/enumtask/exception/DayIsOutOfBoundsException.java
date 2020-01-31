package enumtask.exception;

public class DayIsOutOfBoundsException extends RuntimeException {
    @Override
    public String toString() {
        return "There is no such day in the month";
    }
}
