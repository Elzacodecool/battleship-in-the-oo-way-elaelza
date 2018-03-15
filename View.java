import java.util.*;

class View {
    public void displayBoards(Ocean ocean1, Ocean ocean2, Boolean isFirst) {
        String line = "";
        String color1 = "";
        String color2 = "";
        String whiteColor = "\033[0m";
        String greenColor = "\033[32m";
        String blueColor = "\033[37m";
        String blueBackground = "\033[46m";
        String redColor = "\033[31m";
        String brownColor = "\033[30m";
        String yellowColor = "\033[33m";
        String brownBackground = "\033[40m";
        String pinkColor = "\033[35m";
        String stopColor = "";
        String sign;
        Map <String, String> signAndColor = new HashMap <>();
        List <String> displayedBoard = new ArrayList<>();
        signAndColor.put(" ", blueBackground + " ");
        signAndColor.put(".", blueBackground + blueColor + ".");
        signAndColor.put("@", blueBackground + redColor + "@");
        signAndColor.put("x", brownBackground + brownColor + "x" + blueBackground);
        signAndColor.put("xv", brownBackground + brownColor + "x");
        signAndColor.put("X", brownBackground + yellowColor + "x" + blueBackground);
        signAndColor.put("XV", brownBackground + yellowColor + "x");


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
        displayedBoard.add(String.format("\n|  %2$s%3$s%1$s%5$s|  %2$s%4$s%1$s%5$s|\n", "A B C D E F G H I J ", 
            pinkColor, color1, color2, whiteColor));     
        
        for (int y = 0; y < 10; y++) {
            displayedBoard.add("|");
            displayedBoard.add(String.format("%s%s%2d%s", pinkColor, color1, y + 1, whiteColor));
            
            for (int x = 0; x < 10; x++) {
                sign = ocean2.board[x][y].getSign();
                sign = (sign.equals("x") && x != 9 && ocean2.board[x+1][y].getSign().equals("x")) ? "xv" : sign;
                for(Ship ship: ocean2.ships){
                    if (ship.squares.contains(ocean2.board[x][y])) {
                        if (ship.checkIfSunked()){
                            sign = sign.toUpperCase();
                        }
                    }
                }
                
                displayedBoard.add(String.format("%s%s", signAndColor.get(sign), " "));
            }
            displayedBoard.add(whiteColor);
            displayedBoard.add("|");
            displayedBoard.add(String.format("%s%s%2d%s", pinkColor, color2, y + 1, whiteColor));
            
            for (int x = 0; x < 10; x++) {
                sign = ocean1.board[x][y].getSign(); 
                sign = (ocean1.board[x][y].getSign().equals("x") && x != 9 
                        && ocean1.board[x+1][y].getSign().equals("x")) ? "xv" : sign;
                for(Ship ship: ocean1.ships){
                    if (ship.squares.contains(ocean1.board[x][y])) {
                        if (ship.checkIfSunked()){
                            sign = sign.toUpperCase();
                        }
                    }
                }
               
                displayedBoard.add(String.format("%s%s", signAndColor.get(sign), " "));
            }
            displayedBoard.add(whiteColor);
            displayedBoard.add("|\n");
        }
        displayedBoard.add(line);


        for(String element: displayedBoard) {
            System.out.print(element);
        }
        System.out.println("\n");        

    }

    public String askUser(String question) {
        System.out.println(question);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }


    public void printMenu() {
        String [] mainMenu = { "1. Play Player - Player",
                            "2. Play Player - Computer", 
                            "3. Play Computer - Computer",
                            "4. Print HighScore",
                            "5. Quit"
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
                             
        System.out.print("\033[H\033[2J");
        for (String e : mainMenu){
            System.out.println(e);
        }
    }


    public List<Integer> getIntelligentPosition(Square [][] board, List<Ship> ships, List<Square> bombs) {
        Integer x;
        Integer y;
        List <Integer> position = new ArrayList<>();

        do {
            position = getNextPosition(board, ships, bombs);
            x = position.get(0);
            y = position.get(1);

        } while (!board[x][y].getSign().equals(" "));
       
        return position;

    }


    private List <Integer> getNextPosition(Square[][] board, List<Ship> ships, List<Square> bombs) {
        Random random = new Random();
        Integer x1;
        Integer y1;
        Integer x2;
        Integer y2;
        Integer shift;
        Boolean isHorizontal;
        List <Integer> position = new ArrayList<>();
        for(Ship ship: ships){
            for(Square pos: ship.squares){
                if(pos.getSign().equals("x") && !ship.checkIfSunked()){  
                    do {
                        if (checkIsHorizontalKnown(board, ship.squares)) {
                            isHorizontal = ship.isHorizontal;
                        }
                        else {
                            isHorizontal = random.nextBoolean();
                        }
                        
                        shift = (random.nextBoolean()) ? 1 : -1;
                        if (isHorizontal) {
                            x1 = pos.x + shift;
                            y1 = pos.y;
                            x2 = pos.x - shift;
                            y2 = pos.y;
                        }
                        else {
                            x1 = pos.x;
                            y1 = pos.y + shift;
                            x2 = pos.x;
                            y2 = pos.y - shift;
                        }
                    } while (!isPossiblePossition(x1, y1));

                    if (!isPossiblePossition(x2, y2)) {
                        if (!board[x1][y1].getSign().equals(" ")){
                            continue;
                        }
                    }
                    else{
                        if (!(board[x1][y1].getSign().equals(" ") || board[x2][y2].getSign().equals(" "))
                            && checkIsHorizontalKnown(board, ship.squares)){
                                continue;
                        }
                    }
                    
                    position.add(x1);
                    position.add(y1);
                    return position;
                    
                }
            }
        }

        return getPositionWithoutBomb(board, bombs);
    }

    private List <Integer> getPositionWithoutBomb(Square[][] board, List<Square> bombs){
        List <Integer> position = new ArrayList<>();
        Integer x;
        Integer y;
        do {
            position = getRandomPosition();
            x = position.get(0);
            y = position.get(1);
        } while(bombs.contains(board[x][y]));
        return position;
    }


    private Boolean checkIsHorizontalKnown(Square[][] board, List<Square> squares){
        Integer countHit = 0;
        for(Square position: squares) {
            if (position.getSign().equals("x")) {
                countHit ++;
            }
        }
        if(countHit.compareTo(1) > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    private Boolean isPossiblePossition (Integer x, Integer y) {
        if (x <10 && x >= 0 && y < 10 && y >= 0) {
            return true;
        }
        return  false;
    }


    public List<Integer> getPosition() {
        Scanner reader = new Scanner(System.in);
        String input;
        Integer x = 10;
        Integer y = 10;
        List <Integer> position = new ArrayList<>();

        do {
            input = reader.nextLine().toUpperCase();

            try{
                x = "ABCDEFGHIJ".indexOf(input.substring(0, 1));
                y = Integer.parseInt(input.substring(1).trim()) - 1;
            }
            catch (NumberFormatException e) {
                System.err.println("wrong format");
            }
            catch (StringIndexOutOfBoundsException e) {
                System.err.println("enter something");
            }
            
        } while(!isPossiblePossition(x, y));

        position.add(x);
        position.add(y);
        

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