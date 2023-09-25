package GameLogic;

import CaseTypes.EnnemiCase.Ennemi;
import Equipements.EquipementDefensif.EquipementDefensif;
import Equipements.EquipementOffensif.EquipementOffensif;
import Personnage.Personage;

public class Fights {
    private Game game;

    public Fights(Game game) {
        this.game = game;
    }


    public void fightEnnemi(Ennemi ennemi, Personage personage) {
        System.out.println(ennemi.getNameEnnemy() + " a " + ennemi.getAtkDamage() + " points d'attaque et " + ennemi.getHealthPoint() + " points de vie.");
        System.out.println("'" + ennemi.getDescriptionEnemy() + "'");
        System.out.println("Le combat commence...");
        Menu menu = new Menu();

        while (ennemi.getHealthPoint() > 0 && personage.getHealthPoint() > 0 ) {

            String AskLeaveFight = menu.scannerBoolean("Voulez-vous fuir?").toLowerCase();
            if (AskLeaveFight.equals("non")) {
                jouerUntour(ennemi, personage);
            } else {
                int rollDice = game.lancerDe();
                System.out.println("Vous recullez de " + rollDice + " cases.");
                int newPositionJoueur = game.getPositionJoueur() - rollDice;
                game.setPositionJoueur(newPositionJoueur);
                System.out.println("Vous êtes maintenant sur la case " + newPositionJoueur);
                break;
            }
        }
    }

    public void jouerUntour(Ennemi ennemi, Personage personage) {
        int dmgPerso = personage.getOffensiveStrength() + personage.getEquipementOffensif().getLvlAtk();
        System.out.println("Vous attaquez de " + dmgPerso + ".");
        int hpEnnemi = ennemi.getHealthPoint() - dmgPerso;
        ennemi.setHealthPoint(hpEnnemi);
        System.out.println(ennemi.getNameEnnemy() + " a maintenant " + hpEnnemi + " points de vie.");
        if (hpEnnemi >= 0) {
            int dmgEnnemi = ennemi.getAtkDamage() - personage.getEquipementDefensif().getLvlDef();
            System.out.println(ennemi.getNameEnnemy() + " vous attaque de " + dmgEnnemi + ".");
            int hpPerso = personage.getHealthPoint() - dmgEnnemi;
            System.out.println(personage.getNameCharacter() + " a maintenant " + hpPerso + " points de vie.");
            personage.setHealthPoint(hpPerso);
            ennemi.setHealthPoint(hpEnnemi);
        } else {
            System.out.println("L'ennemi est mort.");
        }
    }
}
