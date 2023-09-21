package Equipements.EquipementOffensif.TypeEquipementOffensif.TypeArme;

import CaseTypes.PotionCase.Potion;
import CaseTypes.PotionCase.PotionType.SmallPotion;
import Equipements.EquipementOffensif.TypeEquipementOffensif.Arme;

import java.util.Random;

public class ArmeWarriorFactory {

    public Arme randomArmeWarrior(){
        Random randomGenerator = new Random();
        int r = randomGenerator.nextInt(8);
        Arme arme = switch (r){
            case 0 -> new ArmeWarrior("Arme Guérrier","Lame du roi déchu",130);
            case 1 -> new ArmeWarrior("Arme Guérrier","Epée vespérale de Drakthar",140);
            case 2 -> new ArmeWarrior("Arme Guérrier","Lame d'infini",150);
            case 3 -> new ArmeWarrior("Arme Guérrier","Lance de Shojin",160);
            case 4 -> new ArmeWarrior("Arme Guérrier","Lame Enragée de Guinso",170);
            case 5 -> new ArmeWarrior("Arme Guérrier","Epée vespérale de Drakthar",180);
            case 6 -> new ArmeWarrior("Arme Guérrier","Faux Spectrale",190);
            case 7 -> new ArmeWarrior("Arme Guérrier","Glaive d'ombre",200);
            default -> null;
        };
        return arme;
    }
}
