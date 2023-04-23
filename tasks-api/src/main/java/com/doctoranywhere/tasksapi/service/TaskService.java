package com.doctoranywhere.tasksapi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.doctoranywhere.tasksapi.api.model.Task;

@Service
public class TaskService {

    private HashMap<Long, Task> tasks;

    public TaskService() {
        tasks = new HashMap<>();
    }

    // Get a single task by ID
    public Optional<Task> getTask(Long id) {
        // Optional optionalTask = Optional.empty();
        if (tasks.containsKey(id)) {
            Task task = tasks.get(id);
            return Optional.of(task);
        }

        // task not found
        return Optional.empty();
    }

    public ArrayList<Task> getTasks() {
        // Optional<ArrayList<Task>> optional = Optional.empty();
        ArrayList<Task> taskList = new ArrayList<>(tasks.values());
        return taskList;
    }

    public Optional<Task> createTask(Long id, String title, String description, Boolean completed) {
        // if task id already exists in tasks
        if (tasks.containsKey(id)) {
            return Optional.empty();
        }
        Task newTask = new Task(id, title, description, completed);
        tasks.put(id, newTask);
        return Optional.of(newTask);
    }

    public Optional<Task> updateTask(Long id, String title, String description, Boolean completed) {
        if (tasks.containsKey(id)) {
            if (title != null) {
                tasks.get(id).setTitle(title);
            }
            if (description != null) {
                tasks.get(id).setDescription(description);
            }
            if (completed != null) {
                tasks.get(id).setCompleted(completed);
            }
            return Optional.of(tasks.get(id));
        }
        return Optional.empty(); // task not found
    }

    public Optional<Task> deleteTask(Long id) {
        if (tasks.containsKey(id)) {
            Optional<Task> optional = Optional.of(tasks.get(id));
            tasks.remove(id);
            return optional;
        }
        // task not found
        return Optional.empty();
    }

}