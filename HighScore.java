import java.io.*;
import java.util.*;
import java.text.*;

class HighScore {
    String name = "AI";
    Integer shotsCount;
    Date date = new Date();


    public HighScore() {
        this.name = name;
        shotsCount = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void incrementShotCount() {
        this.shotsCount += 1;
    }

    @Override
    public String toString(){
        return String.format("%12s", name) + "|" 
                + String.format("%td.%<tm.%<tY", date) + "|"
                + shotsCount;
    }

    public void writeToFile() {
        try (FileWriter fw = new FileWriter("score.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {
            out.println(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}