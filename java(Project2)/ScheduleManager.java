import java.util.*;
import java.util.stream.Collectors;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;
    private List<ScheduleObserver> observers;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addTask(Task task) {
        if (isConflict(task)) {
            notifyObservers(task);
            System.out.println("Error: Task conflicts with an existing task.");
        } else {
            tasks.add(task);
            System.out.println("Task added successfully.");
        }
    }

    public void removeTask(String description) {
        Task taskToRemove = tasks.stream()
                .filter(task -> task.getDescription().equals(description))
                .findFirst()
                .orElse(null);

        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            List<Task> sortedTasks = tasks.stream()
                    .sorted(Comparator.comparing(Task::getStartTime))
                    .collect(Collectors.toList());
            sortedTasks.forEach(System.out::println);
        }
    }

    private boolean isConflict(Task newTask) {
        for (Task task : tasks) {
            if (!(newTask.getEndTime().isBefore(task.getStartTime()) || newTask.getStartTime().isAfter(task.getEndTime()))) {
                return true;
            }
        }
        return false;
    }

    public void addObserver(ScheduleObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(Task conflictingTask) {
        for (ScheduleObserver observer : observers) {
            observer.update(conflictingTask);
        }
    }
}
