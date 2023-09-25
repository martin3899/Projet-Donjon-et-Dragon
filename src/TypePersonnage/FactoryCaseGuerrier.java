package TypePersonnage;

import CaseTypes.Case;
import CaseTypes.EmptyCase.CaseVide;
import CaseTypes.EnnemiCase.Ennemi;
import CaseTypes.EnnemiCase.TypeEnnemi.EnnemiMagician;
import CaseTypes.EnnemiCase.TypeEnnemi.EnnemiWarriorFactory;
import CaseTypes.EnnemiCase.TypeEnnemi.SeigneurFactory;
import CaseTypes.PotionCase.Potion;
import CaseTypes.PotionCase.PotionType.BigPotionFactory;
import CaseTypes.PotionCase.PotionType.SmallPotion;
import CaseTypes.PotionCase.PotionType.SmallPotionFactory;
import Equipements.EquipementOffensif.EquipementOffensif;
import Equipements.EquipementOffensif.TypeEquipementOffensif.Arme;
import Equipements.EquipementOffensif.TypeEquipementOffensif.TypeArme.ArmeWarriorFactory;
import Personnage.Personage;

import java.util.ArrayList;
import java.util.Random;

public class FactoryCaseGuerrier implements Factory{


    @Override
    public Personage createPersonnage(String name) {
        return new Guerrier(name);
    }

    @Override
    public EquipementOffensif createEquipementOffensiff() {
        ArmeWarriorFactory armeFactory = new ArmeWarriorFactory();
        Arme arme = armeFactory.randomArmeWarrior();
        return arme;
    }

    @Override
    public Ennemi createEnnemi(int position) {
        if (position<45) {
            EnnemiWarriorFactory ennemiFactory = new EnnemiWarriorFactory();
            Ennemi ennemi = ennemiFactory.randomEnnemiWarrior();
            return ennemi;
        }  else {
            SeigneurFactory seigneurFactory = new SeigneurFactory();
            Ennemi ennemi =seigneurFactory.randomEnnemiSeigneur();
            return ennemi;
        }
    }

    @Override
    public Potion createPotion(int position) {
        if (position<45) {
            SmallPotionFactory smallPotionFactory = new SmallPotionFactory();
            Potion potion = smallPotionFactory.randomSmallPotion();
            return potion;
        } else {
            BigPotionFactory smallPotionFactory = new BigPotionFactory();
            Potion potion = smallPotionFactory.randomBigPotion();
            return potion;
        }
    }

    @Override
    public CaseVide createCaseVide() {
        return new CaseVide();
    }
//    public ArrayList caseGuerrier(){
//        ArrayList<Case> listOfObjects= new ArrayList<Case>();
//        for (int i=0;i<4;i++) {
//            switch (i) {
//                case 0:
//                    CaseVide emptyCase = new CaseVide();
//                    listOfObjects.add(emptyCase);
//                case 1:
//                    EnnemiWarriorFactory ennemiFactory = new EnnemiWarriorFactory();
//                    Ennemi ennemi = ennemiFactory.randomEnnemiWarrior();
//                    listOfObjects.add(ennemi);
//                case 2:
//                    ArmeWarriorFactory armeFactory = new ArmeWarriorFactory();
//                    Arme arme = armeFactory.randomArmeWarrior();
//                    listOfObjects.add(arme);
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

