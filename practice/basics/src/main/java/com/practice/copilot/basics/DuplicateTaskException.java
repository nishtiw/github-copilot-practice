package com.practice.copilot.basics;

/**
 * This exception is thrown when a duplicate task is detected.
 */
class DuplicateTaskException extends Exception {
    /**
     * Constructs a new DuplicateTaskException with the specified detail message.
     *
     * @param message the detail message
     */
    public DuplicateTaskException(String message) {
        super(message);
    }
}