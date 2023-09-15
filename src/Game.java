import CaseTypes.Case;
import CaseTypes.CaseVide;
import CaseTypes.Ennemi;
import CaseTypes.Potion;
import EquipementOffensif.Arme;
import Exceptions.PersonnageHorsPlateauException;
import Personnage.Personage;

import java.util.ArrayList;

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

    public void jouerUnTour(Personage personage, Case cases){
        lancerDe();
        positionJoueur+=lancerDe();
        if (cases.equals(Ennemi)){
            personage.faceEnnemy();
            personage.displayFeatures();
            System.out.println("Prêt à continuer?");
        } else if (cases.equals(Potion)) {
            personage.receivePotion();
            personage.displayFeatures();
            System.out.println("Prêt à continuer?");
        } else if (cases.equals(Arme)) {
            personage.exchangeWeapon();
            personage.displayFeatures();
            System.out.println("Prêt à continuer?");
        }


    }

    public void simplifiedPlateau(){
        plateauDeJeu= new ArrayList<Case>();
        CaseVide emptyCase= new CaseVide();
        plateauDeJeu.add(emptyCase);
        Ennemi ennemy = new Ennemi(10,"Goliath","Etre de pacotille (ou pas...)");
        plateauDeJeu.add(ennemy);
        Arme weapon = new Arme("Arme","Lame du roi déchu",15);
        plateauDeJeu.add(weapon);
        Potion potion= new Potion("Potion de régénération", 4, "Liquide étonnament raffraichissant surement créé par un vieil elfe");
        plateauDeJeu.add(potion);
        System.out.println(plateauDeJeu);
    }
}
