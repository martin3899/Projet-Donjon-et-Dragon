import Exceptions.PersonnageHorsPlateauException;
import TypePersonnage.Guerrier;
import TypePersonnage.Magicien;

import java.util.Scanner;

public class Menu {

    private String characterType;
    public void launchGame() {  //Lancement du jeu
        System.out.println("Vous jouez à Donjons & Dragons");
    }

    public void startGame() throws PersonnageHorsPlateauException {  //Début du jeu
        String askModificationCharacter = scanner("Voulez-vous modifier le personnage?");
        if (transformToBoolean(askModificationCharacter)) {

            String characterType = scanner("Entrer le type").toLowerCase();

            while (characterType != "guerrier" || characterType != "magicien"){
                if (characterType.equals("guerrier")) {
                    String characterName = scanner("Entrer le nom");
                    createWarrior(characterName, characterType);
                    break;
                } else if (characterType.equals("magicien")) {
                    String characterName = scanner("Entrer le nom");
                    createMage(characterName, characterType);
                    break;
                } else {
                    characterType=scanner("Entrer le type").toLowerCase();
                }
            }


            //System.out.println("Le personnage est de type " + characterType);
            //System.out.println("Le personnage s'appelle " + characterName);


            String asksIfItsSuit = scanner("Ce personnage vous convient?");

            if (asksIfItsSuit.equals("non")) {
                startGame();    // On recommence si c'est non
            } else {
                gameplay();     // On joue si c'est oui
            }

        } else {
            gameplay();
        }
    }

    public void gameplay() throws PersonnageHorsPlateauException { //Partie de jeu
        System.out.println("Lancement de la partie");
        int position = 1;
        System.out.println("Le personnage est sur la case " + position);
        while (position < 64) {
            int valueDe = (int) (Math.random() * 6) + 1;   //Lancement du dé
            position += valueDe;   //Mise  à jour de la position

            if (position > 64) {
                try{
                    throw new PersonnageHorsPlateauException(valueDe);
                } catch(PersonnageHorsPlateauException e) {
                    System.out.println("Vous revenez à la position initiale!");
                    position -= valueDe;
                }
            }

            System.out.println("Le personnage est sur la case " + position);
        }
        System.out.println("Bravo, vous avez gagné!");
        endGame();
    }

    public void endGame() throws PersonnageHorsPlateauException {  //Fin de jeu

        System.out.println("Fin de la partie");
        String restartGame = scanner("Voulez-vous recommencer?");

        if (restartGame.equals("oui")) {
            startGame();      //Si oui on recommence
            gameplay();
        } else {
            System.out.println("Vous quittez le jeu!"); // Si non on quitte le jeu
        }
    }

    public String scanner(String question) {
        Scanner scn = new Scanner(System.in);
        String answer;
        System.out.println(question);          //Proposition pour recommencer la parie
        answer = scn.nextLine();
        return answer;
    }

    public void createWarrior(String name, String type) {
        Guerrier warrior = new Guerrier(name);
        warrior.displayFeatures(type);
        System.out.println(warrior.toString(type));
    }

    public void createMage(String name, String type) {
        Magicien mage = new Magicien(name);
        mage.displayFeatures(type);
        System.out.println(mage.toString(type));
    }

    public boolean transformToBoolean(String word){
        word.equals("oui");
        return true;
    }
}
