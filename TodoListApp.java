import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {
    private ArrayList<String> todoList = new ArrayList<>();

    public void displayList() {
        if (todoList.isEmpty()) {
            System.out.println("\t\t\t"+"Your to-do list is empty.");
        } else {
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println("\t\t\t"+i + ". " + todoList.get(i));
            }
        }
    }

    public void addTask(String task) {
        todoList.add(task);
        System.out.println("\t\t\t"+"Task added: " + task);
    }

    public void removeTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < todoList.size()) {
            String removedTask = todoList.remove(taskIndex);
            System.out.println("\t\t\t"+"Task removed: " + removedTask);
        } else {
            System.out.println("\t\t\t"+"Invalid task index.");
        }
    }

    public static void main(String[] args) {
        TodoListApp todoListApp = new TodoListApp();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n"+"\t\t\t--- Todo List Menu ---");
            System.out.println("\t\t\t"+"1. Display To-Do List");
            System.out.println("\t\t\t"+"2. Add Task");
            System.out.println("\t\t\t"+"3. Remove Task");
            System.out.println("\t\t\t"+"4. Quit");
            System.out.print("\t\t\t"+"Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    todoListApp.displayList();
                    break;
                case 2:
                    System.out.print("\t\t\t"+"Enter the task to add: ");
                    scanner.nextLine(); // Consume the newline character
                    String newTask = scanner.nextLine();
                    todoListApp.addTask(newTask);
                    break;
                case 3:
                    System.out.print("\t\t\t"+"Enter the index of the task to remove: ");
                    int taskIndex = scanner.nextInt();
                    todoListApp.removeTask(taskIndex);
                    break;
                case 4:
                    System.out.println("\t\t\t"+"Goodbye!");
                    break;
                default:
                    System.out.println("\t\t\t"+"Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
