import java.text.*;
import java.io.*;
import java.util.*;
import java.lang.*;


class Game {
    String mode;
    String level;


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


    public void setShips(Ocean ocean, Boolean isComputer) {
        Boolean isHorizontal;
        List<Integer> position;
        Integer length;
        Integer x;
        Integer y;
        Ship newShip;
        Map <String, Integer> shipsLength = Ship.getShipsLength();
        View view = new View();

        for(String name: shipsLength.keySet()){
            length = shipsLength.get(name);
            do {
                if (isComputer) {
                    isHorizontal = view.getRandomIsHorizontal();
                    position = view.getRandomPosition();
                }
                else {
                    isHorizontal = view.getIsHorizontal();
                    position = view.getPosition();
                }
                x = position.get(0);
                y = position.get(1);
                newShip = new Ship(length, isHorizontal, x, y);
            } while (!isPossible(isHorizontal, x, y, length) || !isPossibleShip(ocean.ships, newShip));
            
            ocean.ships.add(newShip);
        }       

    }

    private Boolean isPossible(Boolean isHorizontal, Integer x, Integer y, Integer length){
        if (isHorizontal) {
            if (x + length < 10 && y < 10){
                return true;
            }
        } else {
            if (x < 10 && y  + length < 10){
                return true;
            }
        }
        System.out.println("Board is too small for this ship.");
        return false;
    }


    public Boolean isPossibleShip(List <Ship> ships, Ship newShip) {
        for (Ship ship: ships) {
            for (Square position: ship.squares) {
                for (Square newPosition: newShip.squares){
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (newPosition.x + i == position.x && newPosition.y + j == position.y) {
                                System.out.println("There's no space for this ship.");
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
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
        Ocean ocean1 = new Ocean();
        Ocean ocean2 = new Ocean();
        switch (mode) {
            case "1":
                setShips(ocean1, false);
                setShips(ocean2, false);
            break;
            case "2":
                setShips(ocean1, false);
                setShips(ocean2, true);
            break;
            case "3":
                setShips(ocean1, true);
                setShips(ocean2, true);
            break;
            default:
                System.out.println("There's no such option");
        }

        ocean1.addShipsToBoard();
        ocean1.display();
        ocean1.getShot();
        ocean1.display();
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

    // private void playGame() {
    //     String name = myGame.askUser("What's your name?");
    //     HighScore score = new HighScore(name);
    //     do {


    //     } while(!mygame.isWon());
    //     score.writeToFile();

    // }


    public static void main (String [] args) {
        Game myGame = new Game();

        String mode;
        do {
            myGame.printMenu();
            myGame.mode = myGame.askUser("How would you like to play??");
            myGame.printSubmenu();
            myGame.level = myGame.askUser("How would you like to play??");
            myGame.startGame();
        } while (!myGame.level.equals("4"));

        

    }
}