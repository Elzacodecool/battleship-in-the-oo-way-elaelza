import java.text.*;
import java.io.*;
import java.util.*;
import java.lang.*;


class Ship {
    String name;
    Boolean isHorizontal;
    
    List <Square> ship;

    public Ship(int length) {
        this.ship = setShip(length);
    }

    public List <Square> setShip(int length) {
        List <Square> ship = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Scanner reader = new Scanner(System.in);
            System.out.println("X: ");
            int x = reader.nextInt();
            System.out.println("Y: ");
            int y = reader.nextInt();
            
            Square position = new Square(x, y);
            ship.add(position);
        }

        return ship;
    }

}