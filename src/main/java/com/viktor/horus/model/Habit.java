package main.java.com.viktor.horus.model;

// In diesem Bereich werden die Attribute der Habits definiert.

public class Habit {
    private String name;
    private String description;
    private int frequency;
    private boolean completed;

    public Habit(String name, String description, int frequency) {
        this.name = name;
        this.description = description;
        this.frequency = frequency;
        this.completed = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}