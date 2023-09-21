package CaseTypes.PotionCase.PotionType;

import CaseTypes.EnnemiCase.Ennemi;
import CaseTypes.EnnemiCase.TypeEnnemi.EnnemiMagician;
import CaseTypes.PotionCase.Potion;

import java.util.Random;

public class SmallPotionFactory {
    public Potion randomSmallPotion(){
        Random randomGenerator = new Random();
        int r = randomGenerator.nextInt(2);
        Potion potion = switch (r){
            case 0 -> new SmallPotion("Potion de soin léger",25,"Restaure 25 ponts de vie.");
            case 1 -> new SmallPotion("Potion de soin concentré",50,"Restaure 50 ponts de vie.");
            default -> null;
        };
        return potion;
    }
}
