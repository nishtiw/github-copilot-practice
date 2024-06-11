package com.practice.copilot.basics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the TaskManager class.
 */
public class TaskManagerTest {
    private TaskManager taskManager;

    /**
     * Sets up the test environment before each test method is executed.
     */
    @BeforeEach
    public void setUp() {
        taskManager = new TaskManager();
    }

    /**
     * Tests the addTask() method of TaskManager.
     * @throws DuplicateTaskException if a duplicate task is added.
     */
    @Test
    public void testAddTask() throws DuplicateTaskException {
        int initialSize = taskManager.listTasks().size();
        taskManager.addTask("Test task");
        assertEquals(initialSize + 1, taskManager.listTasks().size());
        assertEquals("Test task", taskManager.listTasks().get(initialSize).getDescription());
    }

    /**
     * Tests adding a duplicate task to TaskManager.
     * @throws DuplicateTaskException if a duplicate task is added.
     */
    @Test
    public void testAddDuplicateTask() throws DuplicateTaskException {
        taskManager.addTask("Test task");
        assertThrows(DuplicateTaskException.class, () -> taskManager.addTask("Test task"));
    }

    /**
     * Tests the listTasks() method of TaskManager.
     * @throws DuplicateTaskException if a duplicate task is added.
     */
    @Test
    public void testListTasks() throws DuplicateTaskException {
        taskManager.addTask("Task 1");
        taskManager.addTask("Task 2");
        taskManager.addTask("Task 3");
        assertEquals(3, taskManager.listTasks().size());
        assertEquals("Task 1", taskManager.listTasks().get(0).getDescription());
        assertEquals("Task 2", taskManager.listTasks().get(1).getDescription());
        assertEquals("Task 3", taskManager.listTasks().get(2).getDescription());
    }

    /**
     * Tests marking a task as done in TaskManager.
     * @throws DuplicateTaskException if a duplicate task is added.
     */
    @Test
    public void testMarkTaskAsDone() throws DuplicateTaskException {
        taskManager.addTask("Task to be done");
        taskManager.markTaskAsDone("Task to be done");
        assertTrue(taskManager.listTasks().get(0).isDone());

        // Check that all tasks are done
        assertTrue(taskManager.listTasks().stream().allMatch(Task::isDone));

        taskManager.markTaskAsDone("Non-existent task");
        // Check that all tasks are still done
        assertTrue(taskManager.listTasks().stream().allMatch(Task::isDone));
    }

    /**
     * Tests removing a task from TaskManager.
     * @throws DuplicateTaskException if a duplicate task is added.
     */
    @Test
    public void testRemoveTask() throws DuplicateTaskException {
        taskManager.addTask("Task to be removed");
        taskManager.removeTask("Task to be removed");
        assertEquals(0, taskManager.listTasks().size());

        taskManager.addTask("Task 1");
        taskManager.addTask("Task 2");
        taskManager.addTask("Task 3");
        taskManager.removeTask("Task 2");
        assertEquals(2, taskManager.listTasks().size());
        assertEquals("Task 1", taskManager.listTasks().get(0).getDescription());
        assertEquals("Task 3", taskManager.listTasks().get(1).getDescription());

        taskManager.removeTask("Non-existent task");
        assertEquals(2, taskManager.listTasks().size());
    }
}