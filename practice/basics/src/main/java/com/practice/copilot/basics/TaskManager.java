package com.practice.copilot.basics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

/**
 * The TaskManager class represents a manager for tasks.
 * It allows adding, listing, marking as done, and removing tasks.
 */
public class TaskManager {
    private List<Task> tasks;

    /**
     * Constructs a TaskManager object with an empty list of tasks.
     */
    public TaskManager() {
        tasks = new ArrayList<>();
    }

    /**
     * Adds a new task with the given description to the task list.
     * Throws a DuplicateTaskException if a task with the same description already exists.
     *
     * @param description the description of the task to be added
     * @throws DuplicateTaskException if a task with the same description already exists
     */
    public void addTask(String description) throws DuplicateTaskException {
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                throw new DuplicateTaskException("Task with description '" + description + "' already exists.");
            }
        }
        Task task = new Task(description);
        tasks.add(task);
    }

    /**
     * Returns an unmodifiable list of all tasks.
     *
     * @return an unmodifiable list of all tasks
     */
    public List<Task> listTasks() {
        // Return an unmodifiable list
        return Collections.unmodifiableList(tasks);
    }

    /**
     * Marks the task with the given description as done.
     *
     * @param description the description of the task to be marked as done
     */
    public void markTaskAsDone(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                task.setDone(true);
                break;
            }
        }
    }

    /**
     * Removes the task with the given description from the task list.
     *
     * @param description the description of the task to be removed
     */
    public void removeTask(String description) {
        // Use an Iterator to avoid ConcurrentModificationException
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getDescription().equals(description)) {
                iterator.remove();
                break;
            }
        }
    }
}

/**
 * The Task class represents a task with a description and a status (done or not done).
 */
class Task {
    private String description;
    private boolean done;

    /**
     * Constructs a Task object with the given description and sets the status to not done.
     *
     * @param description the description of the task
     */
    public Task(String description) {
        this.description = description;
        this.done = false;
    }

    /**
     * Returns the description of the task.
     *
     * @return the description of the task
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns true if the task is done, false otherwise.
     *
     * @return true if the task is done, false otherwise
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Sets the status of the task to done or not done.
     *
     * @param done the status of the task
     */
    public void setDone(boolean done) {
        this.done = done;
    }

    /**
     * Returns a string representation of the task.
     *
     * @return a string representation of the task
     */
    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", done=" + done +
                '}';
    }
}