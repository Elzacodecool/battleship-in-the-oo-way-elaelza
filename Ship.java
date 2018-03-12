import java.text.*;
import java.io.*;
import java.util.*;
import java.lang.*;


class Ship {
    int length;
    Boolean isHorizontal;
    Boolean isSunk;
    int [] firstPosition = new int[2];
    List <Square> ship = new ArrayList <>();


    public Ship(int length, Boolean isUser) {
        this.length = length;
        setHorizontal();
        setFirstPosition();
        setShip(length);
        this.isSunk = false;
    }


    public Ship(int length) {
        this.length = length;
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
        Random random = new Random();
        this.isHorizontal = random.nextBoolean();
    }


    private void setFirstPosition() {
        Scanner reader = new Scanner(System.in);
        int x;
        int y;
            
        do {
            System.out.println("X: ");
            x = reader.nextInt();
        } while ((isHorizontal && x + length >= 10) || (!isHorizontal && x >= 10));
        
        do {
            System.out.println("Y: ");
            y = reader.nextInt();
            
        } while ((!isHorizontal && y + length >= 10) || (isHorizontal && y >= 10));

        this.firstPosition[0] = x;
        this.firstPosition[1] = y;
    }


    private void setRandomFirstPosition() {
        Random random = new Random();
        int x;
        int y;

        do {
            x = random.nextInt(10);
        } while ((isHorizontal && x + length < 10) || (!isHorizontal && x < 10));
        
        do {
            
            y = random.nextInt(10);
            
        } while ((!isHorizontal && y + length < 10) || (isHorizontal && y < 10));

        this.firstPosition[0] = x;
        this.firstPosition[1] = y;
    }


    public void setShip(int length) {
        Square position;
        for (int i = 0; i < length; i++) {
            
            if (isHorizontal) {
                position = new Square(firstPosition[0] + i, firstPosition[1]);
            }
            else {
                position = new Square(firstPosition[0], firstPosition[1] + i);
            }
            ship.add(position);
        }
    }

}