import java.text.*;
import java.io.*;
import java.util.*;
import java.lang.*;


class Square {
    int x;
    int y;
    String sign;


    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        this.sign = " ";
    }


    public void setX() {
        this.sign = "x";
    }


    public String getSign() {
        return this.sign;
    }
}