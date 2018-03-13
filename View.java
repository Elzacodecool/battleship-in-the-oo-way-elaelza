import java.util.*;

class View {
    Square [][] boardPlayer1;
    Square [][] boardPlayer2;

    public void displayBoard() {

    }

    //public List<Integer> getFirstPosition() {

    //}

    
    public Boolean getIsHorizontal() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Is horizontal? (y/n): ");
        String answer = reader.next().toUpperCase();

        if (answer.equals("Y")) {
            return true;
        }  else {
            return false;
        }
    }

    public Boolean getRandomIsHorizontal() {
        Random random = new Random();
        return random.nextBoolean();
    }

}