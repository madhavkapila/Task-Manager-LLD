# Task Manager - LLD Project

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![Maven](https://img.shields.io/badge/Maven-4.0-red)

This is a Low-Level Design (LLD) project that implements a high-performance, in-memory task management system. The core logic is based on LeetCode 3408 and is exposed via a modern REST API built with Java and Spring Boot.

## V1 Features

* **Add Task:** Add a new task with a specified User ID, Task ID, and priority.
* **Edit Task:** Update the priority of an existing task.
* **Remove Task:** Delete a task from the system.
* **Execute Top Task:** Execute and remove the task with the highest priority across all users. Ties are broken by the highest Task ID.

## Core LLD Implementation

The backend service is optimized for high performance by using a combination of two key data structures:

* **`HashMap<Integer, Task>`**: Provides **O(1)** average time complexity for all lookups, edits, and removals based on a specific `taskId`.
* **`TreeSet<Task>`**: Acts as a self-sorting collection to keep tasks ordered by priority. It provides **O(log N)** complexity for additions and removals, which is optimal for the `edit` and `rmv` operations.

## API Endpoints (V1)

| Method | Endpoint                      | Body (JSON)                                | Description                                |
|--------|-------------------------------|--------------------------------------------|--------------------------------------------|
| `POST` | `/api/v1/tasks`               | `{ "userId": 1, "taskId": 101, "priority": 10 }` | Adds a new task.                           |
| `PUT`  | `/api/v1/tasks/{taskId}`      | `{ "priority": 15 }`                       | Updates the priority of an existing task.  |
| `DELETE`| `/api/v1/tasks/{taskId}`      | (None)                                     | Removes a task.                            |
| `POST` | `/api/v1/tasks/execute-top`   | (None)                                     | Executes and removes the highest priority task. |

## How to Run Locally

1.  **Prerequisites:**
    * Java 17 or newer
    * Apache Maven
2.  **Clone the repository:**
    ```bash
    git clone [your-repo-url]
    cd taskmanager
    ```
3.  **Run the application:**
    ```bash
    ./mvnw spring-boot:run
    ```
4.  The server will start on `http://localhost:8080`. You can now use a tool like Postman to interact with the API endpoints listed above.

## Future Roadmap (V2 and Beyond)

* **Desktop Client:** Develop a desktop UI using JavaFX to interact with the backend service.
* **OS-Level Integration:** Explore features that interact with the local operating system's processes.
* **Persistence:** Integrate a database (like H2 or PostgreSQL) to save tasks permanently.