import java.util.Scanner;

public class Menu {

    public void launchGame(){  //Lancement du jeu
        System.out.println("Vous jouez à Donjons & Dragons");
    }
    public void startGame(){  //Début du jeu
        Scanner start = new Scanner(System.in);
        String startGame;
        System.out.println("Voulez-vous modifier le personnage?");     //Propose une modification de personnage
        startGame = start.nextLine();

        if (startGame.equals("oui")){
            Scanner getType = new Scanner(System.in);
            String characterType;
            System.out.println("Entrer le type");                //Propose le type
            characterType = getType.nextLine();

            Scanner getName = new Scanner(System.in);
            String characterName;
            System.out.println("Entrer le nom");                  //Propose le nom
            characterName = getName.nextLine();

            System.out.println("Le personnage est de type " + characterType);
            System.out.println("Le personnage s'appelle " + characterName);

            Personage Warrior = new Personage(characterName,characterType);   //Création du nouveau personnage
            Warrior.displayFeatures(characterType);
            System.out.println(Warrior);

            Scanner confirmation = new Scanner(System.in);
            String confirmationPersonnage;
            System.out.println("Ce personnage vous convient?");      //Confirmation du personnage créé
            confirmationPersonnage = confirmation.nextLine();

            if (confirmationPersonnage.equals("non")){
                startGame();    // On recommence si c'est non
            } else {
                gameplay();     // On joue si c'est oui
            }

        } else {
            gameplay();
        }
    }

    public void gameplay(){ //Partie de jeu
        int position =1;
        System.out.println("Le personnage est sur la case " + position);
        while (position<64){
            int valueDe= (int)(Math.random()*6)+1;   //Lancement du dé
            position += valueDe;   //Mise  à jour de la position
            System.out.println("Le personnage est sur la case " + position);
            if (position>=64){
                System.out.println("Bravo, vous avez gagné!");
            }
        }
        endGame();
    }
    public void endGame(){  //Fin de jeu
        System.out.println("Fin de la partie");

        Scanner restart = new Scanner(System.in);
        String restartGame;
        System.out.println("Voulez-vous recommencer?");          //Proposition pour recommencer la parie
        restartGame= restart.nextLine();

        if (restartGame.equals("oui")){
            startGame();      //Si oui on recommence
            gameplay();
        } else {
            System.out.println("Vous quittez le jeu!"); // Si non on quitte le jeu
        }
    }
}
