package main.java.com.viktor.horus.ui;

import java.util.Scanner;
import main.java.com.viktor.horus.storage.HabitStorage;

public class HabitCli {
    public static void main(String[] args) {
        System.out.println("Willkommen bei Horos, deinem Habit-Tracker! Bitte treffe eine Auswahl aus dem Menü:");
        
        // Überprüfe und aktualisiere den Fälligkeitsstatus der Habits beim Starten der Anwendung.
        HabitStorage.updateDueStatus();
    
        boolean running = true;
        while (running) {
            // Menü anzeigen
            System.out.println("");
            System.out.println("==========================================");
            System.out.println("    HORUS, Habit-Tracker - Hauptmenü    ");
            System.out.println("==========================================");
            System.out.println("");
            System.out.println("1. Habit hinzufügen");
            System.out.println("2. Habits pflegen");
            System.out.println("3. Beenden");
            System.out.println("");

            // Menüauswahl vom Benutzer lesen
            Scanner scanner = new Scanner(System.in);
            Integer choiceMainMenu = scanner.nextInt();

            // Auswahl verarbeiten
            switch (choiceMainMenu) {
                case 1:
                    // Logik zum Hinzufügen eines Habits     
                    System.out.println("Habit hinzufügen ausgewählt.");
                    System.out.println("Bitte gib den Namen des Habits ein:");
                    scanner.nextLine(); // Verhindert, dass der nächste Scanner.nextInt() den Zeilenumbruch liest
                    String name = scanner.nextLine();
                    System.out.println("Bitte gib die Beschreibung des Habits ein:");
                    String description = scanner.nextLine();
                    System.out.println("Bitte gib die Frequenz des Habits ein (z.B. 1 für täglich, 7 für wöchentlich):");
                    int frequency = scanner.nextInt();
                    int id = (int) (Math.random() * 10000); // Generiere eine zufällige ID
                    HabitStorage.addHabit(id, name, description, frequency);
                    System.out.println("Habit erfolgreich hinzugefügt!");
                    break;
                case 2:
                    // Habits in der Konsole ausgeben.
                    System.out.println("Habits pflegen ausgewählt.");
                    HabitStorage.printHabits(); 
                    System.out.println("1 für \"Erledigt setzen\", 0 für \"Zurück zum Menü\":");
                    Integer choiceSubMenu = scanner.nextInt();
                    switch (choiceSubMenu) {
                        case 1:
                            // Logik zum Markieren eines Habits als erledigt
                            System.out.println("Bitte gib die ID des Habits ein, das als erledigt markiert werden soll. 0 für \"Zurück zum Menü\":");
                            int idChoice = scanner.nextInt();
                            while (idChoice != 0) {
                                HabitStorage.markHabitAsDone(idChoice);                                
                                System.out.println("Gebe die nächste ID des Habits ein, das als erledigt markiert werden soll. 0 für \"Zurück zum Menü\":");
                                idChoice = scanner.nextInt();
                            }
                            break;
                        case 0:
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Beenden ausgewählt. Auf Wiedersehen!");
                    running = false;
                    break;
                default:
                    System.out.println("Ungültige Auswahl. Bitte versuche es erneut.");
            }
        }
    }
}