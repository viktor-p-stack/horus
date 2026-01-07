package main.java.com.viktor.horus.ui;

import java.util.Scanner;

public class HabitCli {
    public static void main(String[] args) {
        System.out.println("Willkommen bei Horos, deinem Habit-Tracker! Bitte treffe eine Auswahl aus dem Menü:");
    
        boolean running = true;
        while (running) {
            // Menü anzeigen
            System.out.println("1. Habit hinzufügen");
            System.out.println("2. Habits anzeigen");
            System.out.println("3. Habit als erledigt markieren");
            System.out.println("4. Beenden");

            // Menüauswahl vom Benutzer lesen
            Scanner scanner = new Scanner(System.in);
            Integer choice = scanner.nextInt();

            // Auswahl verarbeiten
            switch (choice) {
                case 1:
                    System.out.println("Habit hinzufügen ausgewählt.");
                    // Logik zum Hinzufügen eines Habits
                    break;
                case 2:
                    System.out.println("Habits anzeigen ausgewählt.");
                    // Logik zum Anzeigen der Habits
                    break;
                case 3:
                    System.out.println("Habit als erledigt markieren ausgewählt.");
                    // Logik zum Markieren eines Habits als erledigt
                    break;
                case 4:
                    System.out.println("Beenden ausgewählt. Auf Wiedersehen!");
                    running = false;
                    break;
                default:
                    System.out.println("Ungültige Auswahl. Bitte versuche es erneut.");
            }
            scanner.close();
        }
    }
}