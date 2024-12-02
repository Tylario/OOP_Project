public class StateManager {
    private Person tyler;
    private LocationManager locationManager;
    private Location currentLocation;
    private int currentDay;
    private final String[] DAYS_OF_WEEK = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public StateManager() {
        tyler = new Person("Tyler", 22, 12000);
        locationManager = new LocationManager();
        currentLocation = locationManager.getLocation("Home");
        tyler.setCurrentLocation(currentLocation);
        currentDay = 0; // Start on Sunday
    }

    public Person getTyler() {
        return tyler;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String locationName) {
        Location newLocation = locationManager.getLocation(locationName);
        if (newLocation != null) {
            currentLocation = newLocation;
            tyler.setCurrentLocation(currentLocation);
        }
    }

    public LocationManager getLocationManager() {
        return locationManager;
    }

    public String getCurrentDayName() {
        return DAYS_OF_WEEK[currentDay];
    }

    public void advanceDay() {
        currentDay = (currentDay + 1) % 7;
    }
} 