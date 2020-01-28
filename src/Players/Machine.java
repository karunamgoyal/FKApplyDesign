package src.Players;

import src.State.Point;
import src.State.State;
import java.util.Random;

public class Machine implements Player{
    
    int side;
    private char SYMBOL;
    public Machine(char Symbol,int side){
        SYMBOL = Symbol;
        this.side=side;
    }
    public char getSymbol(){
        return SYMBOL;
    }
    @Override
    public Point playMove(){
        Random r=new Random();
        int x=r. nextInt(side);
        int y=r. nextInt(side);
        Point p = new Point(x,y);
        return p;
    }
    @Override 
    public Point wrongMove(){
        return playMove();
    }

}
