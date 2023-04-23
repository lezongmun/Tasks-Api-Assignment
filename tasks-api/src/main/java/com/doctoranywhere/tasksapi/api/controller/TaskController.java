package com.doctoranywhere.tasksapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doctoranywhere.tasksapi.api.model.Task;
import com.doctoranywhere.tasksapi.service.TaskService;

@RestController
public class TaskController {

    private TaskService taskService;

    @Autowired // auto injection of an instance of TaskService into constructor
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public Task getTask(@RequestParam Long id) {
        return taskService.getTask(id);
    }
}