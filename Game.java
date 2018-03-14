import java.text.*;
import java.io.*;
import java.util.*;
import java.lang.*;


class Game {
    String mode;
    String level;
    View view = new View();
    Ocean ocean1 = new Ocean();
    Ocean ocean2 = new Ocean();


    private void startGame() {

        switch (mode) {
            case "1":
                ocean1.setShips(false);
                ocean2.setShips(false);
            break;
            case "2":
                ocean1.setShips(false);
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
        String name = this.askUser("What's your name?");
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
            Boolean shotBomb = this.getShot(ocean1, isComputer1);
            ocean1.display();
            if (shotBomb) {
                System.out.println("You have shot a bomb. Game over!");
                break;
            }
            
            shotBomb = this.getShot(ocean2, isComputer2);
            ocean2.display();
            if (shotBomb) {
                System.out.println("You have shot a bomb. Game over!");
                break;
            }

        } while (!this.isWon());
        score.writeToFile();
    }

    public Boolean isWon () {
        return false; //TODO
    }

    private Boolean getShot(Ocean ocean, Boolean isComputer) {
        List<Integer> position = null;
        Integer x;
        Integer y;
        if (isComputer) {
            if (this.level.equals("1")) {
                position = view.getRandomPosition();
            } //else {
                // TODO aiming
           // }
        } else {
            position = view.getPosition();
        }
        x = position.get(0);
        y = position.get(1);

        return ocean.getShot(x, y);
    }


    public static void main (String [] args) {
        Game myGame = new Game();

        String mode;
        do {
            myGame.printMenu();
            myGame.mode = myGame.askUser("How would you like to play??");
            myGame.printSubmenu();
            myGame.level = myGame.askUser("How would you like to play??");
            myGame.startGame();
            myGame.playGame();
        } while (!myGame.level.equals("4"));

    }
}