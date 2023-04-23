package com.doctoranywhere.tasksapi.api.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doctoranywhere.tasksapi.api.model.Task;
import com.doctoranywhere.tasksapi.service.TaskService;

@RestController
public class TaskController {

    private TaskService taskService;

    // auto injection of an instance of TaskService into constructor
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Get a single task by ID
    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable Long id) {
        Optional<Task> task = taskService.getTask(id);
        if (task.isPresent()) {
            return (Task) task.get();
        }
        return null;

    }

    // Get a list of all tasks
    @GetMapping("/tasks")
    public ArrayList<Task> getTasks() {
        Optional<ArrayList<Task>> tasks = taskService.getTasks();
        if (tasks.isPresent()) {
            return (ArrayList<Task>) tasks.get();
        }
        return null;
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestParam Long id, @RequestParam String title, @RequestParam String description,
            @RequestParam Boolean completed) {
        Task task = taskService.createTask(id, title, description, completed);
        return task;
    }

}