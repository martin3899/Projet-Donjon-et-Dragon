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
    public void characterDefault(){
        if (typeCharacter.equals("guerrier")){
            healthPoint=10;
            offensiveStrength=10;
            displayWeapon("Arme","Excalibur",100);
            displayShield("Bouclier","Impasse du soleil",100); //Création de l'objet "bouclier"
        } else {
            healthPoint=6;
            offensiveStrength=15;
            displaySpell("Spell","Calcination", 150);  //Création de l'objet "sort"
            displayPhilter("Philter","Régénération suprême",80);  //Création de l'objet "filtre"
       }
    }

    public void displayFeaturesUpdate(int increaseAtkWeapon){
        if (typeCharacter.equals("guerrier")){
            offensiveStrength=10;
            displayWeapon("Arme","Lame du roi déchu",115+increaseAtkWeapon*5);
            displayShield("Bouclier","Impasse du soleil",100); //Création de l'objet "bouclier"
        } else {
            offensiveStrength=15;
            displaySpell("Spell","Calcination", 150);  //Création de l'objet "sort"
            displayPhilter("Philter","Régénération suprême",80);  //Création de l'objet "filtre"
        }
    }

    public void displayWeapon(String typeWeapon, String nameWeapon, int lvlAtk){
        Arme arme = new Arme(typeWeapon,nameWeapon,lvlAtk);
        equipementOffensif=arme;
    }

    public void displayShield(String protectionEquipement, String nameEquipement, int lvlDef){
        Bouclier bouclier = new Bouclier(protectionEquipement,nameEquipement,lvlDef);
        equipementDefensif=bouclier;
    }

    public void displaySpell(String typeWeapon, String nameSpell, int lvlAtk){
        Sort spell = new Sort(typeWeapon,nameSpell,lvlAtk);
        equipementOffensif=spell;
    }

    public void displayPhilter(String protectionEquipement, String nameEquipement, int lvlDef){
        Philtre philter = new Philtre(protectionEquipement,nameEquipement,lvlDef);
        equipementDefensif=philter;
    }



    public int receivePotion(Potion potion){
        int hp = potion.getHealthValue();
        healthPoint+=hp;
        return healthPoint;
    }

    public void faceEnnemy(Ennemi ennemi){
        int atkDmg = ennemi.getAtkDamage();
        healthPoint-=(atkDmg-equipementDefensif.getLvlDef());
    }

    public void exchangeWeapon(EquipementOffensif equipementOffensif){
        displayWeapon(equipementOffensif.getTypeWeapon(), equipementOffensif.getNameWeapon(), equipementOffensif.getLvlAtk());
    }
    public String detailCharacterGame(){
        return nameCharacter + " à maintenant " + healthPoint + " points de vie et une force d'attaque de " + offensiveStrength + " .Son équipement offensif est: " + equipementOffensif;
    }

    //Méthode permettant d'afficher les caractéristiques du personnage sous forme de chaine de caractère
    public String toString() {
        return "Le " + typeCharacter + " s'appelle " + nameCharacter + ", il a " + healthPoint + " points de vie et a " + offensiveStrength + " de force d'attaque. " + equipementOffensif + " " + equipementDefensif;
    }
}

