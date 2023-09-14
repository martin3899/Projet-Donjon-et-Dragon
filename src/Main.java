import Exceptions.PersonnageHorsPlateauException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws PersonnageHorsPlateauException {
        Menu menu = new Menu();  //création de l'objet "menu"
        menu.launchGame();  //lancement du jeu
        menu.startGame();  //début du jeu
    }
}
