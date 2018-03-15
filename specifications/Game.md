# Class Game

## _Fields:_
- **mode**
    - *type*: `String`
    - Holds mode choosen by player.

- **level**
    - *type*: `String`
    - Holds level choosen by player.

- **ocean1**
    - *type*: `Ocean`
    - Holds new instance of class Ocean.

- **ocean2**
    - *type*: `Ocean`
    - Holds new instance of class Ocean.

- **view**
    - *type*: `View`
    - Holds new instance of class View.

- **fileName**
    - *type*: `String`
    - Holds fileName.

## _Instance methods:_
- **startGame**
    - *arguments*: `null`
    - *return*: `void`
    - Sets number of bombs. Handle chooseing mode by player. Call function setShips and setBombs for both oceans.

- **playGame**
    - *arguments*: `null`
    - *return*: `void`
    - *throws:* `BombException`
    - Handle chooseing level by player. Call function prepareScore for both Oceans. Controlls the most important part of game: shooting. 

- **checkIflazy**
    - *arguments*: `null`
    - *return*: `Boolean`
    - Return true if player want to have his ships display by computer.

- **isWon**
    - *arguments*: `null`
    - *return*: `Boolean`
    - Return true if all ships in Ocean are sunk by calling function *checkIfSunked*.

- **isWon**
    - *arguments*: `String`
    - *return*: `String[]`
    - Read file line by line and return String[].

## _Static methods:_

- **main**
    - *arguments*: `String []`
    - *return*: `void`
    - Create ne instance of Game. Print menu and submenu. Sets mode and level by asking player. Call function startGame and playGame.






