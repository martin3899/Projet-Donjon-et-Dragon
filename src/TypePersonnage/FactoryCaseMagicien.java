package TypePersonnage;

import CaseTypes.Case;
import CaseTypes.EmptyCase.CaseVide;
import CaseTypes.EnnemiCase.Ennemi;
import CaseTypes.EnnemiCase.TypeEnnemi.EnnemiMagicianFactory;
import CaseTypes.EnnemiCase.TypeEnnemi.EnnemiWarriorFactory;
import CaseTypes.PotionCase.Potion;
import CaseTypes.PotionCase.PotionType.SmallPotionFactory;
import Equipements.EquipementOffensif.EquipementOffensif;
import Equipements.EquipementOffensif.TypeEquipementOffensif.Arme;
import Equipements.EquipementOffensif.TypeEquipementOffensif.Sort;
import Equipements.EquipementOffensif.TypeEquipementOffensif.TypeArme.ArmeWarriorFactory;
import Equipements.EquipementOffensif.TypeEquipementOffensif.TypeSort.SortMagicianFactory;
import Personnage.Personage;

import java.util.ArrayList;

public class FactoryCaseMagicien implements Factory{
    @Override
    public Personage createPersonnage(String name) {
        return new Magicien(name);
    }

    @Override
    public EquipementOffensif createEquipementOffensiff() {
        SortMagicianFactory sortFactory = new SortMagicianFactory();
        Sort sort = sortFactory.randomSortMagician();
        return sort;
    }

    @Override
    public Ennemi createEnnemi() {
        EnnemiMagicianFactory ennemiFactory = new EnnemiMagicianFactory();
        Ennemi ennemi = ennemiFactory.randomEnnemiMagician();
        return ennemi;
    }

    @Override
    public Potion createPotion() {
        SmallPotionFactory smallPotionFactory = new SmallPotionFactory();
        Potion potion = smallPotionFactory.randomSmallPotion();
        return potion;
    }

    @Override
    public CaseVide createCaseVide() {
        return new CaseVide();
    }


//    public ArrayList caseMagicien(){
//        ArrayList<Case> listOfObjects= new ArrayList<Case>();
//        for (int i=0;i<4;i++) {
//            switch (i) {
//                case 0:
//                    CaseVide emptyCase = new CaseVide();
//                    listOfObjects.add(emptyCase);
//                case 1:
//                    EnnemiMagicianFactory ennemiFactory = new EnnemiMagicianFactory();
//                    Ennemi ennemi = ennemiFactory.randomEnnemiMagician();
//                    listOfObjects.add(ennemi);
//                case 2:
//                    SortMagicianFactory armeFactory = new SortMagicianFactory();
//                    Sort sort = armeFactory.randomSortMagician();
//                    listOfObjects.add(sort);
//                case 3:
//                    SmallPotionFactory smallPotionFactory = new SmallPotionFactory();
//                    Potion potion = smallPotionFactory.randomSmallPotion();
//                    listOfObjects.add(potion);
//            }
//
//        }
//        return listOfObjects;
//    }
}
