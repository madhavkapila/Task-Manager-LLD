package com.example.taskmanager.model;

public class Task {
    public int userId;
    public int taskId;
    public int priority;

    public Task(int u, int t, int p) {
        this.userId = u;
        this.taskId = t;
        this.priority = p;
    }
}