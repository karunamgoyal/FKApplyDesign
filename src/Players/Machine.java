package src.Players;

import src.State.Point;
import src.State.StateInterface;
import java.util.Random;

public class Machine implements Player{
    
    int row,column;
    private char SYMBOL;
    public Machine(char Symbol,StateInterface state){
        SYMBOL = Symbol;
        this.row = state.getRowLevel();
        this.column = state.getColumnLevel();
    }
    public char getSymbol(){
        return SYMBOL;
    }
    @Override
    public Point playMove(){
        Random r=new Random();
        int x=r. nextInt(row);
        int y=r. nextInt(column);
        Point p = new Point(x,y);
        return p;
    }
    @Override 
    public Point wrongMove(){
        return playMove();
    }

}

