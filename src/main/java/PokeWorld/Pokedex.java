package PokeWorld;

import Main.Backbone;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Pokedex {

    private static Map<Integer, Pokemon> wildPokemon = new HashMap<>();
    private static Map<Integer, Pokemon> caughtPokemon = new HashMap<>();
    private static Pokemon foundPokemon;

    // **** CREATING A NEW WORLD FULL OF POKEMON ****
    public static void newWorld() {
        File inputFile = new File("pokemon.txt");

        try {
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] lineArr = line.split("\\,");

                Integer slot = Integer.parseInt(lineArr[0]);
                String name = lineArr[1];
                String type = lineArr[2];
                int escapeChance = Integer.parseInt(lineArr[3]);
                double fleeRate = Double.parseDouble(lineArr[4]);
                String notes = lineArr[5];

                Pokemon pokemon = new Pokemon(slot, name, type, escapeChance, fleeRate, notes);
                wildPokemon.put(slot, pokemon);

            }

        } catch (FileNotFoundException e) {
            System.out.println("World does not exist.");
        }
    }



    // Looking for Pokemons

    public boolean lookForPokemon() {
        Random random = new Random();
        double chance = random.nextDouble();
        if (chance > 0.5) {
            int pokemonPosition = random.nextInt(wildPokemon.size());
            foundPokemon = wildPokemon.get(pokemonPosition);
            Backbone.printHeading("\nThe Pokemon " + foundPokemon.getName() + " has been discovered!\n");
            return true;
        }
        Backbone.printHeading("\nNo pokemon found...\n");
        return false;

    }


    // Successfully catching the Pokemon is dependent on escapeChance,
    // which is decreased by Pokeball used, and caughtChance
    // If successful, Pokemon is added to Pokedex and one Pokeball is used

    public boolean capture(Pokeball pokeball) {
        double escapeChance = foundPokemon.getEscapeChance() / 100;
        escapeChance *= pokeball.getDecreaseEscapeChance();
        Random random = new Random();
        final double caughtChance = random.nextDouble();
        if (caughtChance > escapeChance) {
            wildPokemon.remove(foundPokemon);
            caughtPokemon.put(foundPokemon.getSlot(), foundPokemon);
            return true;
        } else {
            return false;
        }
    }


    public void capturedPokemon() {
        Set<Integer> keys = caughtPokemon.keySet();
        for (Integer key : keys) {
            System.out.println(caughtPokemon.get(key).getSlot() + " " + caughtPokemon.get(key));
        }
    }

    public static Map<Integer, Pokemon> getCaughtPokemon() {
        return caughtPokemon;
    }


    public static Pokemon getFoundPokemon() {
        return foundPokemon;
    }
}




