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
            } while (!isPossible(isHorizontal, x, y, length) || !isPossibleShip(ocean.ships, x,y));
            
            ocean.setShip(isHorizontal, x, y, length);
        }       

    }

    private Boolean isPossible(Boolean isHorizontal, Integer x, Integer y, Integer length){
        if (isHorizontal) {
            if (x + length < 10 && y < 10){
                return true;
            }
        }
        else {
            if (x < 10 && y  + length < 10){
                return true;
            }
        }
        return false;
    }


    public Boolean isPossibleShip(List <Ship> ships, Integer x, Integer y) {
        for (Ship ship: ships) {
            for (Square position: ship.squares) {
               
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (x + i == position.x && y + j == position.y) {
                                return false;
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


    private void playGame(){
        
    }


    public static void main (String [] args) {
        Game myGame = new Game();

        String mode;
        do {
            myGame.printMenu();
            myGame.mode = myGame.askUser("How would you like to play??");
            myGame.printSubmenu();
            myGame.level = myGame.askUser("How would you like to play??");
            myGame.playGame();
        } while (!myGame.level.equals("4"));

        

    }
}