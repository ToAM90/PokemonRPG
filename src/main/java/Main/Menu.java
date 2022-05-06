package Main;


public class Menu {

    public static void mainMenu(){
        Backbone.clearConsole();
        Backbone.printHeading("Welcome to the exciting, wonderful world of Pokemon. \nA group of the most unusual creatures teeming with mystery. " +
                "\nSome Pokemon live alongside humans! \nWhile some can be found in the grasslands, in the sky, and in the waters. \nWild Pokemons live everywhere!" +
                "\n\nSo...Are you ready to start your journey as a Pokemon Trainer and capture them all?");
        System.out.println("\n(1) Create your character\n(2) Exit");
    }

    public static void gameMenu(){
        Backbone.clearConsole();
         Backbone.printHeading("(1) View map\n(2) Look for pokemon\n(3) Visit the Pokestop\n(4) Inventory\n(5) Pokedex\n(6) Exit");
    }


    public static void catchPokemon(){
        System.out.println("Do you want to catch the Pokemon?\n(1) Catch (2) Go Back. ");
    }

    public static void pokedexMenu(){
        Backbone.clearConsole();
        System.out.println("Enter ID Number for the Pokemon's information. (X) Exit");
    }

    public static void inventoryMenu(){
        Backbone.clearConsole();
        Backbone.printHeading("Inventory");
        System.out.println();

    }

    public static void keepLooking(){
        System.out.println("Do you want to keep looking?\n(1) Yes (2) No");
    }

    public static void exit(){
        System.out.println("(X) Exit");
    }

    public static void map(){
        // System.out.println("░░░░░░░░▀████▀▄▄░░░░░░░░░░░░░░▄█\n░░░░░░░░░░█▀░░░░▀▀▄▄▄▄▄░░░░▄▄▀▀█\n░░▄░░░░░░░░█░░░░░░░░░░▀▀▀▀▄░░▄▀\n░▄▀░▀▄░░░░░░▀▄░░░░░░░░░░░░░░▀▄▀\n▄▀░░░░█░░░░░█▀░░░▄█▀▄░░░░░░▄█\n▀▄░░░░░▀▄░░█░░░░░▀██▀░░░░░██▄█\n░▀▄░░░░▄▀░█░░░▄██▄░░░▄░░▄░░▀▀░█\n░░█░░▄▀░░█░░░░▀██▀░░░░▀▀░▀▀░░▄▀\n░█░░░█░░█░░░░░░▄▄░░░░░░░░░░░▄▀");
        System.out.println("                                           ┏━━━━━━━━━━━━━┓");
        System.out.println("                                           ┃ Pallet Town ┃");
        System.out.println("                                           ┗━━━━━━┳━━━━━━┛");
        System.out.println("┏━━━━━━━━━━━━━┓     ┏━━━━━━━━━━━━━━━━┓     ┏━━━━━━┻━━━━━━┓     ┏━━━━━━━━━━━━━┓");
        System.out.println("┃    Cave     ┣━━━━━┫Entrance to Cave┣━━━━━┫   Forest    ┣━━━━━┫    Ruins    ┃");
        System.out.println("┗━━━━━━━━━━━━━┛     ┗━━━━━━━━━━━━━━━━┛     ┗━━━━━━━━━━━━━┛     ┗━━━━━━━━━━━━━┛");
    }

}

