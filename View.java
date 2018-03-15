import java.util.*;

class View {
    public void displayBoards(Ocean ocean1, Ocean ocean2, Boolean isFirst) {
        String line = "";
        String color1 = "";
        String color2 = "";
        String whiteColor = "\033[0m";
        String waterChar = "░";
        String greenColor = "\033[32m";
        String blueColor = "\033[37m";
        String blueBackground = "\033[46m";
        String redColor = "\033[31m";
        String brownColor = "\033[30m";
        String brownBackground = "\033[40m";
        String pinkColor = "\033[35m";
        String sign;
        Map <String, String> signAndColor = new HashMap <>();
        List <String> displayedBoard = new ArrayList<>();
        signAndColor.put(" ", blueBackground + " ");
        signAndColor.put(".", blueBackground + blueColor + ".");
        signAndColor.put("@", blueBackground + redColor + "@");
        signAndColor.put("x", brownBackground + brownColor + "x" + blueBackground);
        signAndColor.put("xv", brownBackground + brownColor + "x");


        if(isFirst) {
            color1 = "";
            color2 = whiteColor;
        }
        else {
            color1 = whiteColor;
            color2 = "";
        }
        for(int i = 0; i < 47; i++){
            line += "-";
        }
        
        displayedBoard.add("\033[H\033[2J");
        displayedBoard.add(whiteColor);
        displayedBoard.add(line);
        displayedBoard.add(String.format("\n|    %s%s%-14s%s|%3d|    %s%s%-14s%s|%3d|\n", greenColor, color1,
            ocean1.score.name, whiteColor, ocean1.score.shotsCount, greenColor, color2, ocean2.score.name, whiteColor,
             ocean2.score.shotsCount));
        displayedBoard.add(line);
        displayedBoard.add(String.format("\n|  %2$s%3$s%1$s|  %2$s%4$s%1$s%5$s|\n", "A B C D E F G H I J ", 
            pinkColor, color1, color2, whiteColor));     
        
        for (int y = 0; y < 10; y++) {
            displayedBoard.add("|");
            displayedBoard.add(String.format("%s%s%2d%s", pinkColor, color1, y + 1, whiteColor));
            
            for (int x = 0; x < 10; x++) {
                sign = ocean2.board[x][y].getSign();
                sign = (sign.equals("x") && x != 9 && ocean2.board[x+1][y].getSign().equals("x")) ? "xv" : sign;
                displayedBoard.add(String.format("%s%s", signAndColor.get(sign), " "));
            }
            displayedBoard.add(whiteColor);
            displayedBoard.add("|");
            displayedBoard.add(String.format("%s%s%2d%s", pinkColor, color2, y + 1, whiteColor));
            
            for (int x = 0; x < 10; x++) {
                sign = ocean1.board[x][y].getSign();
                sign = (sign.equals("x") && x != 9 && ocean1.board[x+1][y].getSign().equals("x")) ? "xv" : sign;
                displayedBoard.add(String.format("%s%s", signAndColor.get(sign), " "));
            }
            displayedBoard.add(whiteColor);
            displayedBoard.add("|\n");
        }
        displayedBoard.add(line);


        for(String element: displayedBoard) {
            System.out.print(element);
        }

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