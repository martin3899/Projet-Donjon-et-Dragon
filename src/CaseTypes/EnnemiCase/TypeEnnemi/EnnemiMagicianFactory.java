package CaseTypes.EnnemiCase.TypeEnnemi;

import CaseTypes.EnnemiCase.Ennemi;

import java.util.Random;

public class EnnemiMagicianFactory {
    public Ennemi randomEnnemiMagician(){
        Random randomGenerator = new Random();
        int r = randomGenerator.nextInt(5);
        Ennemi ennemi = switch (r){
            case 0 -> new EnnemiMagician(105,"Swain","Destinée. Domination. Duplicité.",500);
            case 1 -> new EnnemiMagician(110,"Elise","La beauté aussi est une force, qui peut frapper plus vivement qu'une épée. ",510);
            case 2 -> new EnnemiMagician(115,"Vex","Mais... pffff.",520);
            case 3 -> new EnnemiMagician(120,"Gwen","Le vent qui caresse mon dos est si agréable. Je ne puis point perdre.",530);
            case 4 -> new EnnemiMagician(125,"Karthus","La mort n'est pas la fin du voyage, ce n'est que le début...",540);
            default -> null;
        };
        return ennemi;
    }
}
