import Main.Backbone;
import Main.Menu;
import PokeWorld.*;
import World.*;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private Scanner inputScanner;
    private Pokedex pokedex;
    private Pokestop pokestop;
    private Pokeball standard = new Standard();
    private Pokeball great = new Great();
    private Pokeball ultra = new Ultra();
    private Map map;
    private Objects objects;


    public Game() {
        this.inputScanner = new Scanner(System.in);
        this.pokestop = new Pokestop();
        this.pokedex = new Pokedex();
        this.map = new Map();
        this.objects = new Objects();
    }

    public static void main(String[] args) {
        Game game = new Game();
        Map.map();
        Pokedex.newWorld();
        game.run();

    }

    public void run() {
        Menu.mainMenu();
        boolean keepGoing = true;
        do {
            int mainInput = Backbone.readInt(2);
            if (mainInput == 1) {
                createCharacter();

                Backbone.timePass();
                Backbone.printHeading("Good Morning! Are you ready to begin your journey?");

                Backbone.anythingToContinue();
                startGame();
            } else if (mainInput == 2) {
                System.out.println("Exiting Game");
                System.exit(0);
            }
        } while (keepGoing);
    }

    public void startGame() {
        boolean keepGoing = true;

        do {
            Menu.gameMenu();
            int gameInput = Backbone.readInt(6);
            if (gameInput == 1) {
                //  **** VIEW MAP ****
                viewMap();
            } else if (gameInput == 2) {
                //  **** LOOK FOR POKEMON ****
                looking();
            } else if (gameInput == 3) {
                //  **** VISIT POKESTOP ****
                pokestop();
            } else if (gameInput == 4) {
                //  **** VIEW INVENTORY ****
                inventory();
            } else if (gameInput == 5) {
                // **** VIEW POKEDEX ****
                pokedexMenu();
            } else if (gameInput == 6) {
                System.exit(0);
            }
        }
        while (keepGoing);

    }

    public void createCharacter() {

        Backbone.clearConsole();
        boolean keepGoing = true;

        do {
            Backbone.printHeading("What is your name?");
            String name = Backbone.readStr("");
            Backbone.printHeading("Your name is " + name + " is that correct?");
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want to change my name.");
            int input = Backbone.readInt(2);
            if (input == 1) {
                keepGoing = false;
                Objects.pc.name = name;
                Objects.pc.inRoom = 1;
            }
        } while (keepGoing);
    }


    public void pokestop() {
        boolean keepGoing = true;
        Backbone.clearConsole();
        Backbone.printHeading("Welcome to the Pokestop");
        pokestop.shelf();
        Backbone.printHeading("Are you ready to purchase? Go ahead and enter a number!");
        do {
            int input = Backbone.readInt(4);
            if (input == 1) {
                pokestop.purchaseBall(standard);
            } else if (input == 2) {
                pokestop.purchaseBall(great);
            } else if (input == 3) {
                pokestop.purchaseBall(ultra);
            } else if (input == 4) {
                keepGoing = false;
            }
            Backbone.printHeading("Updating Shelf...");
            pokestop.shelf();
            Backbone.printHeading("Are you ready to purchase? Go ahead and enter a number!");
        } while (keepGoing);
    }

    public void inventory() {
        boolean keepGoing = true;
        Menu.inventoryMenu();
        do {
            System.out.println("Standard: " + standard.getNumber());
            System.out.println("Great: " + great.getNumber());
            System.out.println("Ultra: " + ultra.getNumber());
            Backbone.printSeparator(30);
            Menu.exit();
            String input = Backbone.readStr("");
            if (input.equals("X")) {
                keepGoing = false;
            }
        } while (keepGoing);
    }

    public void looking() {

        boolean keepGoing = true;

        do {
            if (pokedex.lookForPokemon()) {
                Menu.catchPokemon();
                int input = Backbone.readInt(2);
                if (input == 1) {
                    catchingPokemon();
                    keepGoing = false;
                } else if (input == 2) {
                    keepGoing = false;
                }
            } else {
                Menu.keepLooking();
                int input = Backbone.readInt(2);
                if (input == 1) {
                    continue;
                } else if (input == 2) {
                    keepGoing = false;
                }
            }
        }
        while (keepGoing);
    }

    public void catchingPokemon() {
        Pokemon pokemon = Pokedex.getFoundPokemon();
        Random random = new Random();
        final double fleeChance = random.nextDouble();
        boolean keepGoing = true;
        do {
            System.out.println("\n(1) Normal Ball: " + standard.getNumber() + "\n(2) Great Ball: " + great.getNumber() + "\n(3) Ultra Ball: " + ultra.getNumber() + "\n");
            Integer ballChoice = Backbone.readInt(3);
            if (ballChoice == 1) {
                if (standard.useBall()) {
                    if (pokedex.capture(standard)) {
                        Backbone.printHeading("\n" + pokemon.getName() + " has been Caught!!\n");
                        Backbone.anythingToContinue();
                        keepGoing = false;
                    } else {
                        if (fleeChance < pokemon.getFleeRate()) {
                            Backbone.printHeading("\n" + pokemon.getName() + " has fled!");
                            Backbone.anythingToContinue();
                            keepGoing = false;
                        } else {
                            System.out.println("\nCapture was unsuccessful. Do you want to try again?\n(1) Yes (2) No");
                            int input = Backbone.readInt(2);
                            if (input == 1) {
                                continue;
                            } else if (input == 2) {
                                keepGoing = false;
                            }
                        }
                    }
                } else {
                    Backbone.anythingToContinue();
                    keepGoing = false;
                }
            } else if (ballChoice == 2) {
                if (great.useBall()) {
                    if (pokedex.capture(great)) {
                        System.out.println("\n" + pokemon.getName() + " has been Caught!!\n");
                        Backbone.anythingToContinue();
                        keepGoing = false;
                    } else {
                        if (fleeChance < pokemon.getFleeRate()) {
                            System.out.println("\n" + pokemon.getName() + " has fled!");
                            Backbone.anythingToContinue();
                            keepGoing = false;
                        } else {
                            System.out.println("\nCapture was unsuccessful. Do you want to try again?\n(1) Yes (2) No");
                            int input = Backbone.readInt(2);
                            if (input == 1) {
                                continue;
                            } else if (input == 2) {
                                keepGoing = false;
                            }
                        }
                    }
                } else {
                    Backbone.anythingToContinue();
                    keepGoing = false;
                }
            } else if (ballChoice == 3) {
                if (ultra.useBall()) {
                    if (pokedex.capture(ultra)) {
                        System.out.println("\n" + pokemon.getName() + " has been Caught!!\n");
                        Backbone.anythingToContinue();
                        keepGoing = false;
                    } else {
                        if (fleeChance < pokemon.getFleeRate()) {
                            System.out.println("\n" + pokemon.getName() + " has fled!");
                            Backbone.anythingToContinue();
                            keepGoing = false;
                        } else {
                            System.out.println("\nCapture was unsuccessful. Do you want to try again?\n(1) Yes (2) No");
                            int input = Backbone.readInt(2);
                            if (input == 1) {
                                continue;
                            } else if (input == 2) {
                                keepGoing = false;
                            }
                        }
                    }
                } else {
                    Backbone.anythingToContinue();
                    continue;
                }
            }
        } while (keepGoing);
    }

    public void pokedexMenu() {
        boolean keepGoing = true;

        do {
            Menu.pokedexMenu();
            Backbone.printSeparator(30);
            pokedex.capturedPokemon();
            Backbone.printSeparator(30);
            String input = Backbone.readStr("");
            if (input.equals("X")) {
                keepGoing = false;
            } else {
                try {
                    Backbone.clearConsole();
                    Pokemon pokemon = pokedex.getCaughtPokemon().get(Integer.parseInt(input));
                    System.out.println(pokemon + pokemon.getNotes());
                    Backbone.printSeparator(30);
                    Menu.exit();
                    String exitInput = Backbone.readStr("");
                    if (exitInput.equals("X")) {
                        keepGoing = false;
                    }
                } catch (NullPointerException e) {
                    System.out.println("Pokemon does not exist or have not been captured.");
                    Backbone.anythingToContinue();
                }
            }

        } while (keepGoing);

    }

    public void viewMap() {
        boolean keepGoing = true;

        do {
            Menu.map();
            for (int i = 0; i < Objects.room.size(); i++) {
                if (Objects.room.get(i).number == Objects.pc.inRoom) {
                    System.out.print("\n\nCurrent Location:");
                    System.out.println(Objects.room.get(i).name);
                    System.out.println();
                    for (int j = 0; j < Objects.room.get(i).desc.size(); j++) {
                        System.out.println(Objects.room.get(i).desc.get(j));
                    }
                    System.out.println("\nExits");
                    for (int j = 0; j < Objects.room.get(i).exits.size(); j++) {
                        String exitNameFull = Objects.room.get(i).exits.get(j);
                        String[] exitName = exitNameFull.split(" ");
                        System.out.println("(" + (j + 1) + ") " + exitName[1]);
                    }
                }
            }
            Menu.exit();
            String input = Backbone.readStr("");
            if (input.equals("X")) {
                keepGoing = false;
                Backbone.clearConsole();
            } else {
                try {
                    move(Integer.parseInt(input) - 1);
                } catch (NumberFormatException e){
                    System.out.println("Invalid Input");
                    Backbone.anythingToContinue();
                }
            }

        } while (keepGoing);
    }

    public void move(int x) {
        try {
            for (int i = 0; i < Objects.room.size(); i++) {
                if (Objects.room.get(i).number == Objects.pc.inRoom) {
                        String exitRequested = Objects.room.get(i).exits.get(x);
                        String[] exitArray = exitRequested.split(" ");
                        Objects.pc.inRoom = Integer.parseInt(exitArray[2]);
                        System.out.println("You take the " + exitArray[1] + " exit.");
                        break;
                    }
                }
            } catch (Exception e) {
            System.out.println("\nInvalid Input\n");
            Backbone.anythingToContinue();
        }
    }
}


