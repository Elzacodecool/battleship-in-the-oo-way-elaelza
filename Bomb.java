import java.util.*;
class Bomb {
    //List<Square> squares = new ArrayList<Square>();
    Integer x;
    Integer y;
    String sign = " ";

    public Bomb (Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Boolean getShot(Integer x, Integer y) {
        if (this.x == x && this.y == y) {
            this.sign = "@";
            return true;
        }
        return false;
    }


    public static void main(String [] args) {

    }
}