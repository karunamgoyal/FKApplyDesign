package src.State;
import src.State.Point;
public class StateUpdater{
    State state;
    int numberofStates;

    public StateUpdater(State state){
        this.state = state;
        numberofStates = 0;
    }
    public boolean isNotValid(Point move){
        if(move.getX()<0 || move.getY()<0 || move.getX()>state.Row-1||move.getY()>state.Column-1){
            return true;
        }
        if(state.Board[move.getX()][move.getY()]==0){
            return false;
        }
        else    
            return true;
    }
    public boolean isFull(){
        if(state.numberofState==state.Row*state.Column){
            return true;
        }
        else return false;
    }
    public boolean updateMove(Point move,char symbol){
          state.Board[move.getX()][move.getY()] = symbol;
          numberofStates ++;
          return true;  
    }
    public boolean isFull(){
        return numberofStates >= (state.Row * state.Column);
    }


}