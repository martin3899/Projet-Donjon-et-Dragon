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
import TypePersonnage.Guerrier;
import TypePersonnage.Magicien;

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

    public int jouerUnTour(Personage personage){
        int diceRoll = lancerDe();
        System.out.println("La valeur du dé est " + diceRoll);
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(creationObjects(personage).size());
        Case caseGenerated = (Case) creationObjects(personage).get(index);
        System.out.println("Vous atterissez sur une case " + caseGenerated.getClass().getSimpleName());
        if (caseGenerated.getClass().getSimpleName().equals("Ennemi")){
            generateSpecificCase(caseGenerated,personage);
            plateauDeJeu.add(caseGenerated.getClass().getSimpleName());
        } else if (caseGenerated.getClass().getSimpleName().equals("Potion")) {
            generateSpecificCase(caseGenerated,personage);
            plateauDeJeu.add(caseGenerated.getClass().getSimpleName());
        } else if (caseGenerated.getClass().getSimpleName().equals("Arme")) {
            generateSpecificCase(caseGenerated,personage);
            plateauDeJeu.add(caseGenerated.getClass().getSimpleName());
        } else if (caseGenerated.getClass().getSimpleName().equals("Sort")) {
            generateSpecificCase(caseGenerated,personage);
            plateauDeJeu.add(caseGenerated.getClass().getSimpleName());
        }
        return diceRoll;
    }

    public void generateSpecificCase(Case caseGenerated,Personage personage){
        personage.displayFeaturesUpdate();
        if (caseGenerated.getClass().getSimpleName().equals("Ennemi")) {
            personage.faceEnnemy((Ennemi) creationObjects(personage).get(1));
            System.out.println("L'ennemi vous inflige 3 points de dégats.");
        } else if (caseGenerated.getClass().getSimpleName().equals("Potion")) {
            personage.receivePotion((Potion) creationObjects(personage).get(3));
            System.out.println("La potion vous régénère de 4 points de vie.");
        } else if (caseGenerated.getClass().getSimpleName().equals("Arme")) {
            personage.exchangeWeapon((Arme) creationObjects(personage).get(2));
            System.out.println("Votre arme s'améliore.");
        } else if (caseGenerated.getClass().getSimpleName().equals("Sort")) {
            personage.exchangeSpell((Sort) creationObjects(personage).get(2));
            System.out.println("Votre équipement s'améliore.");
        }
        System.out.println(personage.detailCharacterGame());
    }

    public ArrayList creationObjects(Personage personnage){
        ArrayList<Case> listOfObjects= new ArrayList<Case>();
        CaseVide emptyCase= new CaseVide();
        listOfObjects.add(emptyCase);
        Ennemi ennemy = new Ennemi(103,"Goliath","Etre de pacotille (ou pas...)");
        listOfObjects.add(ennemy);
        if (personnage instanceof Guerrier) {
            Arme weapon = new Arme("Arme", "Lame du roi déchu", 115);
            listOfObjects.add(weapon);
        }
        else {
            Sort spell = new Sort("Sort","Brûlure profonde",165);
            listOfObjects.add(spell);
        }
        Potion potion= new Potion("Potion de régénération", 4, "Liquide étonnament raffraichissant surement créé par un vieil elfe");
        listOfObjects.add(potion);
        return listOfObjects;
    }
}
