import java.text.*;
import java.io.*;
import java.util.*;
import java.lang.*;


class Ship {
    Integer length;
    Boolean isHorizontal;
    Boolean isSunk;
    List <Square> squares = new ArrayList<>();

    public Ship(Integer length, Boolean isHorizontal, Integer x, Integer y) {
        this.length = length;
        this.isHorizontal = isHorizontal;
        this.isSunk = false;
        setShip(length, x, y);    
    }  
    

    public static Map <String, Integer> getShipsLength() {
        Map <String, Integer> shipsLength = new HashMap<>();
        shipsLength.put("Carrier", 5);
        shipsLength.put("Battleship", 4);
        shipsLength.put("Cruiser", 3);
        shipsLength.put("Submarine", 3);
        shipsLength.put("Destroyer", 2);

        return shipsLength;
    }
    

    public void sunkShip(){
        this.isSunk = true;
    }


    private void setShip(Integer length, Integer x, Integer y) {
        Square position;

        for (int i = 0; i < length; i++) {
            
            if (this.isHorizontal) {
                position = new Square(x + i, y);
            }
            else {
                position = new Square(x, y + i);
            }
            this.squares.add(position);
        }
    }
}