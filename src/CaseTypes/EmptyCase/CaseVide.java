package CaseTypes.EmptyCase;

import CaseTypes.Case;
import Personnage.Personage;

public class CaseVide implements Case {
    public CaseVide() {
    }

    @Override
    public void interact(Personage character) {
        System.out.println("Vous êtes en sécurité petit veinard");
    }

    public String toString(){
        return "Vous êtes tranquille estimez-vous heureux";
    }
}

