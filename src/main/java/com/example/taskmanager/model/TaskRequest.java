package com.example.taskmanager.model;

public class TaskRequest 
{
    private int userId;
    private int taskId;
    private int priority;

    // Getters and Setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public int getTaskId() { return taskId; }
    public void setTaskId(int taskId) { this.taskId = taskId; }
    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }
}