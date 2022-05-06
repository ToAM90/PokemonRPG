package PokeWorld;

public class Pokemon {

    private int slot;
    private String name;
    private String type;
    private int escapeChance;
    private double fleeRate;
    private String notes;

    public Pokemon(Integer slot, String name, String type, int escapeChance, double fleeRate, String notes) {
        this.slot = slot;
        this.name = name;
        this.type = type;
        this.escapeChance = escapeChance;
        this.fleeRate = fleeRate;
        this.notes = notes;
    }


    @Override
    public String toString() {
        return "Pokemon: " + name +
                " Type: " + type;
    }

    public String getName() {
        return name;
    }

    public int getSlot() {
        return slot;
    }
    public int getEscapeChance() {
        return escapeChance;
    }

    public String getNotes() {
        return notes;
    }

    public double getFleeRate() {
        return fleeRate;
    }

    /* public in maxHp, hp, xp
    public abstract int attack()
    public abstract int defend()
     */
}
