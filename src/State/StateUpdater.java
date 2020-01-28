package src.State;
import src.State.Point;
public class StateUpdater{
    

    public StateUpdater(){
        
    }
    public boolean isNotValid(Point move,State state){
        if(move.getX()<0 || move.getY()<0 || move.getX()>state.Row-1||move.getY()>state.Column-1){
            return true;
        }
        if(state.Board[move.getX()][move.getY()]==0){
            return false;
        }
        else    
            return true;
    }
    public boolean updateMove(Point move,char symbol,State state,int i){
          state.Board[move.getX()][move.getY()] = symbol;
          state.numberofStates +=i;
          return true;  
    }
    public boolean isFull(State state){
        return state.numberofStates >= (state.Row * state.Column);
    }


}