package CaseTypes;

import Personnage.Personage;


public class Potion implements Case{
    private int healthValue;
    private String namePotion;

    private String description;

    public Potion(String name, int regenerationValue, String descriptionPotion){
        namePotion=name;
        healthValue=regenerationValue;
        description=descriptionPotion;
    }

    public int getHealthValue() {
        return healthValue;
    }

    @Override
    public void interact(Personage character) {
        System.out.println("Votre personnage reçoit une potion!");
    }
}
