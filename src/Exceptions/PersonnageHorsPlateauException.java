package Exceptions;

public class PersonnageHorsPlateauException extends Exception{
    public PersonnageHorsPlateauException(int value){
        System.out.println("Personnage hors plateau: la valeur du dé est " + value);
    }
}

