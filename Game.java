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


    public void setShips(Ocean ocean, Boolean isComputer) {
        Boolean isHorizontal;
        List<Integer> position;
        Integer length;
        Map <String, Integer> shipsLength = Ship.getShipsLength();

        for(String name: shipsLength.keySet()){
            length = shipsLength.get(name);
            do {
                if (isComputer) {
                    isHorizontal = view.getRandomIsHorizontal();
                    position = view.getRandomPosition();
                }
                else {
                    isHorizontal = view.getIsHorizontal();
                    position = view.getPosition();
                }
            } while (!isPossible(isHorizontal, position, length));
            
            ocean.setShip(isHorizontal, position, length);
        }       

    }

    private Boolean isPossible(Boolean isHorizontal, List<Integer> position, Integer length){
        Integer x = position.get(0);
        Integer y = position.get(1);

        if (isHorizontal) {
            if (x + length < 10 && y < 10){
                return true;
            }
        }
        else {
            if (x < 10 && y  + length < 10){
                return true;
            }
        }
        return false;
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