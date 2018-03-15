import java.text.*;
import java.io.*;
import java.util.*;
import java.lang.*;


class Game {
    String mode;
    String level;
    Ocean ocean1 = new Ocean();
    Ocean ocean2 = new Ocean();
    View view = new View();


    private void startGame() {
        Integer number = 0;
        if (this.level.equals("3")) {
            number = Integer.parseInt(view.askUser("How many bombs would you like to set?")); 
        }
        switch (mode) {
            case "1":
                ocean1.setShips(true);
                ocean1.setBombs(number);
                ocean2.setShips(true);
                ocean2.setBombs(number);
            break;
            case "2":
                ocean1.setShips(true);
                ocean1.setBombs(number);
                ocean2.setShips(true);
                ocean2.setBombs(number);
            break;
            case "3":
                ocean1.setShips(true);
                ocean1.setBombs(number);
                ocean2.setShips(true);
                ocean2.setBombs(number);
            break;
            default:
                System.out.println("There's no such option");
        }
    }

    private void playGame() {
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
                
            } while(ocean2.getShot(isComputer1, this.level));

            do{
                view.displayBoards(ocean1, ocean2);
            } while(ocean1.getShot(isComputer2, this.level));
        } while (!this.isWon());
        
    }

    public Boolean isWon () {
        Integer counterOcean1 = 0;
        Integer counterOcean2 = 0;
        for (Ship ship: ocean1.ships){
            if (ship.checkIfSunked()){
                counterOcean1 +=1;
            }
        }
        for (Ship ship: ocean2.ships){
            if (ship.checkIfSunked()){
                counterOcean2 +=1;
            }
        }
        if (counterOcean1.equals(4) || counterOcean2.equals(4)){
            return true;
        } else { 
            return false;
        }
        
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