package GameLogic;

import Exceptions.PersonnageHorsPlateauException;
import GameLogic.Game;
import Personnage.Personage;
import TypePersonnage.Guerrier;
import TypePersonnage.Magicien;

import java.util.Scanner;

public class Menu {

    private String characterTypes;

    private Personage personage;

    public void launchGame() {  //Lancement du jeu
        System.out.println("Vous jouez à Donjons & Dragons");
    }

    public void startGame() {  //Début du jeu

        String askModificationCharacter = scannerBoolean("Voulez-vous modifier le personnage?").toLowerCase();

        if (askModificationCharacter.equals("oui")) {

            String characterType = scanner("Entrer le type").toLowerCase();

            while (characterType != "guerrier" || characterType != "magicien") {
                if (characterType.equals("guerrier")) {
                    String characterName = scanner("Entrer le nom");
                    createWarrior(characterName);
                    personage= (Personage) createWarrior(characterName);
                    characterTypes=characterType;
                    break;
                } else if (characterType.equals("magicien")) {
                    String characterName = scanner("Entrer le nom");
                    createMage(characterName);
                    personage= (Personage) createMage(characterName);
                    characterTypes=characterType;
                    break;
                } else {
                    System.out.println("Ca n'existe pas ducon!");
                    characterType = scanner("Entrer le type").toLowerCase();
                }
            }







            String asksIfItsSuit = scannerBoolean("Ce personnage vous convient?").toLowerCase();

            if (asksIfItsSuit.equals("non")) {
                startGame();    // On recommence si c'est non
            } else {
                gameplay(characterTypes);     // On joue si c'est oui
            }

        } else {
            characterTypes="guerrier";
            gameplay(characterTypes);
        }
    }

    public void gameplay(String characterTypes) { //Partie de jeu
        System.out.println("Lancement de la partie");
        Game partie = new Game();
        try {
            partie.game(characterTypes, personage);
        } catch (PersonnageHorsPlateauException e) {
            System.out.println(e.getMessage());
            System.out.println("Bravo, vous avez gagné!");
            endGame();
        }

    }

    public void endGame() {  //Fin de jeu

        System.out.println("Fin de la partie");
        String restartGame = scannerBoolean("Voulez-vous recommencer?").toLowerCase();

        if (restartGame.equals("oui")) {
            startGame();      //Si oui on recommence
            gameplay(characterTypes);
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
    public String scannerBoolean(String question) {
        Scanner scn = new Scanner(System.in);
        String answer;
        System.out.println(question);          //Proposition pour recommencer la parie
        while(true){
            answer = scn.nextLine();
            if(answer.equalsIgnoreCase("oui")){
                break;
            }else if(answer.equalsIgnoreCase("non")){
                break;
            }else{
                System.out.println("Entrez oui ou non");// Tell them to enter yes or no since they entered something else.
            }
        }
        return answer;
    }

    public Object createWarrior(String name) {
        Guerrier warrior = new Guerrier(name);
        warrior.setTypeCharacter("guerrier");
        warrior.characterDefault();
        System.out.println(warrior.toString());
        return warrior;
    }

    public Object createMage(String name) {
        Magicien mage = new Magicien(name);
        mage.setTypeCharacter("magicien");
        mage.characterDefault();
        System.out.println(mage.toString());
        return mage;
    }


}
