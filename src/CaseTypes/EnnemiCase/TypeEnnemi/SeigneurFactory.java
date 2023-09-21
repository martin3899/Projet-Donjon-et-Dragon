package CaseTypes.EnnemiCase.TypeEnnemi;

import CaseTypes.EnnemiCase.Ennemi;

import java.util.Random;

public class SeigneurFactory {
    public Ennemi randomEnnemiSeigneur(){
        Random randomGenerator = new Random();
        int r = randomGenerator.nextInt(3);
        Ennemi ennemi = switch (r){
            case 0 -> new EnnemiWarrior(150,"Darius","L'histoire ne se souvient que des vainqueurs. Rejoignez Noxus et entrez à jamais dans les mémoires.");
            case 1 -> new EnnemiWarrior(160,"Sion","La guerre est éternelle... tout comme moi.");
            case 2 -> new EnnemiWarrior(170,"Mordekaiser","Destinée. Domination. Duplicité.");
            default -> null;
        };
        return ennemi;
    }
}
