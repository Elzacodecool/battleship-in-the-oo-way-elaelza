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
        setShip(length, x, y);    
    }  
    

    public void sunkShip(){
        this.isSunk = true;
    }

    

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


    public void setShip(Integer length, Integer x, Integer y) {
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