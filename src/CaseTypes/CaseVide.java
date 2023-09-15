package CaseTypes;

import Personnage.Personage;

public class CaseVide implements Case{
    public CaseVide() {
    }

    @Override
    public void interact(Personage character) {
        System.out.println("Vous êtes en sécurité petit veinard");
    }
}
