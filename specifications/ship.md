# Class Ship
*Provides fields and method necessary to handle ships.*

## _Fields:_
- **length**
    - *type*: `Integer`
    - Holds length of instance.

- **isHorizontal**
    - *type*: `Boolean`
    - Holds true if instance located horizontal, false otherwise.

- **isSunk**
    - *type*: `Boolean`
    - Holds true if all Square in instnce list have fields sign changed to: "x".

- **squares**
    - *type*: `List <Square>`
    - Holds list of Squares that built instance.

## _Instance methods:_
- **Ship**
    - *arguments*: `Integer, Boolean, Integer, Integer`
    - *return*: `void`
    - Construct object class Ship.

- **sunk**
    - *arguments*: `null`
    - *return*: `void`
    - Set instance field *isSunk* to *true*.

- **setShip**
    - *arguments*: `Integer, Integer, Integer`
    - *return*: `void`
    - Add new Square, created with given coordinates, to list of squares in instance ship.

- **checkIfSunked**
    - *arguments*: `null`
    - *return*: `Boolean`
    - Iterate through list of Squares in instance and return false if not all Squares have field *sign* changed to *"x"*.

## _Static methods:_
- **getShipsLength**
    - *arguments*: `null`
    - *return*: `Map <String, Integer>`
    - Returns Map containing name and length of ships.
