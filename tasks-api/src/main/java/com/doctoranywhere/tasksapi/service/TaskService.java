package com.doctoranywhere.tasksapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.doctoranywhere.tasksapi.api.model.Task;

@Service
public class TaskService {

    private List<Task> tasks;

    public TaskService() {
        tasks = new ArrayList<>();
    }

    // Get a single task by ID
    public Optional<Task> getTask(Long id) {
        // Optional optionalTask = Optional.empty();
        for (Task task : tasks) {
            if (id == task.getId()) {
                return Optional.of(task);
            }
        }
        // task not found
        return Optional.empty();
    }

}