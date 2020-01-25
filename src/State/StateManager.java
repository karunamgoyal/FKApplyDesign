package src.State;

public class StateManager{
    State state;

    public StateManager(State state){
        this.state = state; 
    }
    public boolean hasWon(){
        if(checkRow()||checkColumn()||checkDiagonal())
            return true;
        else    
            return false;

    }
    boolean checkRow(){
        int n = state.Row;
        int m = state.Column;
        for(int row = 0; row< n; row++){
            char rowChar=state.Board[row][0];
            for(int col=0;col<m;col++){    
                
                if(state.Board[row][col]!=rowChar){
                    break;
                }
                else if(state.Board[row][col]==0)
                    break;
                else if(col==m-1){
                    return true;
                }
            }
        }
        return false;
    }
    boolean checkColumn(){
        int n = state.Row;
        int m = state.Column;
        for(int col = 0; col< m; col++){
            char colChar=state.Board[0][col];
            for(int row=0;row<n;row++){    
                if(state.Board[row][col]!=colChar){
                    break;
                }
                else if(state.Board[row][col] ==0)
                    break;
                else if(row==n-1){
                    return true;
                }
            }
        }
        return false;
    }
    boolean checkDiagonal(){
        int n = state.Row;
        int m = state.Column;
        char diachar = state.Board[0][0];
        for(int dia = 0;dia<m||dia<n;dia++){
            if( state.Board[dia][dia]!=diachar){
                break;
            }
            else if(state.Board[dia][dia]==0)
                break ;
            else if(dia==m-1||dia==n-1)
                return true;
        }
        diachar = state.Board[0][m-1];
        for(int dia = m-1;dia>=0;dia--){
            if(state.Board[m-dia-1][dia]!=diachar){
                break;
            }
            else if(state.Board[m-1-dia][dia]==0)
                break ;
            else if(dia==0)
                return true;
        }

        return false;
    }
}