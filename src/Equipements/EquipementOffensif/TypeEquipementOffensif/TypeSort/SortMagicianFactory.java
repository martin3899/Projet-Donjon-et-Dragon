package Equipements.EquipementOffensif.TypeEquipementOffensif.TypeSort;

import Equipements.EquipementOffensif.TypeEquipementOffensif.Sort;

import java.util.Random;

public class SortMagicianFactory {
    public Sort randomSortMagician(){
        Random randomGenerator = new Random();
        int r = randomGenerator.nextInt(8);
        Sort sort = switch (r){
            case 0 -> new SortMagician("Sort Magicien","Flamme-ombre",130);
            case 1 -> new SortMagician("Sort Magicien","Tempête de Luden",140);
            case 2 -> new SortMagician("Sort Magicien","Gel éternel",150);
            case 3 -> new SortMagician("Sort Magicien","Etreinte démoniaque",160);
            case 4 -> new SortMagician("Sort Magicien","Fléau de Liche",170);
            case 5 -> new SortMagician("Sort Magicien","Créateur de faille",180);
            case 6 -> new SortMagician("Sort Magicien","Volonté cosmique",190);
            case 7 -> new SortMagician("Sort Magicien","Voleur d'ame de Mejai",200);
            default -> null;
        };
        return sort;
    }
}
