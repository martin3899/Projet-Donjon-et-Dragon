package TypePersonnage;
import EquipementDefensif.Bouclier;
import EquipementOffensif.Arme;
import Personnage.Personage;

public class Guerrier extends Personage {

    private Bouclier shield;
    private Arme weapon;
    public Guerrier(String name) {
        super(name);
    }

    public void displayFeatures() {
        super.displayFeatures();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
