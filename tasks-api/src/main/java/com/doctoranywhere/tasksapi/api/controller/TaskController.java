package com.doctoranywhere.tasksapi.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping
    public Task getTask(@RequestParam Long id) {
        Optional<Task> task = taskService.getTask(id);
        if (task.isPresent()) {
            return (Task) task.get();
        }
        return null;

    }
}