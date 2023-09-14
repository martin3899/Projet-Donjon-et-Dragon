package Exceptions;

public class PersonnageHorsPlateauException extends Exception{
    public PersonnageHorsPlateauException(int value){
        super("Personnage hors plateau: la valeur du dé est " + value);
    }
}

