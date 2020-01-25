package src.Players;

import src.State.Point;
public interface Player{

    public Point playMove();
    public Point wrongMove();
    public char getSymbol();

}