import java.text.*;
import java.io.*;
import java.util.*;
import java.lang.*;


class Ocean {
    List<Ship> ships = new ArrayList<> ();
    List<Square> bombs = new ArrayList<>();
    View view = new View();
    HighScore score;
    Square [][] board;
    

    public Ocean () {
        this.board = setBoard();
        this.score = new HighScore();
    }

    public void prepareScore(Boolean isComputer){
        if(isComputer) {
            this.score.setName("AI");
        } else {
        this.score.setName(view.askUser("What's your name?"));
        }
    }

    private Square [][] setBoard(){
        Square [][] board = new Square[10][10];

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                board[x][y] = new Square(x, y);
            }
        }
        return board;
    }

    public void gameOver() {
        System.out.println("Game Over");
        this.score.writeToFile();
    }

    private void changeReference() {
        for (Ship ship: ships){
            for(Square position: ship.squares) {
                board[position.x][position.y] = position;
            }
        }
    }


    private void changeReferenceBomb() {
        for (Square position: bombs){
            board[position.x][position.y] = position;
        }
    }


    public void setShips(Boolean isComputer) {
        Boolean isHorizontal;
        List<Integer> position;
        Integer length;
        Integer x;
        Integer y;
        Ship newShip;
        Map <String, Integer> shipsLength = Ship.getShipsLength();
        

        for(String name: shipsLength.keySet()){
            length = shipsLength.get(name);
            do {
                
                if (isComputer) {
                    isHorizontal = view.getRandomIsHorizontal();
                    position = view.getRandomPosition();
                }
                else {
                    System.out.printf("%s: %d\n", name, length);
                    isHorizontal = view.getIsHorizontal();
                    position = view.getPosition();
                }
                x = position.get(0);
                y = position.get(1);
                newShip = new Ship(length, isHorizontal, x, y);
                
            } while (!isPossible(isHorizontal, x, y, length, isComputer) || !isPossibleShip(ships, newShip, isComputer));
            
            ships.add(newShip);
            this.changeReference(); 
        }  
    }


    public void setBombs(int number){
        Integer x;
        Integer y;
        List <Integer> position;
        for (int i = 0 ; i <= number; i++) {
            do {
                position = view.getRandomPosition(); 
                x = position.get(0);
                y = position.get(1);      
            } while (!this.isPossibleBomb(x, y));
            Square myBomb = new Square(x, y);
            this.changeReferenceBomb();
            this.bombs.add(myBomb);
        }
    }


    private Boolean isPossibleBomb(Integer x, Integer y) {
        for (Ship ship: ships) {
            for (Square element : ship.squares) {
                if (element.x.equals(x) &&  element.y.equals(y)) {
                    return false;
                }
            }  
        }
        return true;
    }


    private Boolean isPossible(Boolean isHorizontal, Integer x, Integer y, Integer length, Boolean isComputer){
        if (isHorizontal) {
            if (x + length < 10 && y < 10){
                return true;
            }
        } else {
            if (x < 10 && y  + length < 10){
                return true;
            }
        }
        if (!isComputer) {
            System.out.println("Board is too small for this ship.");
        }
        return false;
    }


    private Boolean isPossibleShip(List <Ship> ships, Ship newShip, Boolean isComputer) {
        for (Ship ship: ships) {
            for (Square position: ship.squares) {
                for (Square newPosition: newShip.squares){
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (newPosition.x + i == position.x && newPosition.y + j == position.y) {
                                if (!isComputer) {
                                    System.out.println("There's no space for this ship.");
                                }
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    
    public Boolean getShot(Boolean isComputer, String level) throws BombException{
        Integer x;
        Integer y;
        List <Integer> position = new ArrayList<>();
        String sign;
        
        if (isComputer){
            if (level.equals("1")){
                position = view.getRandomPosition();
            }
            else {
                position = view.getIntelligentPosition(board, ships, bombs);
            }
            this.timeStop();
            
        }
        else {
            position = view.getPosition();
        }
        
        x = position.get(0);
        y = position.get(1);
        sign = getSign(x, y);
        this.board[x][y].setSign(sign);
        this.checkSunk(isComputer, level);
        this.enterDotInside(isComputer, level);
        
        if(this.board[x][y].getSign().equals("x")){
            return true;
        } else {
            if(this.board[x][y].getSign().equals("@")) {
                throw new BombException("You have found bomb. Game Over.");
            }
            return false;
        }
    }


    private void timeStop() {
        try { 
            Thread.sleep(600); 
        }
        catch ( InterruptedException e) { 
            System.out.println(e); 
        }
    }


    private void enterDotInside(Boolean isComputer, String level) {
        Integer count;
        if (level.equals("1") || isComputer){
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 10; x++) {
                    count = 0;
                    
                    try {
                        if (board[x+1][y].getSign().equals(".")) {
                            count++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        count++;
                    }
                    try {
                        if (board[x-1][y].getSign().equals(".")) {
                            count++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        count++;
                    }
                    try {
                        if (board[x][y+1].getSign().equals(".")) {
                            count++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        count++;
                    }
                    try {
                        if (board[x][y-1].getSign().equals(".")) {
                            count++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        count++;
                    }
                    if (board[x][y].getSign().equals(" ") && count.equals(4)){
                        board[x][y].setSign(".");
                    }               
                }
            }
        }
    }



    private void checkSunk(Boolean isComputer, String level) {
        for (Ship ship: ships){
            if (ship.checkIfSunked() && (level.equals("1") || isComputer)){
                this.setDotFrame(ship);
            }
        }
    }


    private String getSign(Integer x, Integer y) {
        for(Ship ship: ships) {
            if (ship.squares.contains(board[x][y])) {
                return "x";
            }
        }
        for(Square bomb: bombs) {
            if (bombs.contains(board[x][y])) {
                return "@";
            }
        }
        return ".";
    }


    private void setDotFrame(Ship ship) {
        for(Square position: ship.squares) {
            for (int i = -1; i <= 1; i++) {
                for(int j = -1; j <= 1; j++){
                    try {
                        if(!this.board[position.x + i][position.y + j].getSign().equals("x")) {
                            this.board[position.x + i][position.y + j].setSign(".");
                        }
                    }
                    catch (ArrayIndexOutOfBoundsException e) {}
                }
            }
        }
    }
}