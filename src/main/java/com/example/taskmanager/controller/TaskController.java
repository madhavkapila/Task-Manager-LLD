package com.example.taskmanager.controller;

import com.example.taskmanager.model.TaskRequest;
import com.example.taskmanager.service.TaskManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController 
{

    private final TaskManagerService taskManagerService;

    @Autowired
    public TaskController(TaskManagerService taskManagerService) 
    {
        this.taskManagerService = taskManagerService;
    }

    // Add a new task
    @PostMapping
    public ResponseEntity<String> addTask(@RequestBody TaskRequest request) 
    {
        taskManagerService.add(request.getUserId(), request.getTaskId(), request.getPriority());
        return ResponseEntity.ok("Task " + request.getTaskId() + " added.");
    }

    // Edit an existing task's priority
    @PutMapping("/{taskId}")
    public ResponseEntity<String> editTask(@PathVariable int taskId, @RequestBody TaskRequest request) 
    {
        taskManagerService.edit(taskId, request.getPriority());
        return ResponseEntity.ok("Task " + taskId + " priority updated.");
    }

    // Remove a task
    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> removeTask(@PathVariable int taskId) 
    {
        taskManagerService.rmv(taskId);
        return ResponseEntity.ok("Task " + taskId + " removed.");
    }

    // Execute the highest priority task
    @PostMapping("/execute-top")
    public ResponseEntity<String> executeTopTask() 
    {
        int userId = taskManagerService.execTop();
        if (userId == -1) 
        {
            return ResponseEntity.ok("No tasks to execute.");
        }
        return ResponseEntity.ok("Executed task for user: " + userId);
    }
}