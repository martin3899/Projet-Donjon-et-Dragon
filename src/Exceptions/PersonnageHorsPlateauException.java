package Exceptions;

public class PersonnageHorsPlateauException extends Exception{

    private int posValue;

    public int getPosValue() {
        return posValue;
    }

    public PersonnageHorsPlateauException(int value){
        super("Personnage hors plateau: la valeur du dé est " + value);
        this.posValue=value;
    }
}

