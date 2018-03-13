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