package TypePersonnage;
import Equipements.EquipementDefensif.TypeEquipementDefensif.Bouclier;
import Equipements.EquipementOffensif.TypeEquipementOffensif.Arme;
import Personnage.Personage;

public class Guerrier extends Personage {

    private Bouclier shield;
    private Arme weapon;
    public Guerrier(String name) {
        super(name,"guerrier");
    }

    public void displayFeatures() {
        super.characterDefault();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
