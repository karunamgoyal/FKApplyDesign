package src.State;
//Implementation of TicTacToe Game named State representing the current state
public class State extends StateInterface{

    State[][] state;
    public State(int side,int level){
        this.side = side;
        Row = side;
        Column = side;
        this.level = level;
        if(level == 0){
            symbol = '0';
            return ;
        }

        state = new State[Row][Column];

        for(int row = 0; row<Row;row++){
            for(int column = 0 ; column < Column; column++){
                state[row][column]=new State(side,level-1);
            } 
        }
    }

    public State getSubGame(int x,int y){
        return state[x][y];
    }
}