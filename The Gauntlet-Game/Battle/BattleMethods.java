package Battle;

import Fighters.BaseFighter;
import Villains.BaseVillain;
import Battle.SlowPrint;
import java.util.Scanner;

public class BattleMethods {
    private int moveResponse;

    private double fighterSpeed;
    public double fighterHealth;

    private double villainHealth;

    private double randomNumber1;
    private double randomNumber2;

    public static Scanner keyboard = new Scanner(System.in);
    public static SlowPrint slowPrinter = new SlowPrint();
    public HitActions actions = new HitActions();

    public boolean isWinner(BaseFighter fighter, BaseVillain villain) throws InterruptedException {

        fighterSpeed = fighter.speed;
        fighterHealth = fighter.health;

        villainHealth = villain.health;

        do {

            System.out.println("It's your move...");
            System.out.println();
            displayMoves(fighter);
            System.out.println("SELECT MOVE : ");
            moveResponse = keyboard.nextInt();

            randomNumber1 = ((int) (Math.random() * 5) + 1);
            randomNumber2 = ((int) (Math.random() * 5) + 1);

            switch (moveResponse) {

            case 1:
                if (fighterSpeed < randomNumber1) {
                    slowPrinter.slowDisplay(fighter.name + " missed");
                } else {
                    slowPrinter.slowDisplay(fighter.name + fightAction(moveResponse) + villain.name);
                    villainHealth -= fighter.move1Damage;
                }
                break;
            case 2:
                if (fighterSpeed < randomNumber1) {
                    slowPrinter.slowDisplay(fighter.name + " missed");
                } else {
                    slowPrinter.slowDisplay(fighter.name + fightAction(moveResponse) + villain.name);
                    villainHealth -= fighter.move2Damage;
                }
                break;
            case 3:
                if (fighterSpeed < randomNumber1) {
                    slowPrinter.slowDisplay(fighter.name + " missed");
                } else {
                    slowPrinter.slowDisplay(fighter.name + fightAction(moveResponse) + villain.name);
                    villainHealth -= fighter.move3Damage;
                }
                break;

            }
            slowPrinter.slowDisplay("            ");
            slowPrinter.slowDisplay("            ");

            slowPrinter.slowDisplay("Villain's turn...");

            if (randomNumber2 > villain.speed) {
                slowPrinter.slowDisplay(villain.name + " hit " + fighter.name);
                fighterHealth -= 50;
            } else {
                slowPrinter.slowDisplay(villain.name + " missed");
            }

            slowPrinter.slowDisplay("            ");
            slowPrinter.slowDisplay("            ");

        } while (fighterHealth > 0 && villainHealth > 0);

        if (villainHealth <= 0) {
            System.out.println("===================================");
            slowPrinter.slowDisplay("FIGHTER WINS!");
            return true;
        } else {
            System.out.println("===================================");
            System.out.println("VILLAIN WINS!");
            return false;
        }

    }

    public void displayMoves(BaseFighter fighter) throws InterruptedException {

        slowPrinter.slowDisplay("FIGHTER MOVES: ");
        slowPrinter.slowDisplay("Move 1: " + fighter.move1 + " *" + fighter.move1Damage + "*" + "   Move 2: "
                + fighter.move2 + " *" + fighter.move2Damage + "*");
        slowPrinter.slowDisplay("Move 3 : " + fighter.move3 + " *" + fighter.move3Damage + "*");

    }

    public String fightAction(int selection) {
        String noise = "";
        switch (selection) {

        case 1:
            noise = " charged at ";
            break;
        case 2:
            noise = " speared ";
            break;
        case 3:
            noise = " stabbed ";
            break;
        }
        return noise;
    }

}
