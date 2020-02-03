# FKApplyDesign

How to Run
------
To Run <br>
Clone https://github.com/karunamgoyal/FKApplyDesign.git <br>
git checkout dev <br>
Then Run Shell Script It Will Automatically Compile All the Files <br>
./Compile.sh <br>
Then To Run the Game Type <br>
./Run <br>
To Run Test First Compile Test with <br>
./Compile.sh <br>
then <br>
./RunTest.sh<br>
In your terminal <br>
Enter Coordinates of the box and top left corner being 0 0 (Basic Coordinate Convention for Matrix)

Directory Structure of Java Files<br>
--------------------------------------
````
+FKApplyDesign
  -+src
   -+Players
    - Player.java
    - Machine.java
    - Human.java
   -+State
    - LeaderBoard.java
    - LeaderBoardWhole.java
    - Hex.java
    - StateInterface.java
    - State.java
    - StateManager.java
    - StateUpdater.java
    - Point.java
   - PlayGround.java
   - Run.java
  - Compile.sh
  - Run.sh
````
Directory Structure of Class Files
-------------------------------------
````
+FKApplyDesign
  -+src
   -+Players
    - Player.class
    - Machine.class
    - Human.class
   -+State
    - LeaderBoard.java
    - LeaderBoardWhole.java
    - Hex.java
    - StateInterface.java 
    - State.class
    - StateManager.class
    - StateUpdater.class
    - Point.class
   -+Playground
    - PlayGround.class
   - Run.class
  - Run.sh
````
Directory Structure of TestFiles
-------------------------------------
````
+FKApplyDesign
  -+src
   - MachineTest.java
   - HexTest.java
   - StateTest.java
  - RunTest.sh
  - CompileTest.sh
  -junit.jar
  -hamcrest.jar
````
Maintainability 
--------
CodeBase is Managed over multiple directories so it is easy for it to manage and maintain the Code for extension and later versions.

Design Plan 
----------------------------------
![Class Diagram Rough Idea](https://raw.githubusercontent.com/karunamgoyal/DoGit/master/GameClass1.jpg)
![Sequesnce Diagram Overview](https://raw.githubusehttps://raw.githubusercontent.com/karunamgoyal/DoGit/master/GameClass1.jpgrcontent.com/karunamgoyal/DoGit/master/Game.jpg)

````
Instance of a Game Being Played at a Moment 
|''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''|
| |''''''''| |'''''''''|         |''''''''''''''|  |'''''''''''| |
| |Player1 | | Player2 |         |StateInterface|  |LeaderBoard| |
| |        | |         |         |              |  |           | |
| '''''''''' '''''''''''         ''''''''''''''''  ''''''''''''' |
|                                                                |
|                |''''''''''''''| |'''''''''''''|                |
|                | State Updater| | StateManager|                |
|                |              | |             |                |
|                '''''''''''''''' '''''''''''''''                |
|                           PlayGround                           |
''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
````


**Playground** Class Which Act As A Box Where Game is Played<br>

**LeaderBoard** Maintains LeaderBoard<br>

**Player** is an Interface act as a Base for Human and Machine Player<br>

**Human** and Machine Class Plays their Moves and they have a symbol they play<br>

**StateInterface** Act as an Abstract class for TicTacToe and Hex<br>

**StateUpdater** as the name Suggests Contains a State Variable and Updates the state and checks its value<br>

**StateManager** manages the State and Checks if Someone Has Won and returns accordingly<br>

**PlayGround** Contains the Objects of Players, State, Manager, Updater and the game is played and it act as a box<br>

**Run** Runs The PlayGround

Functionality 
-----------------
* Multiple Players
* M X M Row For both TicTacToe and Hex
* Players can go to multiple Levels
* Scoring based on level
* bias in the move Revert move

Test
----------
````
Added Test using Junit and testing most critical classes and also including corner cases 
````
Sample Inputs
---------
![Sample1](https://raw.githubusercontent.com/karunamgoyal/DoGit/master/Screenshot%202020-02-03%20at%203.46.08%20AM.png)
![Sample2](https://raw.githubusercontent.com/karunamgoyal/DoGit/master/Screenshot%202020-02-03%20at%203.46.40%20AM.png)
Test Results are OK Passed 
-------
![Test](https://raw.githubusercontent.com/karunamgoyal/DoGit/master/Screenshot%202020-02-03%20at%203.50.40%20AM.png)

Why I Think This Design is better
-----
````
This Design is Good because I've Tried To Do Loose Coupling and use Composition rather than inheriting the things.
This can be further extended to play on multiple systems after adding locking mechanisms or similar Techniques
````
The System After refactoring is very loosely coupled<bR>
Updated After refactoring wherever necessary
