import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Task {
    private String description;
    private boolean isCompleted;

   
    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    // Getters and Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[X] " : "[ ] ") + description;
    }
}


class TaskService {
    private List<Task> tasks;

   
    public TaskService() {
        tasks = new ArrayList<>();
    }

    
    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    
    public List<Task> getTasks() {
        return tasks;
    }

   
    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setCompleted(true);
        }
    }

    
    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskService taskService = new TaskService();

        while (true) {
            System.out.println("\nTo-Do List Application");
            System.out.println("1. Add a task");
            System.out.println("2. View all tasks");
            System.out.println("3. Mark a task as completed");
            System.out.println("4. Delete a task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    taskService.addTask(description);
                    System.out.println("Task added!");
                    break;
                case 2:
                    List<Task> tasks = taskService.getTasks();
                    System.out.println("\nTasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                    break;
                case 3:
                    System.out.print("Enter the task number to mark as completed: ");
                    int completedTaskIndex = scanner.nextInt() - 1;
                    taskService.markTaskAsCompleted(completedTaskIndex);
                    System.out.println("Task marked as completed!");
                    break;
                case 4:
                    System.out.print("Enter the task number to delete: ");
                    int deleteTaskIndex = scanner.nextInt() - 1;
                    taskService.deleteTask(deleteTaskIndex);
                    System.out.println("Task deleted!");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
