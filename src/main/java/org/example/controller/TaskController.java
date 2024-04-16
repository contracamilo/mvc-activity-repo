package org.example.controller;

import org.example.models.Task;
import org.example.views.TaskView;

import java.util.ArrayList;
public class TaskController {
    private int option;
    ArrayList<Task> tasks;
    TaskView taskView;

    public TaskController() {
        taskView = new TaskView();
        tasks = new ArrayList<>();
    }

    public void start() {
        boolean  run = true;

        while (run) {
            option = taskView.start();
            switch (option) {
                case 1:
                    createTask();
                    break;
                case 2:
                    editTask();
                    break;
                case 3:
                    listTasks();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    completeTask();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public void createTask() {
        Task task = taskView.createTask();
        tasks.add(task);
    }
    public void listTasks() {
        taskView.listTasks(tasks);
    }
    public void editTask() {
        taskView.editTask(tasks);
    }

    public void deleteTask() {
        taskView.deleteTask(tasks);
    }

    public void completeTask() {
        taskView.completeTask(tasks);
    }
}
