package main.java.com.viktor.horus.storage;

import main.java.com.viktor.horus.model.Habit;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Diese Klasse wird für die Speicherung und Verwaltung der Habits verwendet.
public class HabitStorage {
    private static final String FILE ="src/main/ressources/habits.csv";
    private static final String FILEID ="src/main/ressources/id.csv";
    private static final String DELIMITER = ",";

    // Logik zum Speichern der Habits in die CSV-Datei.
    public static void save(List<Habit> habits) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {
            for (Habit habit : habits) {
                StringBuilder sb = new StringBuilder();
                sb.append(habit.getId()).append(DELIMITER);
                sb.append(habit.getCreatedAt()).append(DELIMITER);
                sb.append(habit.getName()).append(DELIMITER);
                sb.append(habit.getDescription()).append(DELIMITER);
                sb.append(habit.getEveryXDays()).append(DELIMITER);
                sb.append(habit.isCompleted()).append(DELIMITER);
                sb.append(habit.isDue());
                bw.write(sb.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Logik zum Laden der Habits aus der CSV-Datei.
    public static List<Habit> load() {
        List<Habit> habits = new ArrayList<>();
        File file = new File(FILE);
        if (!file.exists()) {
            return habits;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(DELIMITER);
                int id = Integer.parseInt(values[0]);
                String name = values[2];
                String description = values[3];
                int frequency = Integer.parseInt(values[4]);
                boolean completed = Boolean.parseBoolean(values[5]);

                Habit habit = new Habit(id, name, description, frequency);
                habit.setCompleted(completed);
                habits.add(habit);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return habits;
    }

    // Ausgeben der Habits in die Konsole.
    public static void printHabits() {
        List<Habit> habits = load();
        for (Habit habit : habits) {
            System.out.println("ID: " + habit.getId() +
                    ", Name: " + habit.getName() +
                    ", Beschreibung: " + habit.getDescription() +
                    ", Frequenz: " + habit.getEveryXDays() +
                    ", Erledigt: " + habit.isCompleted() +
                    ", Fällig: " + habit.isDue());
        }
    }
    
    // Logik zum Hinzufügen eines neuen Habits.
    public static Habit addHabit(int id, String name, String description, int frequency) {
        Habit newHabit = new Habit(id, name, description, frequency);
        List<Habit> habits = load();
        habits.add(newHabit);
        save(habits);
        return newHabit;
    }

    // Logik zum Markieren eines Habits als erledigt.
    public static void markHabitAsDone(int id) {
        List<Habit> habits = load();
        for (Habit habit : habits) {
            if (habit.getId() == id) {
                habit.setCompleted(true);
                habit.setLastCompletedAt(LocalDate.now());
                System.out.println("Habit mit ID " + id + " wurde als erledigt markiert.");
                break;
            }
        }
        save(habits);
    }

    // Logik zum Überprüfen und Aktualisieren des Fälligkeitsstatus (due) der Habits.
    public static void updateDueStatus() {
        List<Habit> habits = load();
        LocalDate today = LocalDate.now();
        for (Habit habit : habits) {
            LocalDate lastCompletedAt = habit.getLastCompletedAt();
            if (lastCompletedAt == null) {
                habit.setDue(true);
            } else {
                LocalDate nextDueDate = lastCompletedAt.plusDays(habit.getEveryXDays());
                habit.setDue(!today.isBefore(nextDueDate));
            }
        }
        save(habits);
    }

    // Logik zum Generieren der nächsten eindeutigen ID für ein neues Habit.
    public static int getNextId() {
        int nextId = 1;
        File file = new File(FILEID);
        
        try {
            // Datei existiert? Dann ID auslesen
            if (file.exists()) {
                List<String> lines = Files.readAllLines(Paths.get(FILEID));
                if (!lines.isEmpty()) {
                    nextId = Integer.parseInt(lines.get(0).trim()) + 1;
                }
            }

            // Neue ID zurückschreiben
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILEID))) {
                bw.write(String.valueOf(nextId));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return nextId;
    }
}