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

/**
 * Cette classe permet de générer la partie de jeu
 * @author martin.vasseur
 */

public class Game {

    private ArrayList plateauDeJeu;

    private int positionJoueur;



    public Game (){

    }

    public int getPositionJoueur() {
        return positionJoueur;
    }

    public void setPositionJoueur(int positionJoueur) {
        this.positionJoueur = positionJoueur;
    }

    /**
     * Cette méthode permet de générer la partie tour par tour
     * @param characterType type du personnage
     * @param personage le personage choisi
     * @throws PersonnageHorsPlateauException Lorsque le joueur sort du plateau
     */
    public void game(String characterType, Personage personage) throws PersonnageHorsPlateauException{
        int tourNumero=1;
        //personage.characterDefault();
        setPlateauDeJeu();
        positionJoueur = 1;
        while (positionJoueur < 64 && personage.getHealthPoint()>0) {
            System.out.println("Tour numéro " + tourNumero);
            int diceRoll = lancerDe();
            System.out.println("La valeur du dé est " + diceRoll);
            positionJoueur+=diceRoll;
            System.out.println("Le personnage est sur la case " + positionJoueur);
            jouerUnTour(characterType,personage);
            Menu menu= new Menu();
            String continuer = menu.scannerBoolean("Voulez-vous continuer?");
            if (continuer.equals("non")){
                menu.endGame();
                break;
            }
            if (positionJoueur > 64) {
                throw new PersonnageHorsPlateauException(diceRoll);
            }
            tourNumero++;
        }
    }

    /**
     * Cette méthode permet de lancer les dés en générant un nombre aléatoire entre 0 et 6
     * @return La valeur du dé
     */
    public int lancerDe(){
        return (int) (Math.random() * 6) + 1;
    }

    /**
     * Génère le plateau de jeu en début de partie
     * @return Le plateau de jeu généré
     */

    public ArrayList setPlateauDeJeu(){
        plateauDeJeu= new ArrayList<Case>();
        CaseVide emptyCase= new CaseVide();
        plateauDeJeu.add(emptyCase.getClass().getSimpleName());
        return plateauDeJeu;
    }

    /**
     * Cette méthode montre le déroulement d'un tour
     * @param characterType Le type du personnage
     * @param personnage Le personnage choisi
     */
    public void jouerUnTour(String characterType,Personage personnage){
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
    }

    /**
     * Cette méthode permet de générer une case et de faire l'interaction entre celle-ci et le personnage
     * @param caseGenerated type de case générée
     * @param characterType type du personnage
     * @param personage personnage joué
     */

    public void generateSpecificCase(Case caseGenerated, String characterType, Personage personage){
        personage.displayFeaturesUpdate();
        if (caseGenerated.getClass().getSimpleName().equals("EnnemiWarrior") || caseGenerated.getClass().getSimpleName().equals("EnnemiMagician")) {
//            personage.faceEnnemy((Ennemi) creationObjects(characterType).get(1));
            Fights fight = new Fights(this);
            fight.fightEnnemi((Ennemi) creationObjects(characterType).get(1),personage);
        } else if (caseGenerated.getClass().getSimpleName().equals("SmallPotion") || caseGenerated.getClass().getSimpleName().equals("BigPotion")) {
            personage.receivePotion((Potion) creationObjects(characterType).get(3));
        } else if (caseGenerated.getClass().getSimpleName().equals("ArmeWarrior") || caseGenerated.getClass().getSimpleName().equals("SortMagician")) {
            personage.exchangeEquipementOffensif((EquipementOffensif) creationObjects(characterType).get(2));
        }
        System.out.println(personage.detailCharacterGame());
    }

    /**
     * Génère aléatoirement des objets venant des usines à objets
     * @param type type du personnage
     * @return l'usine d'objet pour le type de personnage choisi
     */

    public ArrayList creationObjects(String type){
        Factory factory = AbstractFactory.createFactory(type);
        ArrayList<Case> listOfObjects= new ArrayList<Case>();
        listOfObjects.add(factory.createCaseVide());
        listOfObjects.add(factory.createEnnemi(positionJoueur));
        listOfObjects.add(factory.createEquipementOffensiff());
        listOfObjects.add(factory.createPotion(positionJoueur));
        return listOfObjects;
    }
}
