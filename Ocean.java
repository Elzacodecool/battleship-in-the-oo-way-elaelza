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


    public void setShip(Boolean isHorizontal, Integer x, Integer y, Integer length) {
        Ship newShip = new Ship(length, isHorizontal, x, y);
        this.ships.add(newShip);
    }


    // public void addShipToBoard(Ship myShip){
    //     for (Square square: myShip.ship) {
    //         board[square.x][square.y].setX();
    //     }
    // }


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


    public static void main(String args[]){
        Ocean myOcean = new Ocean();
        
        myOcean.display();
    }
}