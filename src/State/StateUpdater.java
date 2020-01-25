package src.State;
import src.State.Point;
public class StateUpdater{
    State state;


    public StateUpdater(State state){
        this.state = state;
    }
    public boolean isNotValid(Point move){
        if(move.getX()<0 || move.getY()<0 || move.getX()>state.Row-1||move.getY()>state.Column-1){
            return false;
        }
        if(state.Board[move.getX()][move.getY()]==0){
            return true;
        }
        else    
            return false;
    }
    public boolean updateMove(Point move,char symbol){
          state.Board[move.getX()][move.getY()] = symbol;
          return true;  
    }


}