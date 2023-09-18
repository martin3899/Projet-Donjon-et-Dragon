package CaseTypes;

import Personnage.Personage;

public class Ennemi implements Case{
    private int atkDamage;
    private String nameEnnemy;

    private String descriptionEnemy;

    public Ennemi(int atkDamage, String nameEnnemy, String descriptionEnemy) {
        this.atkDamage = atkDamage;
        this.nameEnnemy = nameEnnemy;
        this.descriptionEnemy = descriptionEnemy;
    }

    public int getAtkDamage() {
        return atkDamage;
    }

    @Override
    public void interact(Personage character) {
        //System.out.println("Votre personnage fait face à un terrible monstre!!!");
    }

    @Override
    public String toString() {
        return "Votre personnage fait face à un terrible monstre!!!";
    }
}
