package CaseTypes.PotionCase.PotionType;

import CaseTypes.PotionCase.Potion;

import java.util.Random;

public class BigPotionFactory {
    public Potion randomBigPotion(){
        Random randomGenerator = new Random();
        int r = randomGenerator.nextInt(2);
        Potion potion = switch (r){
            case 0 -> new SmallPotion("Potion de soin intense",75,"Restaure 75 ponts de vie.");
            case 1 -> new SmallPotion("Potion de soin suprême",100,"Restaure 100 ponts de vie.");
            default -> null;
        };
        return potion;
    }
}
