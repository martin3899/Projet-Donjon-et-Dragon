package GameLogic;
import GameLogic.Game;
import CaseTypes.Case;
import CaseTypes.CaseVide;
import CaseTypes.Ennemi;
import CaseTypes.Potion;
import EquipementOffensif.Arme;
import Exceptions.PersonnageHorsPlateauException;
import Personnage.Personage;
import java.util.ArrayList;
import java.util.Random;

public class Game {

    private ArrayList plateauDeJeu;

    private int positionJoueur;

    public Game (){

    }

    public void game(Personage personage) throws PersonnageHorsPlateauException{
        int tourNumero=1;
        //personage.characterDefault();
        setPlateauDeJeu();
        int positionJoueur = 1;
        while (positionJoueur < 64) {
            System.out.println("Tour numéro " + tourNumero);
            positionJoueur+=jouerUnTour(personage);
            System.out.println("Le personnage est sur la case " + positionJoueur);
            if (positionJoueur > 64) {
                throw new PersonnageHorsPlateauException(lancerDe());
            }
            tourNumero++;

        }
        System.out.println(plateauDeJeu);
    }

    public int lancerDe(){
        return (int) (Math.random() * 6) + 1;
    }

    public ArrayList setPlateauDeJeu(){
        plateauDeJeu= new ArrayList<Case>();
        CaseVide emptyCase= new CaseVide();
        plateauDeJeu.add(emptyCase.getClass().getSimpleName());
        return plateauDeJeu;
    }

    public int jouerUnTour(Personage personage){
        int increaseAtkWeapon=0;
        int diceRoll = lancerDe();
        System.out.println("La valeur du dé est " + diceRoll);
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(creationObjects().size());
        Case caseGenerated = (Case) creationObjects().get(index);
        System.out.println("Vous atterissez sur une case " + caseGenerated.getClass().getSimpleName());
        if (caseGenerated.getClass().getSimpleName().equals("Ennemi")){
            personage.displayFeaturesUpdate(increaseAtkWeapon);
            personage.faceEnnemy((Ennemi) creationObjects().get(1));
            System.out.println("L'ennemi vous inflige 3 points de dégats.");
            System.out.println(personage.detailCharacterGame());
            plateauDeJeu.add(caseGenerated.getClass().getSimpleName());
            scannerBoolean("Voulez-vous continuer");
            //System.out.println(plateauDeJeu);
        } else if (caseGenerated.getClass().getSimpleName().equals("Potion")) {
            personage.displayFeaturesUpdate(increaseAtkWeapon);
            personage.receivePotion((Potion) creationObjects().get(3));
            System.out.println("La potion vous régénère de 4 points de vie." /*+ potion.getHealthValue()*/);
            System.out.println(personage.detailCharacterGame());
            plateauDeJeu.add(caseGenerated.getClass().getSimpleName());
            //System.out.println(plateauDeJeu);
        } else if (caseGenerated.getClass().getSimpleName().equals("Arme")) {
            personage.displayFeaturesUpdate(increaseAtkWeapon);
            personage.exchangeWeapon((Arme) creationObjects().get(2));
            System.out.println("Votre arme s'améliore.");
            System.out.println(personage.detailCharacterGame());
            plateauDeJeu.add(caseGenerated.getClass().getSimpleName());
            //System.out.println(plateauDeJeu);
            //increaseAtkWeapon+=1;
        }
        return diceRoll;
    }

    public ArrayList creationObjects(){
        ArrayList<Case> listOfObjects= new ArrayList<Case>();
        CaseVide emptyCase= new CaseVide();
        listOfObjects.add(emptyCase);
        Ennemi ennemy = new Ennemi(103,"Goliath","Etre de pacotille (ou pas...)");
        listOfObjects.add(ennemy);
        Arme weapon = new Arme("Arme","Lame du roi déchu",115);
        listOfObjects.add(weapon);
        Potion potion= new Potion("Potion de régénération", 4, "Liquide étonnament raffraichissant surement créé par un vieil elfe");
        listOfObjects.add(potion);
        return listOfObjects;
    }
}
