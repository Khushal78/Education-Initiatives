public interface ScheduleObserver {
    void update(Task conflictingTask);
}

public class ConflictAlertObserver implements ScheduleObserver {
    @Override
    public void update(Task conflictingTask) {
        System.out.println("Conflict Alert: Task '" + conflictingTask.getDescription() + "' conflicts with an existing task.");
    }
}
