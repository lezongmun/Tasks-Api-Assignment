package com.doctoranywhere.tasksapi.api.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        Optional<Task> task = taskService.getTask(id);
        if (task.isPresent()) {
            return ResponseEntity.ok(task.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Get a list of all tasks
    @GetMapping("/tasks")
    public ArrayList<Task> getTasks() {
        ArrayList<Task> tasks = taskService.getTasks();
        return tasks;
    }

    // Create a new task
    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestParam Long id, @RequestParam String title,
            @RequestParam String description,
            @RequestParam Boolean completed) {
        Optional<Task> task = taskService.createTask(id, title, description, completed);
        if (task.isPresent()) {
            return ResponseEntity.ok(task.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Update a task by ID
    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "completed", required = false) Boolean completed) {
        Optional<Task> task = taskService.updateTask(id, title, description, completed);
        if (task.isPresent()) {
            return ResponseEntity.ok(task.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Delete a task by ID
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id) {
        Optional<Task> task = taskService.deleteTask(id);
        if (task.isPresent()) {
            return ResponseEntity.ok(task.get());
        }
        return ResponseEntity.notFound().build();
    }
}