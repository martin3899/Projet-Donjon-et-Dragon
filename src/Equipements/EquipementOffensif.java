package Equipements;

import CaseTypes.Case;
import Personnage.Personage;

public abstract class EquipementOffensif implements Case {

    //Mise en place des attibuts
    private String typeWeapon;
    private String nameWeapon;
    private int lvlAtk;

    //Création du constructeur
    public EquipementOffensif(String weapon, String name, int atk){
        typeWeapon=weapon;
        nameWeapon=name;
        lvlAtk=atk;
    }

    //Mise en place des setters


    public String getTypeWeapon() {
        return typeWeapon;
    }

    public String getNameWeapon() {
        return nameWeapon;
    }

    public int getLvlAtk() {
        return lvlAtk;
    }

    public void setTypeWeapon(String typeWeapon) {
        this.typeWeapon = typeWeapon;
    }

    public void setNameWeapon(String nameWeapon) {
        this.nameWeapon = nameWeapon;
    }

    public void setLvlAtk(int lvlAtk) {
        this.lvlAtk = lvlAtk;
    }

    @Override
    public void interact(Personage character) {
        System.out.println("Incroyable un nouvel equipement offensif! Merci pour le coup de pouce!");
    }

    //Méthode permettant d'afficher les caractéristiques de l'équipement offensif sous forme de chaine de caractère
    public String toString(){
        return "Son équipement offensif: " + typeWeapon + " de nom " + nameWeapon + " et de niveau d'attaque " + lvlAtk + ".";
    }

}
