import java.text.*;
import java.io.*;
import java.util.*;
import java.lang.*;


class Game {
    String mode;
    String level;
    Ocean ocean1 = new Ocean();
    Ocean ocean2 = new Ocean();


    private void startGame() {

        switch (mode) {
            case "1":
                ocean1.setShips(false);
                ocean2.setShips(false);
            break;
            case "2":
                ocean1.setShips(true);
                ocean2.setShips(true);
            break;
            case "3":
                ocean1.setShips(true);
                ocean2.setShips(true);
            break;
            default:
                System.out.println("There's no such option");
        }
    }

    private void playGame() {
        View view = new View();
        Boolean isComputer1 = null;
        Boolean isComputer2 = null;

        switch (mode) {
            case "1":
                isComputer1 = false;
                isComputer2 = false;
            break;
            case "2":
                isComputer1 = false;
                isComputer2 = true;
            break;
            case "3":
                isComputer1 = true;
                isComputer2 = true;
            break;
            default:
                System.out.println("There's no such option");
        }

        do {
            do{
                view.displayBoards(ocean1, ocean2);
                
            } while(ocean2.getShot(isComputer1));

            do{
                view.displayBoards(ocean1, ocean2);
            } while(ocean1.getShot(isComputer2));
        } while (!this.isWon());
        
    }

    public Boolean isWon () {
        return false; //TODO
    }


    public static void main (String [] args) {
        Game myGame = new Game();
        View view = new View();

        String mode;
        do {
            view.printMenu();
            myGame.mode = view.askUser("How would you like to play??");
            view.printSubmenu();
            myGame.level = view.askUser("How would you like to play??");
            myGame.startGame();
            myGame.playGame();
        } while (!myGame.level.equals("4"));

    }
}