import java.text.*;
import java.io.*;
import java.util.*;
import java.lang.*;


class Ocean {
    List <Ship> ships = new ArrayList<> ();
    Square [][] ocean;

    public Ocean () {
        this.ocean = setOcean();
        setShips();
        setShips();
    }


    public void setShips() {
        Ship newShip;
        do  {
            newShip = new Ship(3);
        } while (!isPossibleShip(newShip));
        
        ships.add(newShip);
        addShipToOcean(newShip);

    }


    public Boolean isPossibleShip(Ship myShip) {
        for (Ship ship: ships) {
            for (Square position: ship.ship) {
                for (Square myPosition: myShip.ship){
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (myPosition.x + i == position.x && myPosition.y + j == position.y) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }



    public Square [][] setOcean(){
        Square [][] ocean = new Square[10][10];

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                ocean[x][y] = new Square(x, y);
            }
        }
        return ocean;
    }


    public void addShipToOcean(Ship myShip){
        for (Square square: myShip.ship) {
            ocean[square.x][square.y].setX();
        }
    }


    public void display() {
        for (int y = 9; y >= 0; y--) {
            for (int x = 0; x < 10; x++) {
                System.out.print(ocean[x][y].getSign());
            }
            System.out.print("\n");
        }
    }


    public static void main(String args[]){
        Ocean myOcean = new Ocean();
        
        myOcean.display();
    }
}