package Personnage;

import Equipements.EquipementDefensif.EquipementDefensif;
import Equipements.EquipementDefensif.TypeEquipementDefensif.Bouclier;
import Equipements.EquipementDefensif.TypeEquipementDefensif.Philtre;
import Equipements.EquipementOffensif.EquipementOffensif;
import Equipements.EquipementOffensif.TypeEquipementOffensif.Arme;
import Equipements.EquipementOffensif.TypeEquipementOffensif.Sort;
import CaseTypes.PotionCase.Potion;
import CaseTypes.EnnemiCase.Ennemi;

/**
 * Cette classe est pour définir un personnage
 * @author martin.vasseur
 */
public abstract class Personage {
    //Mise en place des attributs
    protected String nameCharacter;
    private String typeCharacter;
    protected int healthPoint;
    protected int offensiveStrength;

    private EquipementOffensif equipementOffensif;
    private Equipements.EquipementDefensif.EquipementDefensif equipementDefensif;

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

    public void setTypeCharacter(String typeCharacter) {
        this.typeCharacter = typeCharacter;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public String getTypeCharacter() {
        return typeCharacter;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public int getOffensiveStrength() {
        return offensiveStrength;
    }

    public String getNameCharacter() {
        return nameCharacter;
    }

    public EquipementOffensif getEquipementOffensif() {
        return equipementOffensif;
    }

    public EquipementDefensif getEquipementDefensif() {
        return equipementDefensif;
    }

    /**
     * Cette méthode est pour définir les statistique de combat du personnage en début de partie
     */
    //Afficher les caractéristiques du personnage
    public void characterDefault(){
        if (typeCharacter.equals("guerrier")){
            healthPoint=100;
            offensiveStrength=100;
            displayWeapon("Arme","Excalibur",100);
            displayShield("Bouclier","Impasse du soleil",100); //Création de l'objet "bouclier"
        } else {
            healthPoint=60;
            offensiveStrength=150;
            displaySpell("Spell","Calcination", 100);  //Création de l'objet "sort"
            displayPhilter("Philter","Régénération suprême",100);  //Création de l'objet "filtre"
       }
    }

    /**
     * Cette méthode est pour définir les nouvelles statistiques de combat du personnage après avoir interragis avec un case.
     */
    public void displayFeaturesUpdate(){
        if (typeCharacter.equals("guerrier")){
            offensiveStrength=100;
            displayWeapon(equipementOffensif.getTypeWeapon(),equipementOffensif.getNameWeapon(),equipementOffensif.getLvlAtk());
            displayShield("Bouclier","Impasse du soleil",100); //Création de l'objet "bouclier"
        } else {
            offensiveStrength=150;
            displaySpell(equipementOffensif.getTypeWeapon(),equipementOffensif.getNameWeapon(), equipementOffensif.getLvlAtk());  //Création de l'objet "sort"
            displayPhilter("Philter","Régénération suprême",100);  //Création de l'objet "filtre"
        }
    }

    public void displayWeapon(String typeWeapon, String nameWeapon, int lvlAtk){
        Arme arme = new Arme(typeWeapon,nameWeapon,lvlAtk);
        equipementOffensif=arme;
    }

    public void displayShield(String protectionEquipement, String nameEquipement, int lvlDef){
        Bouclier bouclier = new Bouclier(protectionEquipement,nameEquipement,lvlDef);
        equipementDefensif=bouclier;
    }

    public void displaySpell(String typeWeapon, String nameSpell, int lvlAtk){
        Sort spell = new Sort(typeWeapon,nameSpell,lvlAtk);
        equipementOffensif=spell;
    }

    public void displayPhilter(String protectionEquipement, String nameEquipement, int lvlDef){
        Philtre philter = new Philtre(protectionEquipement,nameEquipement,lvlDef);
        equipementDefensif=philter;
    }


    /**
     * Cette méthode est pour redéfinir les points de vie du personnage après avoir interragis avec une potion
     * @param potion Le type de potion avec lequel le personnage interragis
     * @return Les nouveaux points de vie du personnage
     */

    public int receivePotion(Potion potion){
        int hp = potion.getHealthValue();
        healthPoint+=hp;
        System.out.println("La " + potion.getNamePotion().toLowerCase() + " vous régénère de " + potion.getHealthValue() + " points de vie.");
        return healthPoint;
    }


    public void exchangeEquipementOffensif(EquipementOffensif equipementOffensif){
        displayWeapon(equipementOffensif.getTypeWeapon(), equipementOffensif.getNameWeapon(), equipementOffensif.getLvlAtk());
        System.out.println("Vous débloquez " + equipementOffensif.getNameWeapon() + ". Votre équipement s'améliore.");
    }


    public String detailCharacterGame(){
        return nameCharacter + " à maintenant " + healthPoint + " points de vie et une force d'attaque de " + offensiveStrength + " .Son équipement offensif est: " + equipementOffensif;
    }

    //Méthode permettant d'afficher les caractéristiques du personnage sous forme de chaine de caractère
    public String toString() {
        return "Le " + typeCharacter + " s'appelle " + nameCharacter + ", il a " + healthPoint + " points de vie et a " + offensiveStrength + " de force d'attaque. " + equipementOffensif + " " + equipementDefensif;
    }
}

