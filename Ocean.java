import java.text.*;
import java.io.*;
import java.util.*;
import java.lang.*;


class Ocean {
    List <Ship> positions = new ArrayList<> ();
    Square [][] ocean;

    public Ocean () {
        this.positions = setPositions();
        this.ocean = setOcean();
    }


    public void setPositions() {
        
        Ship ship = new Ship(i);
        ....
        
        positions.add(ship);
        
    }


    public String [][] setOcean(){
        String [][] ocean = new String[10][10];

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                ocean[x][y] = " ";
            }
        }
        return ocean;
    }


    public void addShips(){
        for (Ship myShip: positions) {
            for (Square square: myShip.ship) {
                ocean[square.x][square.y] = "x";
            }
        }
    }


    public void display() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                System.out.print(ocean[x][y]);
            }
            System.out.print("\n");
        }
    }


    public static void main(String args[]){
        Ocean myOcean = new Ocean();
        myOcean.addShips();
        System.out.println(myOcean.ocean);
        myOcean.display();
    }
}