package main.java.com.viktor.horus.model;

import java.time.LocalDate;

// In diesem Bereich werden die Attribute der Habits definiert.

public class Habit {
    private int id;
    private LocalDate createdAt;
    private String name;
    private String description;
    private int everyXDays;
    private boolean completed;
    private LocalDate lastCompletedAt;
    private boolean due;

    public Habit(int id, String name, String description, int everyXDays) {
        this.id = id;
        this.createdAt = LocalDate.now();
        this.name = name;
        this.description = description;
        this.everyXDays = everyXDays;
        this.completed = false;
        this.lastCompletedAt = null;
        this.due = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEveryXDays() {
        return everyXDays;
    }

    public void setEveryXDays(int everyXDays) {
        this.everyXDays = everyXDays;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setDue(boolean due) {
        this.due = due;
    }

    public boolean isDue() {
        return due;
    }

    public LocalDate getLastCompletedAt() {
        return lastCompletedAt;
    }

    public void setLastCompletedAt(LocalDate lastCompletedAt) {
        this.lastCompletedAt = lastCompletedAt;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}