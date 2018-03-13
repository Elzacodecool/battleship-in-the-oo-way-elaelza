import java.text.*;
import java.io.*;
import java.util.*;
import java.lang.*;


class Ocean {
    List <Ship> ships = new ArrayList<> ();
    // List <Bomb> bombs = new ArrayList<> ();
    Square [][] board;
    // String level;


    public Ocean () {
        this.board = setBoard();
    }


    public Square [][] setBoard(){
        Square [][] board = new Square[10][10];

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                board[x][y] = new Square(x, y);
            }
        }
        return board;
    }


    // public void setShip(Boolean isHorizontal, Integer x, Integer y, Integer length) {
    //     Ship newShip = new Ship(length, isHorizontal, x, y);
    //     this.ships.add(newShip);
    // }


    public void addShipsToBoard(){
        for(Ship myShip: ships){
            for (Square square: myShip.squares) {
                board[square.x][square.y].setSign("x");
            }
        }
        
    }


    public void display() {
        System.out.print("  x 0 1 2 3 4 5 6 7 8 9\ny  ____________________\n");
        for (int y = 0; y < 10; y++) {
            System.out.printf("%d |", y);
            for (int x = 0; x < 10; x++) {
                System.out.printf(" %s", board[x][y].getSign());
            }
            System.out.print("\n");
        }
    }


    public void getShot() {
        View view = new View();
        Integer x;
        Integer y;
        List<Integer> position;
        do{
            position = view.getPosition();
            x = position.get(0);
            y = position.get(1);
        } while(isHit(x, y));
    }


    public Boolean checkIfSunked(Ship ship) {
        for(Square position: ship.squares) {
            if (!board[position.x][position.y].getSign().equals("x")) {
                return false;
            }
        }
        return true;
    }


    public Boolean isHit(Integer x, Integer y) {
        for(Ship ship:ships) {
            for(Square position: ship.squares) {
                if (position.x.equals(x) && position.y.equals(y)) {
                    board[x][y].setSign("x");
                    if(checkIfSunked(ship)){
                        setDotFrame(ship);
                        ship.sunkShip();
                    }
                    return true;
                }
            }
        }
        return false;
    }


    public void setDotFrame(Ship ship) {
        for(Square position: ship.squares) {
            for (int i = -1; i <= 1; i++) {
                for(int j = -1; j <= 1; j++){
                    try {
                        if(!board[position.x + i][position.y + j].getSign().equals("x")) {
                            board[position.x + i][position.y + j].setSign(".");
                        }
                    }
                    catch (ArrayIndexOutOfBoundsException e) {}
                }
            }
        }
    }


    public static void main(String args[]){
        Ocean myOcean = new Ocean();
        
        myOcean.display();
    }
}