package CaseTypes.EnnemiCase.TypeEnnemi;

import CaseTypes.EnnemiCase.Ennemi;

import java.util.Random;

public class SeigneurFactory {
    public Ennemi randomEnnemiSeigneur(){
        Random randomGenerator = new Random();
        int r = randomGenerator.nextInt(3);
        Ennemi ennemi = switch (r){
            case 0 -> new EnnemiWarrior(140,"Darius","L'histoire ne se souvient que des vainqueurs. Rejoignez Noxus et entrez à jamais dans les mémoires.",700);
            case 1 -> new EnnemiWarrior(145,"Sion","La guerre est éternelle... tout comme moi.",750);
            case 2 -> new EnnemiWarrior(150,"Mordekaiser","Destinée. Domination. Duplicité.",800);
            default -> null;
        };
        return ennemi;
    }
}
