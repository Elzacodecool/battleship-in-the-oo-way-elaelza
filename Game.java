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


    private String askUser(String question) {
        System.out.println(question);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private void printMenu() {
        String [] mainMenu = { "1. Player - Player",
                            "2. Player - Computer", 
                            "3. Computer - Computer",
                            "4. Quit",
                            };
        for (String e : mainMenu){
            System.out.println(e);
        }
    }

    
    private void printSubmenu() {
        String [] mainMenu = { "1. Beginner",
                            "2. Advanced", 
                            "3. Madman",
                            "4. Quit",
                            };
        for (String e : mainMenu){
            System.out.println(e);
        }
    }


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

        // ocean1.addShipsToBoard();
        // ocean1.display();
        // ocean1.getShot();
        // ocean1.display();
        // ocean2.addShipsToBoard();
        // ocean2.display();

        // Ocean ocean1 = new Ocean();
        // setShips(ocean1, true);
        // ocean1.addShipsToBoard();
        // ocean1.display();
        // Ocean ocean2 = new Ocean();
        // setShips(ocean2, true);
        // ocean2.addShipsToBoard();
        // ocean2.display();

    }

    private void playGame() {
        String name = this.askUser("What's your name?");
        HighScore score = new HighScore(name);
        Boolean isComputer1 = null;
        Boolean isComputer2 = null;
<<<<<<< HEAD

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

=======

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
        return true; //TODO
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

>>>>>>> 9d3f38f04b5e79d8e7acb80e25f461d22a7fb7ce
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