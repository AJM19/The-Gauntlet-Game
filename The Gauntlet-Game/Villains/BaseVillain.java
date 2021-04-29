package Villains;

import Fighters.BaseFighter;

public class BaseVillain extends BaseFighter {

    public double health;
    public String name;
    public int speed;
    public int strength; // 1-5
    public String noise;

    public BaseVillain() {
        health = 0;
        name = "";
        strength = 0;
        noise = "";
    }

    public void decreaseHealth(int damage) {
        health -= damage;

    }

    public void speak() {
        System.out.println(noise);
    }

    public String toString() {
        return (name + " has " + health + "hp remaining\n" + noise);
    }

    public void displayStats() {
        System.out.println(name + " has" + health + "hp and is ranked a level " + strength);

    }

    public int getStrength() {

        return strength;
    }

    public int getSpeed() {

        return speed;
    }

    public double getHealth() {

        return health;
    }

    public String getName() {

        return name;
    }

    public void setVillain(String villain) {

        switch (villain) {
        case "Monkey":
            name = "Monkey";
            noise = "\"Oooh, Ooh, Ah, Ah!\"";
            health = 100.0;
            speed = 3;
            strength = 1;
            break;

        case "Bear":
            health = 200.0;
            name = "Bear";
            strength = 2; // 1-5
            noise = "\"Growl Grrr Growl\"";
            speed = 2;
            break;

        case "Snake":
            health = 300.0;
            name = "Snake";
            strength = 3; // 1-5
            speed = 3;
            noise = "\"Tssss Tssss\"";
            break;
        }

    }
}
