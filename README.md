# Habit Tracker

A simple console-based Habit Tracker written in Java. This program allows you to **add habits, mark them as done, and save/load your habits using a CSV file**.

---

## Features

- Add new habits with name, description, and last completion date.
- Mark habits as done to automatically update last completion date.
- View all habits in the console.
- Save habits to a CSV file (`habits.csv`) and load them on program start.
- Console-based menu for easy interaction.

---

## Project Structure

  habit-tracker/
  
    src/main/java/com/viktor/habittracker/
    
      model/ # Habit data class
    
      service/ # Logic for habit management
    
      storage/ # Save/load habits to CSV
    
      ui/ # Console interface (main entry point)
  
    habits.csv # Optional: CSV file with saved habits
