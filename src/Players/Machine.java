package src.Players;

import src.State.Point;

public class Machine implements Player{
    
    
    @Override
    public Point playMove(){
        //some Logic
        return new Point();
    }
    @Override 
    public Point wrongMove(){
        System.out.println("You Entered Wrong Move Enter Move Correctly");
        return playMove();
    }
}

