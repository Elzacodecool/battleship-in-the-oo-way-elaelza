# Class Ocean


## _Fields:_
- **ships**
    - *type*: `List<Ship>`
    - Holds all ships from given instance in ArrayList.

- **bombs**
    - *type*: `List<Square>`
    - Holds all Square from given instance that will change their sign for "@".

- **view**
    - *type*: `View`
    - Holds new instance of class View.

- **score**
    - *type*: `HighScore`
    - Holds new instance of class HihgScore.

- **board**
    - *type*: `Square [][]`
    - Holds all squares from given instance with changed sign.

## _Instance methods:_
- **Ocean**
    - *arguments*: `null`
    - *return*: `void`
    - Construct object class Ocean.

- **prepareScore**
    - *arguments*: `Boolean`
    - *return*: `void`
    - Set name of players. If artificial inteligence is playing sets default name: "AI".

- **setBoard**
    - *arguments*: `null`
    - *return*: `Square [][]`
    - Fill board with Squares containing coordinates matching board's coordinates.

- **gameOver**
    - *arguments*: `null`
    - *return*: `void`
    - Display *Game Over*. Call writeToFile method.

- **changeReference**
    - *arguments*: `null`
    - *return*: `void`
    - For all Squares in all ships sets reference with board elements of given coordinates.

- **changeReferenceBomb**
    - *arguments*: `null`
    - *return*: `void`
    - For all Squares in bombs sets reference with board elements of given coordinates.

- **setShips**
    - *arguments*: `Boolean`
    - *return*: `void`
    - Add ships to list of ships. Call different function for Human and AI. Call functions that checks wheather location is possible.

- **setBombs**
    - *arguments*: `int`
    - *return*: `void`
    - Add new Square to list of bombs. Call functions that checks wheather bomb location is possible.

- **isPossibleBomb**
    - *arguments*: `Integer, Integer`
    - *return*: `Boolean`
    - Checks wheather bomb location doesn't match location Squares in Ships.

- **isPossible**
    - *arguments*: `Boolean, Integer, Integer, Integer, Boolean`
    - *return*: `Boolean`
    - Checks wheather Ship instance will fit into board 10x10.

- **isPossibleShip**
    - *arguments*: `List <Ship>, Ship, Boolean`
    - *return*: `Boolean`
    - Checks wheather new Ship instance won't have Squares with coordinates the same as other or in close range.

- **getShot**
    - *arguments*: `Boolean, String`
    - *return*: `Boolean`
    - *throws*: `BombException`
    - Gets position to shoot for AI (random or Intelligent) according to level. Change sign in board Squares. Call function that draw dots around sunked ships. Call function that eliminates possibility of shot coordinates where any ship won't fit. 

- **timeStop**
    - *arguments*: `null`
    - *return*: `void`
    - Stops time of execution.

- **getShot**
    - *arguments*: `Boolean, String`
    - *return*: `void`
    - Eliminates possibility of shot coordinates where any ship won't fit by placing ".".

- **checkSunk**
    - *arguments*: `Boolean, String`
    - *return*: `void`
    - Call function setDot frame for ships that are sunk on level Beginner or for AI on all levels.

- **getSign**
    - *arguments*: `Integer, Integer`
    - *return*: `String`
    - Return proper sign if Square of given coordinates is ships or bombs, "." otherwise.

- **setDotFrame**
    - *arguments*: `Ship`
    - *return*: `void`
    - Change Squares sign to "." if Squares coordinates are in range [-1:1].

