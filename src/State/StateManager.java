package src.State;

public class StateManager{

    public StateManager(){ 
    }
    public boolean hasWon(StateInterface state){
        if(state instanceof State){
            if(checkRow(state)||checkColumn(state)||checkDiagonal(state))
                return true;
            else    
                return false;
        }
        else {
            if(checkHexDiagonal(state)||checkHexDiagonalTwo(state)||checkHexRow(state)){
                return true;
            }
            else{
                return false;
            }
        }

    }
    boolean checkHexDiagonal(StateInterface state){
        int ROW = state.getRow();
        int COL = state.getColumn();
        StateUpdater stateUpdater = new StateUpdater();
        for(int row = 0; row<ROW;row++){
            
            for(int column = Math.abs(row-(ROW/2)) ; column < COL-Math.abs(row-(ROW/2)); column+=2){
                char rowChar = state.getBoard()[row][column];
                int i=row;
                int j = column;
                for(;!stateUpdater.isNotValid(new Point(i,j), state);i++,j++){
                    if(rowChar != state.getBoard()[i][j]){
                        break;
                    }
                    else if(state.getBoard()[i][j]=='0')
                    {
                        break;
                    }
                    else if(stateUpdater.isNotValid(new Point(i+1,j+1), state)){
                        return true;
                    }  
                }
            } 
        }
        return false;
    }
    boolean checkHexDiagonalTwo(StateInterface state){
        int ROW = state.getRow();
        int COL = state.getColumn();
        StateUpdater stateUpdater = new StateUpdater();
        for(int row = 0; row<ROW;row++){
            
            for(int column = Math.abs(row-(ROW/2)) ; column < COL-Math.abs(row-(ROW/2)); column+=2){
                char rowChar = state.getBoard()[row][column];
                int i=row;
                int j = column;
                for(;!stateUpdater.isNotValid(new Point(i,j), state);i++,j--){
                    if(rowChar != state.getBoard()[i][j]){
                        break;
                    }
                    else if(state.getBoard()[i][j]=='0')
                    {
                        break;
                    }
                    else if(stateUpdater.isNotValid(new Point(i+1,j-1), state)){
                        return true;
                    }  
                }
            } 
        }
        return false;
    }
    boolean checkHexRow(StateInterface state){
        int ROW = state.getRow();
        int COL = state.getColumn();
        for(int row = 0; row<ROW;row++){
            char rowChar = state.getBoard()[row][Math.abs(row-(ROW/2))];
            for(int column = Math.abs(row-(ROW/2)) ; column < COL-Math.abs(row-(ROW/2)); column+=2){
                if(rowChar != state.getBoard()[row][column]){
                    break;
                }
                else if(state.getBoard()[row][column]=='0')
                {
                    break;
                }
                else if(column == COL - 1 - Math.abs(row -(row - (ROW/2)))){
                    return true;
                }
            } 
        }
        return false;
    }
    boolean checkRow(StateInterface state){
        int n = state.getRow();
        int m = state.getColumn();
        for(int row = 0; row< n; row++){
            char rowChar=state.getBoard()[row][0];
            for(int col=0;col<m;col++){    
                
                if(state.getBoard()[row][col]!=rowChar){
                    break;
                }
                else if(state.getBoard()[row][col]==0)
                    break;
                else if(col==m-1){
                    return true;
                }
            }
        }
        return false;
    }
    boolean checkColumn(StateInterface state){
        int n = state.getRow();
        int m = state.getColumn();
        for(int col = 0; col< m; col++){
            char colChar=state.getBoard()[0][col];
            for(int row=0;row<n;row++){    
                if(state.getBoard()[row][col]!=colChar){
                    break;
                }
                else if(state.getBoard()[row][col] ==0)
                    break;
                else if(row==n-1){
                    return true;
                }
            }
        }
        return false;
    }
    boolean checkDiagonal(StateInterface state){
        int n = state.getRow();
        int m = state.getColumn();
        char diachar = state.getBoard()[0][0];
        for(int dia = 0;dia<m||dia<n;dia++){
            if( state.getBoard()[dia][dia]!=diachar){
                break;
            }
            else if(state.getBoard()[dia][dia]==0)
                break ;
            else if(dia==m-1||dia==n-1)
                return true;
        }
        diachar = state.getBoard()[0][m-1];
        for(int dia = m-1;dia>=0;dia--){
            if(state.getBoard()[m-dia-1][dia]!=diachar){
                break;
            }
            else if(state.getBoard()[m-1-dia][dia]==0)
                break ;
            else if(dia==0)
                return true;
        }

        return false;
    }
}