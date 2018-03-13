import java.io.*;
import java.util.*;
import java.text.*;

class HighScore {
    long startTime;
    long stopTime;
    String name;
    Integer shotsCount = 0;

    public HighScore(String name) {
        startTime = System.currentTimeMillis();
        this.name = name;

    }
    public void getTime() {
        this.stopTime = System.currentTimeMillis();
    }

    public void incrementShotCount() {
        this.shotsCount += 1;
    }
}