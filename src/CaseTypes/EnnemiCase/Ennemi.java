package CaseTypes.EnnemiCase;

import CaseTypes.Case;
import Personnage.Personage;

public class Ennemi implements Case {
    private int atkDamage;
    private String nameEnnemy;

    private String descriptionEnemy;
    private int healthPoint;

    public Ennemi(int atkDamage, String nameEnnemy, String descriptionEnemy, int healthPoint) {
        this.atkDamage = atkDamage;
        this.nameEnnemy = nameEnnemy;
        this.descriptionEnemy = descriptionEnemy;
        this.healthPoint = healthPoint;
    }

    public int getAtkDamage() {
        return atkDamage;
    }

    public String getNameEnnemy() {
        return nameEnnemy;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public String getDescriptionEnemy() {
        return descriptionEnemy;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    @Override
    public void interact(Personage character) {
    }

    @Override
    public String toString() {
        return "Votre personnage fait face à un terrible monstre!!!";
    }
}
