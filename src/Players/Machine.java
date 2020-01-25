package src.Players;

import src.State.Point;
import src.State.State;
import java.util.Random;

public class Machine implements Player{
    
    State state;
    private char SYMBOL;
    public Machine(char Symbol,State state){
        SYMBOL = Symbol;
        this.state = state;
    }
    public char getSymbol(){
        return SYMBOL;
    }
    @Override
    public Point playMove(){
        Random r=new Random();
        int x=r. nextInt(state.Row);
        int y=r. nextInt(state.Column);
        Point p = new Point(x,y);
        return p;
    }
    @Override 
    public Point wrongMove(){
        return playMove();
    }

}

