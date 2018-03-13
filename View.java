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
                  
        System.out.println("X: ");
        position.add(reader.nextInt());
    
        System.out.println("Y: ");
        position.add(reader.nextInt());

        return position;
    }


    public List<Integer> getRandomFirstPosition() {
        Random random = new Random();
        List <Integer> position = new ArrayList<>();
                    
        position.add(random.nextInt(10));
        position.add(random.nextInt(10));

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