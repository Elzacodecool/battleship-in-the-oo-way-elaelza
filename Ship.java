import java.text.*;
import java.io.*;
import java.util.*;
import java.lang.*;


class Ship {
    Integer length;
    Boolean isHorizontal;
    List <Square> squares = new ArrayList<>();

    public Ship(Integer length, Boolean isHorizontal, int x, int y) {
        this.length = length;
        this.isHorizontal = isHorizontal;

        Square position = new Square(x, y);
        squares.add(position);

        if (isHorizontal) {
            for (int i = 1; i < length; i++) {
                position = new Square(x + i, y);
                squares.add(position);
            }
        } else {
            for (int i = 1; i < length; i++) {
                position = new Square(x, y + i);
                squares.add(position);
            }
        }
        
    }
}