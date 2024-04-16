package org.example.views;

import org.example.models.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskView {
    Scanner scanner = new Scanner(System.in);
    public int start() {
        int option = -1;
        System.out.println("____________Welcome to the Task Manager!__________");
        System.out.println("1. Create task");
        System.out.println("2. Edit task");
        System.out.println("3. List task");
        System.out.println("4. Delete task");
        System.out.println("5. Mark task as done");
        System.out.println("6. Exit");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next();
        }
        option = scanner.nextInt();
        return option;
    }

    public Task createTask() {
        String name, description;
        System.out.println("____________Create task____________");
        System.out.println("Enter the name of the task: ");
        name = scanner.next();

        System.out.println("Type description: ");
        description = scanner.next();

        Task task = new Task();
        task.setName(name);
        task.setDescription(description);

        return task;
    }
    public void listTasks(ArrayList<Task> tasks) {
        System.out.println("____________________________________________");
        for (Task task : tasks) {
            System.out.println("________________task_________________");
            System.out.println("Name: " + task.getName());
            System.out.println("Desc: " + task.getDescription());
            System.out.println("Done: " + task.isComplete());
            System.out.println("______________________________________");
        }
        System.out.println("____________________________________________");
    }
    public void editTask(ArrayList<Task> tasks) {
        System.out.println("Enter the name of the task to edit: ");
        String name = scanner.next();
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                System.out.println("Enter the new name of the task: ");
                String newName = scanner.next();
                System.out.println("Enter the new description of the task: ");
                String newDescription = scanner.next();
                System.out.println("Enter the new completion status of the task (true for complete, false for incomplete): ");
                boolean newIsComplete = scanner.nextBoolean();
                task.setName(newName);
                task.setDescription(newDescription);
                task.setComplete(newIsComplete);
                System.out.println("Task updated successfully.");
                return;
            }
        }
        System.out.println("Task not found. No changes were made.");
    }

    public void deleteTask(ArrayList<Task> tasks) {
        System.out.println("Enter the name of the task to delete: ");
        String name = scanner.next();
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                tasks.remove(task);
                System.out.println("Task deleted successfully.");
                return;
            }
        }
        System.out.println("Task not found. No changes were made.");
    }

    public void completeTask(ArrayList<Task> tasks) {
        System.out.println("Enter the name of the task to complete: ");
        String name = scanner.next();
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                task.setComplete(true);
                System.out.println("Task completed successfully.");
                return;
            }
        }
        System.out.println("Task not found. No changes were made.");
    }
}
