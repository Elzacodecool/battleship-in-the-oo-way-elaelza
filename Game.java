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