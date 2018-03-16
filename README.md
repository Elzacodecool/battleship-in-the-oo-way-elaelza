# Battleship in the OOP way

*Our battleship project is constructed on objects gather in list. The smallest units are Squares that are gathered in ships. Those are gathered in oceans(specific for player). Oceans are created with in new instance of game.*

## The story

*The object of Battleship is to try and sink all of the other player's before they sink all of your ships. All of the other player's ships are somewhere on his/her board.  You try and hit them by calling out the coordinates of one of the squares on the board.  The other player also tries to hit your ships by calling out coordinates. Neither you nor the other player can see the other's board so you must try to guess where they are.

Each player places the 5 ships somewhere on their board, or confirm that they shoud be placed randomly. The board is a square with side's length equals 10 (spaces). The ships can only be placed vertically or horizontally. Diagonal placement is not allowed. No part of a ship may hang off the edge of the board.  Ships may not overlap each other.  No ships may be placed on another ship. Ships may not touch each other.

The 5 ships are: Carrier (occupies 5 spaces), Battleship (4), Cruiser (3), Submarine (3), and Destroyer (2). 

You sets ships by enter staring position and answering the question if it's horizontal.

Once the guessing begins, the players may not move the ships.

There are three game modes: Player-Player, Player-Computer, Computer-Computer

There are be 3 difficulty levels (beginner, advanced, madman).*

## Specification


[__game__](specifications/Game.md)

[__square__](specifications/square.md)

[__ship__](specifications/ship.md)

[__ocean__](specifications/ocean.md)

[__highScore__](specifications/HighScore.md)

[__view__](specifications/view.md)

[__bombException__](specifications/BombException.md)
