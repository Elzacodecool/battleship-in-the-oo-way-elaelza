import java.text.*;
import java.io.*;
import java.util.*;
import java.lang.*;


class Game {
    String mode;
    String level = "1";
    Ocean ocean1 = new Ocean();
    Ocean ocean2 = new Ocean();
    View view = new View();
    String fileName = "score.txt";


    private void startGame() {
        Integer number = 0;
        if (this.level.equals("3")) {
            number = Integer.parseInt(view.askUser("How many bombs would you like to set?")); 
        }
        Boolean player1 = null;
        Boolean player2 = null;

        switch (mode) {
            case "1":
                player1 = checkIflazy();
                player2 = checkIflazy();
            break;
            case "2":
                player1 = checkIflazy();
                player2 = true;
            break;
            case "3":
                player1 = true;
                player2 = true;
            break;
            case "4":
                System.out.print("\033[H\033[2J");
                String [] highScore = readArray(fileName);
                for (String element : highScore) {
                    System.out.println(element);
                }
            break;
            default:
                System.out.println("There's no such option");
        }
        if (this.mode.equals("1") || this.mode.equals("2") || this.mode.equals("3")) {
            ocean1.setShips(player1);
            ocean1.setBombs(number);
            ocean2.setShips(player2);
            ocean2.setBombs(number);
        }
        
    }

    private void playGame() throws BombException {
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
        ocean1.prepareScore(isComputer1);
        ocean2.prepareScore(isComputer2);
        do {
            do{
                
                view.displayBoards(ocean1, ocean2, true);
                ocean1.score.incrementShotCount();
                
            } while(ocean2.getShot(isComputer1, this.level));

            do{
                
                view.displayBoards(ocean1, ocean2, false);
                ocean2.score.incrementShotCount();
            } while(ocean1.getShot(isComputer2, this.level));
        } while (!this.isWon());
        view.displayBoards(ocean1, ocean2, true);
        
    }

    private Boolean checkIflazy() {
        String answer = view.askUser("Would you like me to set your ships for you?(Y/N)");
        if (answer.toUpperCase().equals("Y")) {
            return true;
        }
        return false;
    }

    public Boolean isWon () {
        Integer counterOcean1 = 0;
        Integer counterOcean2 = 0;
        Integer shipCount = 5;
        for (Ship ship: ocean1.ships){
            if (ship.checkIfSunked()){
                counterOcean2 += 1;
            }
        }
        for (Ship ship: ocean2.ships){
            if (ship.checkIfSunked()){
                counterOcean1 += 1;
            }
        }
        if (counterOcean1.equals(shipCount)) {
            ocean1.gameOver();
            return true;
        } else if (counterOcean2.equals(shipCount)) { 
            ocean2.gameOver();
            return true;
        } else {
            return false;
        }
    }

    private String[] readArray(String fileName) {
        String[] stringArr = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            List<String> my_collection = new ArrayList<String>();
            while((line = br.readLine()) != null) {
                my_collection.add(line);
            }
            stringArr = my_collection.toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringArr;    
    }

    public static void main (String [] args) {
        Game myGame = new Game();
        Boolean isPlaying = true;
        do {
            myGame = new Game();
            View view = new View();
            view.printMenu();
            myGame.mode = view.askUser("What would you like to do?");
            if (myGame.mode.equals("4")) {
                myGame.startGame();
                continue;
            } else {
                if (myGame.mode.equals("5")) {
                break;
                }
            }
            view.printSubmenu();
            myGame.level = view.askUser("How would you like to play??");
            myGame.startGame();
            try {
            myGame.playGame();
            } catch (BombException e) {
                view.displayBoards(myGame.ocean1, myGame.ocean2, true);
                System.out.println("You have found bomb. Game Over.\n");
            }
        } while (isPlaying);

    }
}