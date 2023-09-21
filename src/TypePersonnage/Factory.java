package TypePersonnage;

import CaseTypes.EmptyCase.CaseVide;
import CaseTypes.EnnemiCase.Ennemi;
import CaseTypes.PotionCase.Potion;
import Equipements.EquipementOffensif.EquipementOffensif;
import Personnage.Personage;

public interface Factory {
    Personage createPersonnage(String name);
    EquipementOffensif createEquipementOffensiff();

    Ennemi createEnnemi();

    Potion createPotion();

    CaseVide createCaseVide();
}
