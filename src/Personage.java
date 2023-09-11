import java.util.Scanner;
public class Personage {
    public String nameCharacter;
    public String typeCharacter;
    public int healthPoint;
    public int offensiveStrength;

    public EquipementOffensif equipementOffensif;
    public EquipementDefensif equipementDefensif;

    public Personage(){
    }

    public Personage(String name){
        nameCharacter=name;
    }

    public Personage(String name,String type){
        nameCharacter=name;
        typeCharacter=type;
    }

    public void displayFeatures(String type){
        if (type.equals("Guerrier")){
            int setHealthPoint=10;
            int setOffensiveStrength=10;
            healthPoint=setHealthPoint;
            offensiveStrength=setOffensiveStrength;
            EquipementOffensif Arme = new EquipementOffensif();
            EquipementDefensif Bouclier = new EquipementDefensif();
            Arme.typeWeapon="Arme";
            Arme.nameWeapon="Excalibur";
            Arme.lvlAtk=100;
            Bouclier.protectionEquipement="Bouclier";
            Bouclier.nameEquipement="Impasse du soleil";
            Bouclier.lvlDef=100;

        }
        else {
            int setHealthPoint=6;
            int setOffensiveStrength=15;
            healthPoint=setHealthPoint;
            offensiveStrength=setOffensiveStrength;
            EquipementOffensif Sort = new EquipementOffensif();
            EquipementDefensif Philter = new EquipementDefensif();
            Sort.typeWeapon="Spell";
            String typeWeapon = Sort.getTypeWeapon();
            Sort.nameWeapon="Calcination";
            Sort.lvlAtk=150;
            Philter.protectionEquipement="Philter";
            Philter.nameEquipement="Régénération suprême";
            Philter.lvlDef=80;
        }
    }

    public String toString() {
        return "Le " + typeCharacter + " s'appelle " + nameCharacter + ", il a " + healthPoint + " points de vie et a " + offensiveStrength + " de force d'attaque." + equipementOffensif + equipementDefensif;

    }
    public static void main(String[] args){
        Scanner getType = new Scanner(System.in);
        String characterType;
        System.out.println("Entrer le type");
        characterType= getType.nextLine();

        Scanner getName = new Scanner(System.in);
        String characterName;
        System.out.println("Entrer le nom");
        characterName= getName.nextLine();

        System.out.println("Le personnage est de type " + characterType);
        System.out.println("Le personnage s'appelle " + characterName);

        Personage Warrior = new Personage(characterName,characterType);
        Warrior.displayFeatures(characterType);
        System.out.println(Warrior);


    }
}

