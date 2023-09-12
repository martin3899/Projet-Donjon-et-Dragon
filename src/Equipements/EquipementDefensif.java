package Equipements;

public abstract class EquipementDefensif {

    //Mise en place des attibuts
    private String protectionEquipement;
    private int lvlDef;
    private String nameEquipement;

    //Création du constructeur
    public EquipementDefensif(String protection, String name, int def){
        protectionEquipement=protection;
        nameEquipement=name;
        lvlDef=def;
    }

    //Mise en place des setters
    public void setProtectionEquipement(String protectionEquipement) {
        this.protectionEquipement = protectionEquipement;
    }

    public void setNameEquipement(String nameEquipement) {
        this.nameEquipement = nameEquipement;
    }

    public void setLvlDef(int lvlDef) {
        this.lvlDef = lvlDef;
    }

    //Méthode permettant d'afficher les caractéristiques de l'équipement défensif sous forme de chaine de caractère

    public String toString(){
        return "Son équipement défensif: " + protectionEquipement + " de nom " + nameEquipement + " et de niveau de défense " + lvlDef + ".";
    }

}
