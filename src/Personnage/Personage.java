package Personnage;

import Equipements.EquipementDefensif;
import Equipements.EquipementOffensif;
import EquipementDefensif.Bouclier;
import EquipementDefensif.Philtre;
import EquipementOffensif.Arme;
import EquipementOffensif.Sort;
import  CaseTypes.Potion;
import  CaseTypes.Ennemi;
public abstract class Personage {
    //Mise en place des attributs
    protected String nameCharacter;
    private String typeCharacter;
    protected int healthPoint;
    protected int offensiveStrength;

    private EquipementOffensif equipementOffensif;
    private EquipementDefensif equipementDefensif;

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

    public void setTypeCharacter(String typeCharacter) {
        this.typeCharacter = typeCharacter;
    }


    //Afficher les caractéristiques du personnage
    public void displayFeatures(){
        if (typeCharacter.equals("guerrier")){
            int setHealthPoint=10;
            int setOffensiveStrength=10;
            healthPoint=setHealthPoint;
            offensiveStrength=setOffensiveStrength;
            Arme arme = new Arme("Arme","Excalibur",100); //Création de l'objet "arme"
            Bouclier bouclier = new Bouclier("Bouclier","Impasse du soleil",100); //Création de l'objet "bouclier"
            equipementOffensif=arme; //On associe l'arme au guerrier
            equipementDefensif=bouclier; //On associe le bouclier au guerrier
        } else {
            int setHealthPoint=6;
            int setOffensiveStrength=15;
            healthPoint=setHealthPoint;
            offensiveStrength=setOffensiveStrength;
            Sort sort = new Sort("Spell","Calcination", 150);  //Création de l'objet "sort"
            Philtre filtre = new Philtre("Philter","Régénération suprême",80);  //Création de l'objet "filtre"
            equipementOffensif=sort;  //On associe le sort au magicien
            equipementDefensif=filtre;  //On associe le filtre au magicien
       }
    }

    public void receivePotion(Potion potion){
        int hp = potion.getHealthValue();
        healthPoint+=hp;
    }

    public void faceEnnemy(Ennemi ennemi){
        int atkDmg = ennemi.getAtkDamage();
        healthPoint-=(atkDmg-equipementDefensif.getLvlDef());
    }

    public void exchangeWeapon(EquipementOffensif equipementOffensif){
        equipementOffensif.getTypeWeapon();
        equipementOffensif.getNameWeapon();
        equipementOffensif.getLvlAtk();
    }

    //Méthode permettant d'afficher les caractéristiques du personnage sous forme de chaine de caractère
    public String toString() {
        return "Le " + typeCharacter + " s'appelle " + nameCharacter + ", il a " + healthPoint + " points de vie et a " + offensiveStrength + " de force d'attaque. " + equipementOffensif + " " + equipementDefensif;
    }
}

