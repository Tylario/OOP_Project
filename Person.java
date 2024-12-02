public class Person {
    private String name;
    private int age;
    private int money;
    private Location currentLocation;
    private String interaction;

    public Person(String name, int age, int startingMoney) {
        this.name = name;
        this.age = age;
        this.money = startingMoney;
    }

    public int getMoney() {
        return money;
    }

    public void earnMoney(int amount) {
        this.money += amount;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }

    public String getName() {
        return name;
    }

    public void spendMoney(int amount) {
        this.money -= amount;
    }

    public void setInteraction(String interaction) {
        this.interaction = interaction;
    }

    public String getInteraction() {
        return interaction;
    }
    
    public void birthday() {
        this.age++;
    }

    public int getAge() {
        return age;
    }
} 