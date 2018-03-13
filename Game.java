class Game {
    private String askUser(String question) {
        System.out.println(question);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

     private void printMenu() {
        String [] menu = { "1. Player - Player",
                            "2. Player - Computer", 
                            "3. Computer - Computer",
                            "4. Quit",
                            };
        for (String e : menu){
            System.out.println(e);
        }
    }
    public static void main (String [] args) {
        Game myGame = new Game();
        String option;
        do {
            myGame.printMenu();
            option = myGame.askUser("How would you like to play??");
            switch (option) {
                case "1":
                break;
                case "2":
                break;
                case "2":
                break;
                case "3":
            } while ()

        }

    }
}