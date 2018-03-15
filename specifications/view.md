# Class View

## _Fields:_
`null`

## _Instance methods:_
- **displayBoards**
    - *arguments*: `Ocean, Ocean, Boolean`
    - *return*: `void`
    - Display formatted boards.

- **askUser**
    - *arguments*: `String`
    - *return*: `String`
    - Return input from player.

- **printMenu**
    - *arguments*: `null`
    - *return*: `void`
    - Print Main menu. 

- **printSubmenu**
    - *arguments*: `null`
    - *return*: `void`
    - Print Submenu. 

- **getIntelligentPosition**
    - *arguments*: `Square [][], List<Ship>, List<Square>`
    - *return*: `List<Integer>`
    - Return inteligent position by calling function  getNextPosition.

- **getNextPosition**
    - *arguments*: `Square [][], List<Ship>, List<Square>`
    - *return*: `List<Integer>`
    - Return inteligent position by calling function checkIfHorizontalKnown and isPossiblepossition.
    
- **getPositionWithoutBomb**
    - *arguments*: `Square [][], List<Square>`
    - *return*: `List<Integer>`
    - Return coordinates that are not in bombs list.

- **checkIsHorizontalKnown**
    - *arguments*: `Square [][], List<Square>`
    - *return*: `<Boolean>`
    - Return true if more than one Square in ship was hit.

- **isPossiblePossition**
    - *arguments*: `Integer, Integer`
    - *return*: `<Boolean>`
    - Return true if coordinates fit in range [0:9].
    
- **getPosition**
    - *arguments*: `null`
    - *return*: `List<Integer>`
    - Return checked by calling isPossiblePossition coordinates formated from letter to number.
    
- **getPosition**
    - *arguments*: `null`
    - *return*: `List<Integer>`
    - Return randomly choosen coordinates.
    
- **getIsHorizontal**
    - *arguments*: `null`
    - *return*: `Boolean>`
    - Player set wheather wants ship to be placed horizontal.
    
- **getRandomIsHorizontal**
    - *arguments*: `null`
    - *return*: `Boolean>`
    - Randomly returns true or false.
    


