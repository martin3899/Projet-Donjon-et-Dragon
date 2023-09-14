import Exceptions.PersonnageHorsPlateauException;

public class Game {

    //private String character;
    public Game (){

    }

    public void game() throws PersonnageHorsPlateauException{
        int position = 1;
        System.out.println("Le personnage est sur la case " + position);
        while (position < 64) {
            int valueDe = lancerDe();   //Lancement du dé
            position += valueDe;   //Mise  à jour de la position

            if (position > 64) {
                throw new PersonnageHorsPlateauException(valueDe);
                //position-=valueDe;
//                } catch(PersonnageHorsPlateauException e) {
//                    System.out.println("Vous revenez à la position initiale!");
//                    position -= valueDe;
//                }
            }

            System.out.println("Le personnage est sur la case " + position);
        }
    }

    public int lancerDe(){
        return (int) (Math.random() * 6) + 1;
    }
}
