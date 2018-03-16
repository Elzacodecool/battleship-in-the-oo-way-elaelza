import java.text.*;
import java.io.*;
import java.util.*;
import java.lang.*;


class Square {
    Integer x;
    Integer y;
    String sign;


    public Square(Integer x, Integer y) {
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