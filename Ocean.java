import java.text.*;
import java.io.*;
import java.util.*;
import java.lang.*;


class Ocean {
    List <Ship> ships = new ArrayList<> ();
    // List <Bomb> bombs = new ArrayList<> ();
    Square [][] board;
    // String level;


    public Ocean (Boolean isUser) {
        this.ocean = setOcean();
        setShips(isUser);
    }


    public Map <String, Integer> getShipsLength() {
        Map <String, Integer> shipsLength = new HashMap<>();
        shipsLength.put("Carrier", 5);
        shipsLength.put("Battleship", 4);
        shipsLength.put("Cruiser", 3);
        shipsLength.put("Submarine", 3);
        shipsLength.put("Destroyer", 2);

        return shipsLength;
    }


    public void setShips(Boolean isUser) {
        Ship newShip;
        Map <String, Integer> shipsLength = getShipsLength();

        for(String name: shipsLength.keySet()){
            do  {
                System.out.printf("Enter data of %s: ", name);
                if(isUser) {
                    newShip = new Ship(shipsLength.get(name), isUser);
                }
                else {
                    newShip = new Ship(shipsLength.get(name));
                }
            } while (!isPossibleShip(newShip));

            ships.add(newShip);
            addShipToOcean(newShip);
        }       

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



    public Square [][] setBoard(){
        Square [][] board = new Square[10][10];

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                board[x][y] = new Square(x, y);
            }
        }
        return board;
    }


    public void addShipToOcean(Ship myShip){
        for (Square square: myShip.ship) {
            ocean[square.x][square.y].setX();
        }
    }


    public void display() {
        System.out.print("  x 0 1 2 3 4 5 6 7 8 9\ny  ____________________\n");
        for (int y = 0; y < 10; y++) {
            System.out.printf("%d |", y);
            for (int x = 0; x < 10; x++) {
                System.out.printf(" %s", ocean[x][y].getSign());
            }
            System.out.print("\n");
        }
    }


    public static void main(String args[]){
        Ocean myOcean = new Ocean(true);
        
        myOcean.display();
    }
}