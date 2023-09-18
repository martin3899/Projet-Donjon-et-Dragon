import Exceptions.PersonnageHorsPlateauException;
import Personnage.Personage;
import TypePersonnage.Guerrier;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws PersonnageHorsPlateauException {
//        Menu menu = new Menu();  //création de l'objet "menu"
//        menu.launchGame();  //lancement du jeu
//        menu.startGame();  //début du jeu
        Game game = new Game();
        Guerrier warrior = new Guerrier("Harry");
        System.out.println(warrior);
        game.jouerUnTour(warrior);
        //game.setPlateauDeJeu();
    }
}
