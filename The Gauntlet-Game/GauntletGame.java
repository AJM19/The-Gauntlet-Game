import java.util.Scanner;
import Fighters.BaseFighter;
import Villains.BaseVillain;
import Battle.BattleMethods;
import Battle.SlowPrint;

public class GauntletGame {

    // ========================================================
    public static Scanner keyboard = new Scanner(System.in);
    // ========================================================
    final int MAX_GAME_LEVELS = 3;
    final int AVG_STRENGTH = 3;
    final int AVG_SPEED = 3;
    // ========================================================
    public static int response = 0;
    public static int stageNumber = 1;
    public static boolean whoWon = true; // True = fight won; false = fighter lost
    public static String lastVillain = "";
    public static String name = "";

    public static SlowPrint slowPrinter = new SlowPrint();
    public static BaseFighter fighter = new BaseFighter();
    public static BaseVillain villain = new BaseVillain();
    public static BattleMethods battleMethods = new BattleMethods();

    // ========================================================
    public static void main(String[] args) throws InterruptedException {

        slowPrinter.slowDisplay("HELLO!\n Welcome to \"The Gauntlet\"");
        slowPrinter.slowDisplay("The objective of the game is to defeat all 3 villains without losing");
        slowPrinter.slowDisplay("Lets get started.");

        while (name.length() < 3 || name.length() > 3) {
            System.out.println();
            slowPrinter.slowDisplay("What's your initials?");
            name = keyboard.nextLine();
        }

        name = name.substring(0, 1).toUpperCase() + name.substring(1, 2).toUpperCase()
                + name.substring(2, 3).toUpperCase();

        System.out.println();
        slowPrinter.slowDisplay("To begin, lets choose your character");

        do {
            slowPrinter.slowDisplay("Your options are:\n 1: Michael\n 2: Flynn\n 3: Freddie");
            System.out.println("SELECT: ");
            response = keyboard.nextInt();
            switch (response) {
            case 1:
                slowPrinter.slowDisplay("Michael it is!");
                fighter.setFighter("Michael");
                break;

            case 2:
                slowPrinter.slowDisplay("Flynn it is!");
                fighter.setFighter("Flynn");
                break;

            case 3:
                slowPrinter.slowDisplay("Freddie it is!");
                fighter.setFighter("Freddie");
                break;

            default:
                slowPrinter.slowDisplay("INVALID INPUT");
                break;
            }

        } while (response >= 4 || response <= 0);

        System.out.println();
        System.out.println(fighter);
        fighter.displayStats();
        System.out.println();
        slowPrinter.slowDisplay("Now that you've picked your fighter it's time to meet your first oppenent");
        slowPrinter.slowDisplay("Who would you like to fight first?");

        int response1;

        do {
            slowPrinter.slowDisplay("Your options are:\n 1: Monkey\n 2: Bear\n 3: Snake");
            response = keyboard.nextInt();
            response1 = response;
            switch (response) {
            case 1:
                slowPrinter.slowDisplay("Monkey it is!");
                villain.setVillain("Monkey");
                break;

            case 2:
                slowPrinter.slowDisplay("Bear it is!");
                villain.setVillain("Bear");
                break;

            case 3:
                slowPrinter.slowDisplay("Snake it is!");
                villain.setVillain("Snake");
                break;

            default:
                slowPrinter.slowDisplay("INVALID INPUT");
                break;
            }

        } while (response >= 4 || response <= 0);

        System.out.println();
        System.out.println(villain);
        System.out.println();

        slowPrinter.slowDisplay("+-+-+-+-+-+TIME TO FIGHT+-+-+-+-+-+");
        System.out.println();
        slowPrinter.slowDisplay("BATTLE #" + stageNumber);

        whoWon = battleMethods.isWinner(fighter, villain); // Round one fight

        if (whoWon == false) {
            System.out.println();
            slowPrinter.slowDisplay("OH NO!! You lost :(");
            slowPrinter.slowDisplay("Please restart and try again.");
            slowPrinter.slowDisplay("Goodbye.");
            return;
        } else {
            stageNumber++;
            slowPrinter.slowDisplay("Congrats! You defeated your first opponent...");
            slowPrinter.slowDisplay("Now it's time to meet the next!");

        }

        if (response1 == 1) {
            slowPrinter.slowDisplay("Your options are:\n 1: Bear\n 2: Snake");
            response = keyboard.nextInt();
            response1 = response;
            switch (response) {
            case 1:
                slowPrinter.slowDisplay("Bear it is!");
                villain.setVillain("Bear");
                lastVillain = "Snake";
                break;

            case 2:
                slowPrinter.slowDisplay("Snake it is!");
                villain.setVillain("Snake");
                lastVillain = "Bear";
                break;

            default:
                slowPrinter.slowDisplay("INVALID INPUT");
                break;
            }
        } else if (response1 == 2) {
            slowPrinter.slowDisplay("Your options are:\n 1: Monkey\n 2: Snake");
            response = keyboard.nextInt();
            response1 = response;
            switch (response) {
            case 1:
                slowPrinter.slowDisplay("Monkey it is!");
                villain.setVillain("Monkey");
                lastVillain = "Snake";
                break;

            case 2:
                slowPrinter.slowDisplay("Snake it is!");
                villain.setVillain("Snake");
                lastVillain = "Monkey";
                break;

            default:
                slowPrinter.slowDisplay("INVALID INPUT");
                break;
            }
        } else if (response1 == 3) {
            slowPrinter.slowDisplay("Your options are:\n 1: Monkey\n 2: Bear");
            response = keyboard.nextInt();
            response1 = response;
            switch (response) {
            case 1:
                slowPrinter.slowDisplay("Monkey it is!");
                villain.setVillain("Monkey");
                lastVillain = "Bear";
                break;

            case 2:
                slowPrinter.slowDisplay("Bear it is!");
                villain.setVillain("Bear");
                lastVillain = "Monkey";
                break;

            default:
                slowPrinter.slowDisplay("INVALID INPUT");
                break;
            }
        }

        slowPrinter.slowDisplay("+-+-+-+-+-+TIME TO FIGHT+-+-+-+-+-+");
        System.out.println();
        slowPrinter.slowDisplay("BATTLE #" + stageNumber);

        whoWon = battleMethods.isWinner(fighter, villain); // Round two fight

        if (whoWon == false) {
            System.out.println();
            slowPrinter.slowDisplay("OH NO!! You lost :(");
            slowPrinter.slowDisplay("Please restart and try again.");
            slowPrinter.slowDisplay("Goodbye.");
            return;
        } else {
            stageNumber++;
            slowPrinter.slowDisplay("WOW! TWO opponents down...only ONE left to beat....");
            slowPrinter.slowDisplay("Can you beat the last one and finish \"The Gauntlet\"");

        }

        villain.setVillain(lastVillain);

        slowPrinter.slowDisplay("Your final opponent is " + lastVillain);
        slowPrinter.slowDisplay("If you defeat " + lastVillain + " you will have completed \"The Gauntlet\" ");
        System.out.println();
        slowPrinter.slowDisplay("GOOD LUCK.");
        System.out.println();
        slowPrinter.slowDisplay("+-+-+-+-+-+TIME TO FIGHT+-+-+-+-+-+");
        System.out.println();
        slowPrinter.slowDisplay("BATTLE #" + stageNumber);

        whoWon = battleMethods.isWinner(fighter, villain); // Round three fight

        if (whoWon == false) {
            System.out.println();
            slowPrinter.slowDisplay("OH NO!! You lost :(");
            slowPrinter.slowDisplay("Please restart and try again.");
            slowPrinter.slowDisplay("Goodbye.");
            return;
        } else {
            stageNumber++;
            slowPrinter.slowDisplay("Congratulations!!!.......YOU HAVE COMPLETED \"The Gauntlet\"");
            slowPrinter.slowDisplay("Now it's time to receive your trophy");
        }
        System.out.println("-----------------------");
        System.out.println("\\  GAUNTLET CHAMPION  /");
        System.out.println(" \\                   /");
        System.out.println("  \\__             __/");
        System.out.println("     |           |");
        System.out.println("     |           |");
        System.out.println("     |           |");
        System.out.println("     |           |");
        System.out.println("     |           |");
        System.out.println("     |           |");
        System.out.println("     |    " + name + "    |");
        System.out.println("     /            \\");
        System.out.println("    /______________\\");
    }

}