import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationManager {
    private Map<String, Location> locations;

    public LocationManager() {
        locations = new HashMap<>();
        initializeLocations();
    }

    private void initializeLocations() {
        // Home
        Location home = new Location("Home");
        home.addResident("Sarabeth", "Mom", "watch survivor with mom");
        home.addResident("Lily", "Sister", "talk about pokemon");
        home.addResident("Blake", "Sister", "play fortnite with blake");
        home.addResident("MollieAnn", "Sister", "beat up mollieann");
        home.addFunction("sleep");
        home.addFunction("eat");
        home.addFunction("work on computer");
        home.addFunction("do homework");
        home.addFunction("play videogames");
        home.addFunction("watch tv");
        home.addFunction("go to car");

        // Mod Pizza
        Location modPizza = new Location("Mod Pizza");
        modPizza.addFunction("work shift");
        modPizza.addFunction("go to car");
        modPizza.addFunction("eat pizza");

        // Grayson's House
        Location graysonsHouse = new Location("Grayson's House");
        graysonsHouse.addResident("Grayson", "Friend", "hang with grayson");
        graysonsHouse.addResident("Senna", "Friend", "play games with senna");
        graysonsHouse.addResident("Kara", "Friend", "talk with kara");
        graysonsHouse.addFunction("sleep");
        graysonsHouse.addFunction("eat");
        graysonsHouse.addFunction("go to garage");
        graysonsHouse.addFunction("go to car");

        // Tatiana/Dawson's House
        Location tdHouse = new Location("Tatiana/Dawson's House");
        tdHouse.addResident("Tatiana", "Friend", "chat with tatiana");
        tdHouse.addResident("Dawson", "Friend", "play games with dawson");
        tdHouse.addResident("Phoenix", "Friend", "hang with phoenix");
        tdHouse.addFunction("pet rosie");
        tdHouse.addFunction("play boardgame");
        tdHouse.addFunction("listen to party music");
        tdHouse.addFunction("plan roadtrip");
        tdHouse.addFunction("go to car");

        // UNCC Campus
        Location campus = new Location("UNCC Campus");
        campus.addFunction("go to class");
        campus.addFunction("chill on hammock");
        campus.addFunction("get food");
        campus.addFunction("visit the edge");
        campus.addFunction("visit machine learning lab");
        campus.addFunction("skate around campus");
        campus.addFunction("listen to music");
        campus.addFunction("visit woodward");
        campus.addFunction("go to fencing club");
        campus.addFunction("go to car");

        // Car
        Location car = new Location("Car");
        car.addFunction("go to home");
        car.addFunction("go to mod pizza");
        car.addFunction("go to grayson's house");
        car.addFunction("go to tatiana/dawson's house");
        car.addFunction("go to uncc campus");

        // Add locations to map
        locations.put("Home", home);
        locations.put("Mod Pizza", modPizza);
        locations.put("Grayson's House", graysonsHouse);
        locations.put("Tatiana/Dawson's House", tdHouse);
        locations.put("UNCC Campus", campus);
        locations.put("Car", car);
    }

    public Location getLocation(String name) {
        return locations.get(name);
    }

    public List<String> getAllLocationNames() {
        return new ArrayList<>(locations.keySet());
    }
} 