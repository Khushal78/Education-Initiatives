import java.util.Scanner;

public class AstronautDailyScheduleOrganizer {
    public static void main(String[] args) {
        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        scheduleManager.addObserver(new ConflictAlertObserver());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task\n2. Remove Task\n3. View Tasks\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter description:");
                    String description = scanner.nextLine();
                    System.out.println("Enter start time (HH:mm):");
                    String startTime = scanner.nextLine();
                    System.out.println("Enter end time (HH:mm):");
                    String endTime = scanner.nextLine();
                    System.out.println("Enter priority (High/Medium/Low):");
                    String priority = scanner.nextLine();

                    try {
                        Task task = TaskFactory.createTask(description, startTime, endTime, priority);
                        scheduleManager.addTask(task);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Enter task description to remove:");
                    String taskToRemove = scanner.nextLine();
                    scheduleManager.removeTask(taskToRemove);
                    break;

                case 3:
                    scheduleManager.viewTasks();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
