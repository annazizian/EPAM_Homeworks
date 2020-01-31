package enumtask.exception;

public class NoSuchMonthException extends RuntimeException {
    @Override
    public String toString() {
        return "There is no such month";
    }
}
