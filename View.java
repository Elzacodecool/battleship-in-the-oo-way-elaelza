import java.util.*;

class View {
    public void displayBoards(Ocean ocean1, Ocean ocean2) {
        String line = "";
        for(int i = 0; i < 47; i++){
            line += "-";
        }
        System.out.print(line);
        System.out.printf("\n|    %-14s|%3d|    %-14s|%3d|\n", ocean1.score.name, ocean1.score.shotsCount, 
                            ocean2.score.name, ocean2.score.shotsCount);
        System.out.print(line);
        System.out.printf("\n|   %1$s|   %1$s|\n", "A B C D E F G H I J");
        for (int i = 0; i < 10; i++) {
            System.out.print("|");
            System.out.printf("%2d", i+1);
            for (int j = 0; j < 10; j++) {
                System.out.printf(" %s", ocean1.board[i][j].getSign());
            }
            System.out.print("|");
            System.out.printf("%2d", i+1);
            for (int j = 0; j < 10; j++) {
                System.out.printf(" %s", ocean2.board[i][j].getSign());
            }
            System.out.print("|\n");
        }
        System.out.println(line);     

    }

    public String askUser(String question) {
        System.out.println(question);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }


    public void printMenu() {
        String [] mainMenu = { "1. Player - Player",
                            "2. Player - Computer", 
                            "3. Computer - Computer",
                            "4. Quit",
                            };
        for (String e : mainMenu){
            System.out.println(e);
        }
    }


    public void printSubmenu() {
        String [] mainMenu = { "1. Beginner",
                            "2. Advanced", 
                            "3. Madman",
                            "4. Quit",
                            };
        for (String e : mainMenu){
            System.out.println(e);
        }
    }


    public List<Integer> getPosition() {
        Scanner reader = new Scanner(System.in);
        List <Integer> position = new ArrayList<>();
                  
        System.out.println("X: ");
        position.add(reader.nextInt());
    
        System.out.println("Y: ");
        position.add(reader.nextInt());

        return position;
    }


    public List<Integer> getRandomPosition() {
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