package PokeWorld;

public abstract class Pokeball {

    private int number;
    private int type;
    private double decreaseEscapeChance;

    public Pokeball(int number, int type, double escapeChance) {
        this.number = number;
        this.type = type;
        this.decreaseEscapeChance = escapeChance;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getType() {
        return type;
    }

    public double getDecreaseEscapeChance() {
        return decreaseEscapeChance;
    }


    public boolean useBall(){
        if(number > 0){
            number -= 1;
            return true;
        }
        System.out.println("No more " + type + ".");
        return false;
    }

}
