package GameLogic;
import CaseTypes.Case;
import CaseTypes.EmptyCase.CaseVide;
import CaseTypes.EnnemiCase.Ennemi;
import CaseTypes.PotionCase.Potion;
import Equipements.EquipementOffensif.EquipementOffensif;
import Equipements.EquipementOffensif.TypeEquipementOffensif.Arme;
import Equipements.EquipementOffensif.TypeEquipementOffensif.Sort;
import Exceptions.PersonnageHorsPlateauException;
import Personnage.Personage;
import TypePersonnage.AbstractFactory;
import TypePersonnage.Factory;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    private ArrayList plateauDeJeu;

    private int positionJoueur;

    public Game (){

    }

    public void game(String characterType, Personage personage) throws PersonnageHorsPlateauException{
        int tourNumero=1;
        //personage.characterDefault();
        setPlateauDeJeu();
        int positionJoueur = 1;
        while (positionJoueur < 64) {
            System.out.println("Tour numéro " + tourNumero);
            positionJoueur+=jouerUnTour(characterType,personage);
            System.out.println("Le personnage est sur la case " + positionJoueur);
            Menu menu= new Menu();
            String continuer = menu.scannerBoolean("Voulez-vous continuer?");
            if (continuer.equals("non")){
                menu.endGame();
                break;
            }
            if (positionJoueur > 64) {
                throw new PersonnageHorsPlateauException(lancerDe());
            }
            tourNumero++;
        }
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

    public int jouerUnTour(String characterType,Personage personnage){
        int diceRoll = lancerDe();
        System.out.println("La valeur du dé est " + diceRoll);
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(creationObjects(characterType).size());
        Case caseGenerated = (Case) creationObjects(characterType).get(index);
        System.out.println("Vous atterissez sur une case " + caseGenerated.getClass().getSimpleName());
        if (caseGenerated.getClass().getSimpleName().equals("Ennemi")){
            plateauDeJeu.add(caseGenerated.getClass().getSimpleName());
        } else if (caseGenerated.getClass().getSimpleName().equals("Potion")) {
            plateauDeJeu.add(caseGenerated.getClass().getSimpleName());
        } else if (caseGenerated.getClass().getSimpleName().equals("EquipementOffensif")) {
            plateauDeJeu.add(caseGenerated.getClass().getSimpleName());
        }
        generateSpecificCase(caseGenerated,characterType,personnage);
        return diceRoll;
    }

    public void generateSpecificCase(Case caseGenerated, String characterType, Personage personage){
        personage.displayFeaturesUpdate();
        if (caseGenerated.getClass().getSimpleName().equals("Ennemi")) {
            personage.faceEnnemy((Ennemi) creationObjects(characterType).get(1));
            System.out.println("L'ennemi vous inflige 3 points de dégats.");
        } else if (caseGenerated.getClass().getSimpleName().equals("Potion")) {
            personage.receivePotion((Potion) creationObjects(characterType).get(3));
            System.out.println("La potion vous régénère de 4 points de vie.");
        } else if (caseGenerated.getClass().getSimpleName().equals("EquipementOffensif")) {
            personage.exchangeEquipementOffensif((EquipementOffensif) creationObjects(characterType).get(2));
            System.out.println("Votre arme s'améliore.");
        }
        System.out.println(personage.detailCharacterGame());
    }

    public ArrayList creationObjects(String type){
        Factory factory = AbstractFactory.createFactory(type);
        ArrayList<Case> listOfObjects= new ArrayList<Case>();
        listOfObjects.add(factory.createCaseVide());
        listOfObjects.add(factory.createEnnemi());
        listOfObjects.add(factory.createEquipementOffensiff());
        listOfObjects.add(factory.createPotion());
        return listOfObjects;
    }
}
