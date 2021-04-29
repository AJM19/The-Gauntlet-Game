package Fighters;

public class BaseFighter {

    public double health;
    public String name;
    public String location;

    public int speed; // 1-5
    public int strength; // 1-5

    public String move1 = "Charge";
    public String move2 = "Spear";
    public String move3 = "Knife";

    public int move1Damage = 25;
    public int move2Damage = 40;
    public int move3Damage = 50;

    public BaseFighter() {
        health = 0;
        name = "";
        location = "";

        speed = 0;
        strength = 0;
    }

    public void decreaseHealth(int damage) {
        health -= damage;

    }

    public String toString() {
        return (name + " has " + health + " hp\n" + name + " is from " + location);
    }

    public void displayStats() {
        System.out.println(name + " is ranked a level " + strength + " and has a speed level of " + speed);

    }

    public void setFighter(String fighter) {

        switch (fighter) {

        case "Freddie":
            health = 250;
            name = "Freddie";
            location = "UK";

            speed = 4; // 1-5
            strength = 5; // 1-5
            break;

        case "Flynn":
            health = 250;
            name = "Flynn";
            location = "Oregon";

            speed = 4; // 1-5
            strength = 5; // 1-5
            break;

        case "Michael":
            health = 250;
            name = "Michael";
            location = "USA";

            speed = 4; // 1-5
            strength = 5; // 1-5
            break;

        }

    }

}