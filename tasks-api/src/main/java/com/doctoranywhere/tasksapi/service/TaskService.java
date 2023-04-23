package com.doctoranywhere.tasksapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.doctoranywhere.tasksapi.api.model.Task;

@Service
public class TaskService {

    private ArrayList<Task> tasks;

    public TaskService() {
        tasks = new ArrayList<>();
        Task task1 = new Task((long) 1, "title", "description", false);
        tasks.add(task1);
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

    public Optional<ArrayList<Task>> getTasks() {
        // Optional<ArrayList<Task>> optional = Optional.empty();
        if (tasks.size() == 0) {
            return Optional.empty();
        }
        ArrayList<Task> tasksCopy = new ArrayList<>(tasks);
        return Optional.of(tasksCopy);
    }

    public Task createTask(Long id, String title, String description, Boolean completed) {
        Task newTask = new Task(id, title, description, completed);
        tasks.add(newTask);
        return newTask;
    }

}