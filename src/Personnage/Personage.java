package Personnage;

import Equipements.EquipementDefensif;
import Equipements.EquipementOffensif;
import EquipementDefensif.Bouclier;
import EquipementDefensif.Philtre;
import EquipementOffensif.Arme;
import EquipementOffensif.Sort;
import TypePersonnage.Guerrier;
import TypePersonnage.Magicien;

public abstract class Personage {
    //Mise en place des attributs
    private String nameCharacter;
    private String typeCharacter;
    private int healthPoint;
    private int offensiveStrength;

//    private EquipementOffensif equipementOffensif;
//    private EquipementDefensif equipementDefensif;
    private Guerrier guerrier;
    private Magicien magicien;
    private Bouclier shield;
    private Arme weapon;

    private Sort spell;
    private Philtre philter;


    //Création des 3 constructeurs
    public Personage(){
    }

    public Personage(String name){
        nameCharacter=name;
    }

    public Personage(String name,String type){
        nameCharacter=name;
        typeCharacter=type;
    }

    //Afficher les caractéristiques du personnage
    public void displayFeatures(String type){
        if (type.equals("guerrier")){
            int setHealthPoint=10;
            int setOffensiveStrength=10;
            healthPoint=setHealthPoint;
            offensiveStrength=setOffensiveStrength;
            Arme arme = new Arme("Arme","Excalibur",100); //Création de l'objet "arme"
            Bouclier bouclier = new Bouclier("Bouclier","Impasse du soleil",100); //Création de l'objet "bouclier"
            weapon= arme; //On associe l'arme au guerrier
            shield=bouclier; //On associe le bouclier au guerrier
        } else {
            int setHealthPoint=6;
            int setOffensiveStrength=15;
            healthPoint=setHealthPoint;
            offensiveStrength=setOffensiveStrength;
            Sort sort = new Sort("Spell","Calcination", 150);  //Création de l'objet "sort"
            Philtre filtre = new Philtre("Philter","Régénération suprême",80);  //Création de l'objet "filtre"
            spell=sort;  //On associe le sort au magicien
            philter=filtre;  //On associe le filtre au magicien
       }
    }

    //Méthode permettant d'afficher les caractéristiques du personnage sous forme de chaine de caractère
    public String toString(String type) {
        if (type.equals("guerrier")) {
            return "Le "+ type + " s'appelle " + nameCharacter + ", il a " + healthPoint + " points de vie et a " + offensiveStrength + " de force d'attaque. " + weapon + " " + shield;
        } else {
            return "Le "+ type +" s'appelle " + nameCharacter + ", il a " + healthPoint + " points de vie et a " + offensiveStrength + " de force d'attaque. " + spell + " " + philter;
        }

    }
}

