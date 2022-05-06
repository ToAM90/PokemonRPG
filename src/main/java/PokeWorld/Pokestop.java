package PokeWorld;

import Main.Backbone;
import java.util.Random;
public class Pokestop {

    // **** STOCKING THE STORE ****
    Random randomNumberGenerator = new Random();
    private int noOfStandard = randomNumberGenerator.nextInt(4);
    private int noOfGreat = randomNumberGenerator.nextInt(3);
    private int noOfUltra = randomNumberGenerator.nextInt(2);


    // **** POKESTOP SHELF ****

    public void shelf(){
        System.out.println("(1) Standard Ball: " + noOfStandard);
        System.out.println("(2) Great Ball: " + noOfGreat);
        System.out.println("(3) Ultra Ball: " + noOfUltra);
        System.out.println("(4) Exit");
    }


    // **** PURCHASING ONE BALL ****

    public void purchaseBall (Pokeball pokeball){
        if (pokeball.getType() == 3 && noOfUltra > 0){
            pokeball.setNumber(pokeball.getNumber() + 1);
            noOfUltra -= 1;
            Backbone.clearConsole();
            System.out.println("Purchased 1 Ultra Ball\n");
        } else if (pokeball.getType() == 2 && noOfGreat > 0){
            pokeball.setNumber(pokeball.getNumber() + 1);
            noOfGreat -= 1;
            Backbone.clearConsole();
            Backbone.printSeparator(30);
            System.out.println("Purchased 1 Great Ball\n");
        } else if (pokeball.getType() == 1 && noOfStandard > 0){
            pokeball.setNumber(pokeball.getNumber() + 1);
            noOfStandard -= 1;
            Backbone.clearConsole();
            System.out.println("Purchased 1 Standard Ball\n");
        }
        else {
            Backbone.clearConsole();
            System.out.println("Unable to make purchase. Inventory out of stock.\n");
        }
    }

}
