import java.text.*;
import java.io.*;
import java.util.*;
import java.lang.*;


class Ship {
    Boolean isHorizontal;
    Boolean isSunk;
    int [] firstPosition = new int[2];
    List <Square> ship;


    public Ship(int length, Boolean isUser) {
        setHorizontal();
        setFirstPosition();
        setShip(length);
        this.isSunk = false;
    }


    public Ship(int length) {
        setRandomHorizontal();
        setRandomFirstPosition();
        setShip(length);
        this.isSunk = false;
    }


    private void setHorizontal() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Is horizontal? (y/n): ");
        String answer = reader.next().toUpperCase();

        if (answer.equals("Y")) {
            this.isHorizontal = true;
        }  else {
            this.isHorizontal = false;
        }
    }


    private void setRandomHorizontal() {
        this.isHorizontal = nextBoolean();
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