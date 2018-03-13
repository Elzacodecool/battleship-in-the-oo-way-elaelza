class Game {
    private String askUser(String question) {
        System.out.println(question);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private void printMenu() {
        String [] mainMenu = { "1. Player - Player",
                            "2. Player - Computer", 
                            "3. Computer - Computer",
                            "4. Quit",
                            };
        for (String e : menu){
            System.out.println(e);
        }
    }


    public void setShips() {
        
        Map <String, Integer> shipsLength = Ship.getShipsLength();

        for(String name: shipsLength.keySet()){
            ...
            newShip = new Ship(shipsLength.get(name), isUser);
            
        }       

    }

    public Boolean isPossibleShip(Ship myShip) {
        for (Ship ship: ships) {
            for (Square position: ship.ship) {
                for (Square myPosition: myShip.ship){
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (myPosition.x + i == position.x && myPosition.y + j == position.y) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }



    private void setFirstPosition() {
        Scanner reader = new Scanner(System.in);
        int x;
        int y;
            
        do {
            System.out.println("X: ");
            x = reader.nextInt();
        } while ((isHorizontal && x + length >= 10) || (!isHorizontal && x >= 10));
        
        do {
            System.out.println("Y: ");
            y = reader.nextInt();
            
        } while ((!isHorizontal && y + length >= 10) || (isHorizontal && y >= 10));

        this.firstPosition[0] = x;
        this.firstPosition[1] = y;
    }


    private void setRandomFirstPosition() {
        Random random = new Random();
        int x;
        int y;

        do {
            x = random.nextInt(10);
        } while ((isHorizontal && x + length < 10) || (!isHorizontal && x < 10));
        
        do {
            
            y = random.nextInt(10);
            
        } while ((!isHorizontal && y + length < 10) || (isHorizontal && y < 10));

        this.firstPosition[0] = x;
        this.firstPosition[1] = y;
    }

    
    private void printSubmenu() {
        String [] mainMenu = { "1. Beginner",
                            "2. Advanced", 
                            "3. Madman",
                            "4. Quit",
                            };
        for (String e : menu){
            System.out.println(e);
        }
    }
    public static void main (String [] args) {
        Game myGame = new Game();
        String mode;
        do {
            myGame.printMenu();
            mode = myGame.askUser("How would you like to play??");
            level = myGame.askUser("How would you like to play??");
            switch (option) {
                case "1":

                break;
                case "2":
                break;
                case "3":
                break;
            }
        } while (!option.equals("4"))

        }

    }
}