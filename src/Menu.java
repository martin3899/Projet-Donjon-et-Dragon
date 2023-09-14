import Exceptions.PersonnageHorsPlateauException;
import TypePersonnage.Guerrier;
import TypePersonnage.Magicien;

import java.util.Scanner;

public class Menu {

    private String characterType;

    public void launchGame() {  //Lancement du jeu
        System.out.println("Vous jouez à Donjons & Dragons");
    }

    public void startGame() {  //Début du jeu

        String askModificationCharacter = transformToString(scannerBoolean("Voulez-vous modifier le personnage?"));

        if (askModificationCharacter.equals("oui")) {

            String characterType = scanner("Entrer le type").toLowerCase();

            while (characterType != "guerrier" || characterType != "magicien") {
                if (characterType.equals("guerrier")) {
                    String characterName = scanner("Entrer le nom");
                    createWarrior(characterName);
                    break;
                } else if (characterType.equals("magicien")) {
                    String characterName = scanner("Entrer le nom");
                    createMage(characterName);
                    break;
                } else {
                    System.out.println("Ca n'existe pas ducon!");
                    characterType = scanner("Entrer le type").toLowerCase();
                }
            }


            //System.out.println("Le personnage est de type " + characterType);
            //System.out.println("Le personnage s'appelle " + characterName);


            String asksIfItsSuit = transformToString(scannerBoolean("Ce personnage vous convient?"));

            if (asksIfItsSuit.equals("non")) {
                startGame();    // On recommence si c'est non
            } else {
                gameplay();     // On joue si c'est oui
            }

        } else {
            gameplay();
        }
    }

    public void gameplay() { //Partie de jeu
        System.out.println("Lancement de la partie");
        Game partie = new Game();
        try {
            partie.game();
        } catch (PersonnageHorsPlateauException e) {
            System.out.println(e.getMessage());
            System.out.println("Bravo, vous avez gagné!");
            endGame();
        }

    }

    public void endGame() {  //Fin de jeu

        System.out.println("Fin de la partie");
        String restartGame = transformToString(scannerBoolean("Voulez-vous recommencer?"));

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
    public boolean scannerBoolean(String question) {
        Scanner scn = new Scanner(System.in);
        boolean answer;
        System.out.println(question);          //Proposition pour recommencer la parie
        answer = scn.nextBoolean();
        return answer;
    }

    public void createWarrior(String name) {
        Guerrier warrior = new Guerrier(name);
        warrior.setTypeCharacter("guerrier");
        warrior.displayFeatures();
        System.out.println(warrior.toString());
    }

    public void createMage(String name) {
        Magicien mage = new Magicien(name);
        mage.setTypeCharacter("magicien");
        mage.displayFeatures();
        System.out.println(mage.toString());
    }

    public String transformToString(boolean word) {
        if (word==true){
            return "oui";
        }
        else {
            return "non";
        }
    }
}
