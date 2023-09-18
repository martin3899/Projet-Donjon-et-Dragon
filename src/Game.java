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
    //private String character;
    public Game (){

    }

    public void game() throws PersonnageHorsPlateauException{
        int position = 1;
        System.out.println("Le personnage est sur la case " + position);
        while (position < 64) {
            int valueDe = lancerDe();   //Lancement du dé
            position += valueDe;   //Mise  à jour de la position

            if (position > 64) {
                throw new PersonnageHorsPlateauException(valueDe);
            }
            System.out.println("Le personnage est sur la case " + position);
        }
    }

    public int lancerDe(){
        //return (int) (Math.random() * 6) + 1;
        return 1;
    }

    public ArrayList setPlateauDeJeu(){
        plateauDeJeu= new ArrayList<Case>();
        CaseVide emptyCase= new CaseVide();
        plateauDeJeu.add(emptyCase);
        System.out.println(plateauDeJeu);
        return plateauDeJeu;

    }

    public void jouerUnTour(Personage personage){
        //simplifiedPlateau();
        //for(int i=1; i<=nbCasePlateau; i++) {
            lancerDe();
            positionJoueur += lancerDe();
            Random randomGenerator = new Random();
            int index = randomGenerator.nextInt(creationObjects().size());
            Case caseGenerated = (Case) creationObjects().get(index);
            System.out.println(caseGenerated.getClass().getSimpleName());

            if (caseGenerated.getClass().getSimpleName().equals("Ennemi")){
                personage.displayFeatures();
                personage.faceEnnemy((Ennemi) creationObjects().get(1));
                System.out.println(personage);
                setPlateauDeJeu().add(caseGenerated);
                System.out.println("Prêt à continuer?");
            } else if (caseGenerated.getClass().getSimpleName().equals("Potion")) {
                personage.displayFeatures();
                personage.receivePotion((Potion) creationObjects().get(3));
                System.out.println(personage);
                setPlateauDeJeu().add(caseGenerated);
                System.out.println("Prêt à continuer?");
            } else if (caseGenerated.getClass().getSimpleName().equals("Arme")) {
                personage.displayFeatures();
                personage.exchangeWeapon((Arme) creationObjects().get(2));
                System.out.println(personage);
                setPlateauDeJeu().add(caseGenerated);
                System.out.println("Prêt à continuer?");
            }




    }

    public ArrayList creationObjects(){
        ArrayList<Case> listOfObjects= new ArrayList<Case>();
        CaseVide emptyCase= new CaseVide();
        listOfObjects.add(emptyCase);
        Ennemi ennemy = new Ennemi(103,"Goliath","Etre de pacotille (ou pas...)");
        listOfObjects.add(ennemy);
        Arme weapon = new Arme("Arme","Lame du roi déchu",15);
        listOfObjects.add(weapon);
        Potion potion= new Potion("Potion de régénération", 4, "Liquide étonnament raffraichissant surement créé par un vieil elfe");
        listOfObjects.add(potion);
        //System.out.println(listOfObjects);
        return listOfObjects;
    }
}
