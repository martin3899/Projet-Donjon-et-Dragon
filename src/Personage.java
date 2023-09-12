import java.util.Scanner;
public class Personage {
    //Mise en place des attributs
    private String nameCharacter;
    private String typeCharacter;
    private int healthPoint;
    private int offensiveStrength;

    private EquipementOffensif equipementOffensif;
    private EquipementDefensif equipementDefensif;


    //Création des 3 constructeurs
    public Personage(){
    }

    public Personage(String name){
        nameCharacter=name;
    }

    public Personage(String name,String type){
        nameCharacter=name;
        typeCharacter=type;
    }

    //Mise en place des setters
    public void setNameCharacter(String nameCharacter) {
        this.nameCharacter = nameCharacter;
    }

    public void setTypeCharacter(String typeCharacter) {
        this.typeCharacter = typeCharacter;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public void setOffensiveStrength(int offensiveStrength) {
        this.offensiveStrength = offensiveStrength;
    }

    public void setEquipementOffensif(EquipementOffensif equipementOffensif) {
        this.equipementOffensif = equipementOffensif;
    }

    public void setEquipementDefensif(EquipementDefensif equipementDefensif) {
        this.equipementDefensif = equipementDefensif;
    }

    //Afficher les caractéristiques du personnage
    public void displayFeatures(String type){
        if (type.equals("Guerrier")){
            int setHealthPoint=10;
            int setOffensiveStrength=10;
            healthPoint=setHealthPoint;
            offensiveStrength=setOffensiveStrength;
            EquipementOffensif arme = new EquipementOffensif("Arme","Excalibur",100); //Création de l'objet "arme"
            EquipementDefensif bouclier = new EquipementDefensif("Bouclier","Impasse du soleil",100); //Création de l'objet "bouclier"
            equipementOffensif= arme; //On associe l'arme au guerrier
            equipementDefensif=bouclier; //On associe le bouclier au guerrier
        } else {
            int setHealthPoint=6;
            int setOffensiveStrength=15;
            healthPoint=setHealthPoint;
            offensiveStrength=setOffensiveStrength;
            EquipementOffensif sort = new EquipementOffensif("Spell","Calcination", 150);  //Création de l'objet "sort"
            EquipementDefensif filtre = new EquipementDefensif("Philter","Régénération suprême",80);  //Création de l'objet "filtre"
            equipementOffensif=sort;  //On associe le sort au magicien
            equipementDefensif=filtre;  //On associe le filtre au magicien
        }
    }

    //Méthode permettant d'afficher les caractéristiques du personnage sous forme de chaine de caractère
    public String toString() {
        return "Le " + typeCharacter + " s'appelle " + nameCharacter + ", il a " + healthPoint + " points de vie et a " + offensiveStrength + " de force d'attaque. " + equipementOffensif + " " + equipementDefensif;

    }
}

