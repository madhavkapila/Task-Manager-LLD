package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TaskManagerService 
{

    // Your optimized data structures, initialized and ready.
    private final Map<Integer, Task> tasks = new HashMap<>();
    private final SortedSet<Task> execOrder = new TreeSet<>((a, b) -> {
        int cmp = Integer.compare(b.priority, a.priority);
        if (cmp != 0) return cmp;
        return Integer.compare(b.taskId, a.taskId);
    });

    public void add(int userId, int taskId, int priority) 
    {
        Task t = new Task(userId, taskId, priority);
        tasks.put(taskId, t);
        execOrder.add(t);
    }
    
    public void edit(int taskId, int newPriority) 
    {
        Task t = tasks.get(taskId);
        if (t == null) return;

        execOrder.remove(t);
        t.priority = newPriority;
        execOrder.add(t);
    }

    public void rmv(int taskId) 
    {
        Task t = tasks.get(taskId);
        if (t == null) return;
        
        execOrder.remove(t);
        tasks.remove(taskId);
    }
    
    public int execTop() 
    {
        if (execOrder.isEmpty()) {
            return -1;
        }
        Task t = execOrder.first();
        int ans = t.userId;
        
        tasks.remove(t.taskId);
        execOrder.remove(t);
        
        return ans;
    }
}