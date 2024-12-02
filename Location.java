import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Location {
    private String name;
    private List<Person> residents;
    private List<String> availableFunctions;

    public Location(String name) {
        this.name = name;
        this.residents = new ArrayList<>();
        this.availableFunctions = new ArrayList<>();
    }

    public void addResident(String name, String relationship, String interaction) {
        Person person = new Person(name, 0, 0);  // age and money default to 0 for NPCs
        person.setInteraction(interaction);
        residents.add(person);
    }

    public boolean canSleep() {
        return name.equals("Home") || name.equals("Grayson's House");
    }

    public String getName() {
        return name;
    }

    public List<String> getAvailableFunctions() {
        List<String> functions = new ArrayList<>(availableFunctions);
        // Add resident-specific interactions
        for (Person resident : residents) {
            if (resident.getInteraction() != null) {
                functions.add(resident.getInteraction());
            }
        }
        return functions;
    }

    public boolean isFriendPresent(String friendName) {
        for (Person resident : residents) {
            if (resident.getName().equals(friendName)) {
                return true;
            }
        }
        return false;
    }

    public List<Person> getResidents() {
        return residents;
    }

    public String getResidentsList() {
        if (residents.isEmpty()) {
            return "Nobody is here";
        }
        return residents.stream()
            .map(Person::getName)
            .collect(Collectors.joining(", "));
    }

    public void addFunction(String function) {
        availableFunctions.add(function);
    }
} 