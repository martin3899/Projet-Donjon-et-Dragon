package TypePersonnage;

import EquipementDefensif.Philtre;
import EquipementOffensif.Sort;
import Personnage.Personage;

public class Magicien extends Personage {

    private Sort spell;
    private Philtre philter;

    public Magicien(String name) {
        super(name);
    }

    public void displayFeatures() {
        super.characterDefault();
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
