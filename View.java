import java.util.*;

class View {
    Square [][] boardPlayer1;
    Square [][] boardPlayer2;

    public void displayBoard() {

    }

    //public List<Integer> getFirstPosition() {

    //}
    public List<Integer> getFirstPosition() {
        Scanner reader = new Scanner(System.in);
        List <Integer> position = new ArrayList<>();
        Integer x;
        Integer y;
            
        do {
            System.out.println("X: ");
            x = reader.nextInt();
        } while ((isHorizontal && x + length >= 10) || (!isHorizontal && x >= 10));
        
        do {
            System.out.println("Y: ");
            y = reader.nextInt();
            
        } while ((!isHorizontal && y + length >= 10) || (isHorizontal && y >= 10));

        position.add(x);
        position.add(y);

        return position;
    }


    public List<Integer> getRandomFirstPosition() {
        Random random = new Random();
        Integer x;
        Integer y;

        do {
            x = random.nextInt(10);
        } while ((isHorizontal && x + length < 10) || (!isHorizontal && x < 10));
        
        do {
            
            y = random.nextInt(10);
            
        } while ((!isHorizontal && y + length < 10) || (isHorizontal && y < 10));
        position.add(x);
        position.add(y);

        return position;
    }
    
    
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