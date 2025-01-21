import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {

    // Constants for menu options
    private static final int ADD_TASK = 1;
    private static final int VIEW_TASKS = 2;
    private static final int DELETE_TASK = 3;
    private static final int EXIT = 4;

    private final ArrayList<String> tasks = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ToDoListApp app = new ToDoListApp();
        app.run();
    }

    // Main application logic
    private void run() {
        System.out.println("====== Welcome to the To-Do List Application ======");
        int choice;

        do {
            printMenu();
            choice = getUserChoice();
            handleMenuChoice(choice);
        } while (choice != EXIT);

        System.out.println("Thank you for using the To-Do List Application. Goodbye!");
    }

    // Displays the menu
    private void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add a task");
        System.out.println("2. View tasks");
        System.out.println("3. Delete a task");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    // Retrieves user input for menu selection
    private int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next(); // Clear invalid input
        }
        return scanner.nextInt();
    }

    // Handles the menu choice
    private void handleMenuChoice(int choice) {
        scanner.nextLine(); // Consume leftover newline
        switch (choice) {
            case ADD_TASK:
                addTask();
                break;
            case VIEW_TASKS:
                viewTasks();
                break;
            case DELETE_TASK:
                deleteTask();
                break;
            case EXIT:
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    // Adds a new task
    private void addTask() {
        System.out.print("Enter the task to add: ");
        String task = scanner.nextLine();
        if (task.isBlank()) {
            System.out.println("Task cannot be empty!");
        } else {
            tasks.add(task.trim());
            System.out.println("Task added successfully.");
        }
    }

    // Displays all tasks
    private void viewTasks() {
        System.out.println("\nYour To-Do List:");
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Deletes a task
    private void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to delete.");
            return;
        }

        System.out.print("Enter the task number to delete: ");
        int taskNumber = getUserChoice();
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            String removedTask = tasks.remove(taskNumber - 1);
            System.out.println("Task \"" + removedTask + "\" deleted successfully.");
        } else {
            System.out.println("Invalid task number. Please try again.");
        }
    }
}
