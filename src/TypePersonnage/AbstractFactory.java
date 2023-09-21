package TypePersonnage;

public class AbstractFactory {

    public static Factory createFactory(  String type  ){
        if ( type.equals("guerrier")) {
            return new FactoryCaseGuerrier();
        }
        else if ( type.equals("magicien")) {
            return new FactoryCaseMagicien();
        }
        else {
            return null;
        }
    }
}
