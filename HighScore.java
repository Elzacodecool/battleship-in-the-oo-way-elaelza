import java.io.*;
import java.util.*;
import java.text.*;

class HighScore {
    long startTime;
    long stopTime;
    long time;
    String name;
    Integer shotsCount;
    Date date = new Date();


    public HighScore(String name) {
        startTime = System.currentTimeMillis();
        this.name = name;
        shotsCount = 0;
        

    }
    public void getTime() {
        this.stopTime = System.currentTimeMillis();
        this.time = this.stopTime - this.startTime;
    }

    public void incrementShotCount() {
        this.shotsCount += 1;
    }


    @Override
    public String toString(){
        return name + "|" 
                + String.format("%td.%<tm.%<tY", date) + "|"
                + String.format("%1$TM:%1$TS", time) + "|"
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
    public static void main(String[] args) {
        String name = "Henio";
        HighScore myScore = new HighScore(name);
        myScore.incrementShotCount();
        myScore.incrementShotCount();
        myScore.getTime();
        myScore.writeToFile();

    }
}