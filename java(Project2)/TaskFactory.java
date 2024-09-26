import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class TaskFactory {
    public static Task createTask(String description, String startTime, String endTime, String priority) throws DateTimeParseException {
        LocalTime start = LocalTime.parse(startTime);
        LocalTime end = LocalTime.parse(endTime);
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("End time should be after start time");
        }
        return new Task(description, start, end, priority);
    }
}
