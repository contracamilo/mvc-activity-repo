package org.example;

import org.example.controller.TaskController;


public class Main {
    public static void main(String[] args) {
        TaskController taskController = new TaskController();
        taskController.start();
    }
}