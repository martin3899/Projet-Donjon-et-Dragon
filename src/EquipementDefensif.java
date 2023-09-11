public class EquipementDefensif {
    String protectionEquipement;
    int lvlDef;
    String nameEquipement;

//    public EquipementDefensif(String protection, String name, int def){
//        protectionEquipement=protection;
//        nameEquipement=name;
//        lvlDef=def;
//    }

    public String getProtectionEquipement() {
        return this.protectionEquipement;
    }

    public String getNameEquipement() {
        return this.nameEquipement;
    }

    public int getLvlDef(){
        return  this.lvlDef;
    }

    public String toString(){
        return "Son équipement défensif: " + protectionEquipement + " de nom " + nameEquipement + " et de niveau de défense " + lvlDef + ".";
    }

}
