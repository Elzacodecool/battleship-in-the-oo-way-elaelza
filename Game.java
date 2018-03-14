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
                ocean1.setShips(false);
                ocean1.setBombs(number);
                ocean2.setShips(false);
                ocean2.setBombs(number);
            break;
            case "2":
                ocean1.setShips(false);
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
        
        String name = view.askUser("What's your name?");
        HighScore score = new HighScore(name);
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
            ocean2.getShot(isComputer1);
            ocean1.getShot(isComputer2);
        } while (!this.isWon());
        score.writeToFile();
    }

    public Boolean isWon () {
        return false; //TODO
    }

    // private Boolean getShot(Ocean ocean, Boolean isComputer) {
    //     View view = new View();
    //     List<Integer> position = null;
    //     Integer x;
    //     Integer y;
    //     if (isComputer) {
    //         if (this.level.equals("1")) {
    //             position = view.getRandomPosition();
    //         } //else {
    //             // TODO aiming
    //        // }
    //     } else {
    //         position = view.getPosition();
    //     }
    //     x = position.get(0);
    //     y = position.get(1);

    //     return ocean.getShot(x, y);
    // }


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