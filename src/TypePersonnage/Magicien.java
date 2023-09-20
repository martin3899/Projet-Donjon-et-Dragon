package TypePersonnage;

import Equipements.EquipementDefensif.TypeEquipementDefensif.Philtre;
import Equipements.EquipementOffensif.TypeEquipementOffensif.Sort;
import Personnage.Personage;

public class Magicien extends Personage {

    private Sort spell;
    private Philtre philter;

    public Magicien(String name) {
        super(name,"magicien");
    }

    public void displayFeatures() {
        super.characterDefault();
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
