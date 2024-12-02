import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FunctionManager {
    private StateManager stateManager;

    public FunctionManager(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public boolean executeFunction(String input) {
        input = input.toLowerCase();  // Convert input to lowercase
        Location currentLocation = stateManager.getCurrentLocation();
        Person tyler = stateManager.getTyler();

        // Handle simplified movement commands
        if (input.startsWith("go to ")) {
            String destination = input.substring(6);  // Remove "go to " prefix
            switch (destination) {
                case "home":
                case "house":
                    if (currentLocation.getName().equals("Car")) {
                        stateManager.setCurrentLocation("Home");
                        printWithDelay("Drove home.");
                        return true;
                    }
                    return false;

                case "mod":
                case "mod pizza":
                case "pizza":
                    if (currentLocation.getName().equals("Car")) {
                        stateManager.setCurrentLocation("Mod Pizza");
                        printWithDelay("Drove to Mod Pizza.");
                        return true;
                    }
                    return false;

                case "grayson":
                case "graysons":
                case "grayson's":
                case "graysons house":
                case "grayson's house":
                    if (currentLocation.getName().equals("Car")) {
                        stateManager.setCurrentLocation("Grayson's House");
                        printWithDelay("Drove to Grayson's house.");
                        return true;
                    }
                    return false;

                case "td":
                case "tatiana":
                case "dawson":
                case "tatiana/dawson":
                case "tatiana/dawsons":
                case "tatiana/dawson's":
                    if (currentLocation.getName().equals("Car")) {
                        stateManager.setCurrentLocation("Tatiana/Dawson's House");
                        printWithDelay("Drove to Tatiana and Dawson's house.");
                        return true;
                    }
                    return false;

                case "uncc":
                case "campus":
                case "school":
                    if (currentLocation.getName().equals("Car")) {
                        stateManager.setCurrentLocation("UNCC Campus");
                        printWithDelay("Drove to UNCC Campus.");
                        return true;
                    }
                    return false;

                case "car":
                    stateManager.setCurrentLocation("Car");
                    printWithDelay("Got in the car.");
                    return true;
            }
        }

        switch (input) {
            // Universal commands
            case "view stats":
                printWithDelay("\nTyler's Stats:");
                printWithDelay("Money: $" + tyler.getMoney());
                printWithDelay("Location: " + currentLocation.getName());
                printWithDelay("Present people: " + currentLocation.getResidentsList());
                printWithDelay("Day: " + stateManager.getCurrentDayName());
                return true;

            case "help":
                printWithDelay("Available commands depend on your location.");
                printWithDelay("Type 'view stats' to see your current status.");
                return true;

            // Movement commands
            case "go to mod pizza":
                stateManager.setCurrentLocation("Mod Pizza");
                printWithDelay("Traveled to Mod Pizza.");
                return true;

            case "go to uncc campus":
                stateManager.setCurrentLocation("UNCC Campus");
                printWithDelay("Traveled to UNCC Campus.");
                return true;

            case "go to car":
                stateManager.setCurrentLocation("Car");
                printWithDelay("Got in the car.");
                return true;

            case "go to home":
                if (currentLocation.getName().equals("Car")) {
                    stateManager.setCurrentLocation("Home");
                    printWithDelay("Drove to Home.");
                    return true;
                }
                return false;

            case "go to tatiana/dawson's house":
                if (currentLocation.getName().equals("Car")) {
                    stateManager.setCurrentLocation("Tatiana/Dawson's House");
                    printWithDelay("Drove to Tatiana and Dawson's house.");
                    return true;
                }
                return false;

            case "eat pizza":
                if (currentLocation.getName().equals("Mod Pizza")) {
                    tyler.spendMoney(12);
                    printWithDelay("Enjoyed a delicious pizza! -$12");
                    return true;
                }
                return false;

            // Location-specific commands
            case "work shift":
                if (currentLocation.getName().equals("Mod Pizza")) {
                    tyler.earnMoney(60);
                    printWithDelay("Completed a shift at Mod Pizza. Earned $60!");
                    return true;
                }
                printWithDelay("You need to be at Mod Pizza to work!");
                return false;

            case "hang with grayson":
                if (currentLocation.getName().equals("Grayson's House") && 
                    currentLocation.isFriendPresent("Grayson")) {
                    printWithDelay("Hanging out with Grayson. Good times!");
                    return true;
                }
                printWithDelay("Can't hang with Grayson right now. Is he home?");
                return false;

            case "go to class":
                if (currentLocation.getName().equals("UNCC Campus")) {
                    printWithDelay("Attended classes today. Learning is fun!");
                    return true;
                }
                return false;

            case "chill on hammock":
                if (currentLocation.getName().equals("UNCC Campus")) {
                    printWithDelay("Relaxing on the hammock between classes. Very peaceful!");
                    return true;
                }
                return false;

            case "get food":
                if (currentLocation.getName().equals("UNCC Campus")) {
                    tyler.spendMoney(10);
                    printWithDelay("Got some food from the dining hall. -$10");
                    return true;
                }
                return false;

            case "visit the edge":
                if (currentLocation.getName().equals("UNCC Campus")) {
                    printWithDelay("Visited The Edge to see old roommates. Good times!");
                    return true;
                }
                return false;

            case "visit machine learning lab":
                if (currentLocation.getName().equals("UNCC Campus")) {
                    printWithDelay("Working on AI projects in the machine learning lab.");
                    return true;
                }
                return false;

            case "skate around campus":
                if (currentLocation.getName().equals("UNCC Campus")) {
                    printWithDelay("Skating around campus. Watch out for pedestrians!");
                    return true;
                }
                return false;

            case "listen to music":
                if (currentLocation.getName().equals("UNCC Campus")) {
                    printWithDelay("Listening to music while walking between classes.");
                    return true;
                }
                return false;

            case "visit woodward":
                if (currentLocation.getName().equals("UNCC Campus")) {
                    printWithDelay("Hanging out in Woodward. Found some friends to talk to!");
                    return true;
                }
                return false;

            case "go to fencing club":
                if (currentLocation.getName().equals("UNCC Campus")) {
                    printWithDelay("Practicing with the fencing club. En garde!");
                    return true;
                }
                return false;

            case "sleep":
                if (currentLocation.canSleep()) {
                    stateManager.advanceDay();
                    printWithDelay("Got some rest. It's now " + stateManager.getCurrentDayName());
                    return true;
                }
                printWithDelay("Can't sleep here!");
                return false;

            case "watch survivor with mom":
                if (currentLocation.getName().equals("Home") && 
                    currentLocation.isFriendPresent("Sarabeth")) {
                    printWithDelay("Watching Survivor with Mom. Who's getting voted off tonight?");
                    return true;
                }
                return false;

            case "talk about pokemon":
                if (currentLocation.getName().equals("Home") && 
                    currentLocation.isFriendPresent("Lily")) {
                    printWithDelay("Discussing Pokemon with Lily. She knows all the evolution chains!");
                    return true;
                }
                return false;

            case "play fortnite with blake":
                if (currentLocation.getName().equals("Home") && 
                    currentLocation.isFriendPresent("Blake")) {
                    printWithDelay("Playing Fortnite with Blake. Victory Royale!");
                    return true;
                }
                return false;

            case "beat up mollieann":
                if (currentLocation.getName().equals("Home") && 
                    currentLocation.isFriendPresent("MollieAnn")) {
                    printWithDelay("Playfully wrestling with MollieAnn. She's stronger than she looks!");
                    return true;
                }
                return false;

            // Basic location functions
            case "eat":
                if (currentLocation.getName().equals("Home") || 
                    currentLocation.getName().equals("Grayson's House")) {
                    printWithDelay("Had a nice meal. Feeling satisfied!");
                    return true;
                }
                return false;

            case "watch tv":
                if (currentLocation.getName().equals("Home")) {
                    printWithDelay("Watching some TV. Good way to relax!");
                    return true;
                }
                return false;

            case "work on computer":
                if (currentLocation.getName().equals("Home")) {
                    printWithDelay("Working on some projects on the computer.");
                    return true;
                }
                return false;

            case "do homework":
                if (currentLocation.getName().equals("Home")) {
                    printWithDelay("Doing homework. Gotta keep those grades up!");
                    return true;
                }
                return false;

            case "play videogames":
                if (currentLocation.getName().equals("Home")) {
                    printWithDelay("Playing some video games. Time flies when you're having fun!");
                    return true;
                }
                return false;

            // Tatiana/Dawson's House functions
            case "pet rosie":
                if (currentLocation.getName().equals("Tatiana/Dawson's House")) {
                    printWithDelay("Petting Rosie the cat. Purrrr...");
                    return true;
                }
                return false;

            case "play boardgame":
                if (currentLocation.getName().equals("Tatiana/Dawson's House")) {
                    printWithDelay("Playing a fun boardgame with friends!");
                    return true;
                }
                return false;

            case "listen to party music":
                if (currentLocation.getName().equals("Tatiana/Dawson's House")) {
                    printWithDelay("Dancing to some great party music with friends!");
                    return true;
                }
                return false;

            case "plan roadtrip":
                if (currentLocation.getName().equals("Tatiana/Dawson's House")) {
                    printWithDelay("Planning an exciting roadtrip with friends!");
                    return true;
                }
                return false;

            case "chat with tatiana":
                if (currentLocation.getName().equals("Tatiana/Dawson's House") && 
                    currentLocation.isFriendPresent("Tatiana")) {
                    printWithDelay("Having a great conversation with Tatiana!");
                    return true;
                }
                return false;

            case "play games with dawson":
                if (currentLocation.getName().equals("Tatiana/Dawson's House") && 
                    currentLocation.isFriendPresent("Dawson")) {
                    printWithDelay("Playing games with Dawson. So much fun!");
                    return true;
                }
                return false;

            case "hang with phoenix":
                if (currentLocation.getName().equals("Tatiana/Dawson's House") && 
                    currentLocation.isFriendPresent("Phoenix")) {
                    printWithDelay("Hanging out with Phoenix. Good times!");
                    return true;
                }
                return false;

            default:
                return false;
        }
    }

    public List<String> getAvailableFunctions() {
        List<String> available = new ArrayList<>();
        Location currentLocation = stateManager.getCurrentLocation();
        
        // Add universal functions
        available.add("view stats");
        available.add("help");
        
        // Add location-specific functions
        if (currentLocation.getName().equals("Car")) {
            // In car - show destinations
            available.addAll(currentLocation.getAvailableFunctions());
        } else {
            // Not in car - show normal location functions
            available.addAll(currentLocation.getAvailableFunctions());
        }
        
        return available;
    }

    private void printWithDelay(String text) {
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
} 