package src.Playground;
import src.Players.Machine;
import src.Players.Human;
import src.Players.Player;
import src.State.StateManager;
import src.State.StateUpdater;
import src.State.State;
import src.State.Point;
public class PlayGround{
    Player PlayerOne,PlayerTwo;
    StateUpdater GameStateUpdater;
    State state;
    StateManager GameStateManager;
    public PlayGround(int NumberOfPlayers){
        state = new State();
        GameStateManager = new StateManager(state);
        GameStateUpdater = new StateUpdater(state);
        if(NumberOfPlayers == 1){
            PlayerOne = new Human('X');
            PlayerTwo = new Machine('O',state);
        }
        else {
            PlayerOne = new Human('X');
            PlayerTwo = new Human('O');
        }
    }
    public boolean startGame(){
        boolean GameGoing = true;
        boolean isUpdated = false;
        while(GameGoing){
            Point playerOnePoint = PlayerOne.playMove();
            while(GameStateUpdater.isNotValid(playerOnePoint)){
                playerOnePoint = PlayerOne.wrongMove();
            }
            isUpdated = GameStateUpdater.updateMove(playerOnePoint,PlayerOne.getSymbol());
            if(!isUpdated)
                return false;
            state.printState();
            if(GameStateManager.hasWon()){
                System.out.println("Player One Won");
                GameGoing = false;
                return true;
            }
            if(GameStateUpdater.isFull()){
                GameGoing = false;
                System.out.println("Game Drawn");
                return true;
            }
            Point playerTwoPoint = PlayerTwo.playMove();
            while(GameStateUpdater.isNotValid(playerTwoPoint)){
                playerTwoPoint = PlayerTwo.wrongMove();
            }
           
            isUpdated = GameStateUpdater.updateMove(playerTwoPoint,PlayerTwo.getSymbol());
            if(!isUpdated)
                return false;
            state.printState();
            if(GameStateManager.hasWon()){
                System.out.println("Player Two Won");
                GameGoing = false;
                return true;
            }
        }
        return false;
            
    }

}