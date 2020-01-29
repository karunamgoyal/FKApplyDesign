package src.State;
import src.State.Point;
public class StateUpdater{
    

    public StateUpdater(){
        
    }
    public boolean isNotValid(Point move,StateInterface state){
        if(move.getX()<0 || move.getY()<0 || move.getX()>state.getRow()-1||move.getY()>state.getColumn()-1){
            return true;
        }
        if(state.getBoard()[move.getX()][move.getY()]==0||state.getBoard()[move.getX()][move.getY()]=='0'){
            return false;
        }
        else    
            return true;
    }
    public boolean updateMove(Point move,char symbol,StateInterface state,int i){
          state.getBoard()[move.getX()][move.getY()] = symbol;
          state.changeCount(i);
          return true;  
    }
    public boolean isFull(StateInterface state){
        return state.getCount() >= (state.getRow()* state.getColumn());
    }


}