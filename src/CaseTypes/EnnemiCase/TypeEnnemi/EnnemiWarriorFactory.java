package CaseTypes.EnnemiCase.TypeEnnemi;

import CaseTypes.Case;
import CaseTypes.EnnemiCase.Ennemi;
import Personnage.Personage;

import java.util.Random;

public class EnnemiWarriorFactory implements Case {
    public static Ennemi randomEnnemiWarrior(){
        Random randomGenerator = new Random();
        int r = randomGenerator.nextInt(5);
        Ennemi ennemi = switch (r){
            case 0 -> new EnnemiWarrior(105,"Kalista","Les renégats, les parjures, les traîtres... Nous les haïssons tous.",500);
            case 1 -> new EnnemiWarrior(110,"Hecarim"," Brisez leurs rangs et piétinez-les jusqu'au dernier. Écrasez les vivants. Repaissez-vous de leur peur.",510);
            case 2 -> new EnnemiWarrior(115,"Thresh","Réduire l'esprit d'un homme en lambeaux est un véritable délice.",520);
            case 3 -> new EnnemiWarrior(120,"Yorick","Ces îles... Elles hurlent de douleur...",530);
            case 4 -> new EnnemiWarrior(125,"Viego","Aucun prix n'est trop lourd, aucune atrocité impossible. Pour elle... je ferais n'importe quoi.",540);
            default -> null;
        };
        return ennemi;
    }

    @Override
    public void interact(Personage character) {

    }
}
