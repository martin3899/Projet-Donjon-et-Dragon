package CaseTypes.PotionCase;

import CaseTypes.Case;
import Personnage.Personage;


public class Potion implements Case {
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

    public String getNamePotion() {
        return namePotion;
    }

    @Override
    public void interact(Personage character) {
        System.out.println("Votre personnage reçoit une potion!");
//        character.setHealthPoint(character.getHealthPoint()+this.getHealthValue());
        //name character.receivePotion(this);
    }

    @Override
    public String toString() {
        return "Votre personnage reçoit une potion!";
    }
}
