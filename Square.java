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


    public void setSign(String sign) {
        this.sign = sign;
    }


    public String getSign() {
        return this.sign;
    }
}