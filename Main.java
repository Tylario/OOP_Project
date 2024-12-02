import java.util.Scanner;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    private static void printWithDelay(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> scanner.close()));
        
        StateManager stateManager = new StateManager();
        FunctionManager functionManager = new FunctionManager(stateManager);
        
        printWithDelay("Welcome to Tyler's Life 2024!");
        printWithDelay("Type 'view stats' at any time to see Tyler's current status.");
        printWithDelay("Type 'help' to see available commands.\n");

        // Show initial location and functions
        displayLocationAndFunctions(stateManager, functionManager);

        while (true) {
            // Get user input
            System.out.print("\nWhat would you like to do? ");
            String input = scanner.nextLine().toLowerCase();

            // Process input
            if (!functionManager.executeFunction(input)) {
                printWithDelay("Invalid command. Available functions:");
                List<String> availableFunctions = functionManager.getAvailableFunctions();
                availableFunctions.forEach(f -> printWithDelay("- " + f));
            } else {
                // Only show location and functions after successful command
                displayLocationAndFunctions(stateManager, functionManager);
            }
        }
    }

    private static void displayLocationAndFunctions(StateManager stateManager, FunctionManager functionManager) {
        printWithDelay("\nCurrent location: " + stateManager.getCurrentLocation().getName());
        printWithDelay("Available functions:");
        List<String> availableFunctions = functionManager.getAvailableFunctions();
        availableFunctions.forEach(f -> printWithDelay("- " + f));
    }
}