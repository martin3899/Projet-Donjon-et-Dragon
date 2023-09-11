public class EquipementOffensif {
    public String typeWeapon;
    public String nameWeapon;
    public int lvlAtk;

//    public EquipementOffensif(String weapon, String name, int atk){
//        typeWeapon=weapon;
//        nameWeapon=name;
//        lvlAtk=atk;
//    }

    public String getTypeWeapon() {
        return this.typeWeapon;
    }

    public String getNameWeapon() {
        return this.nameWeapon;
    }

    public int getLvlAtk(){
        return  this.lvlAtk;
    }

    public String toString(){
        return "Son équipement offensif: " + typeWeapon + " de nom " + nameWeapon + " et de niveau d'attaque " + lvlAtk + ".";
    }

}
