package src.Players;

import java.util.Scanner;
import src.State.Point;

public class Human implements Player{
    private char SYMBOL;
    public Human(char Symbol){
        SYMBOL = Symbol;
    }
    public char getSymbol(){
        return SYMBOL;
    }
    @Override
    public Point playMove(){
        Scanner InputUser = new Scanner(System.in);
        System.out.println("Enter Position to Play");
        Integer Row = InputUser.nextInt();
        Integer Column = InputUser.nextInt();
        Point point = new Point(Row, Column);
        InputUser.close();
        return point;
        
    }
    @Override 
    public Point wrongMove(){
        System.out.println("You Entered Wrong Move Enter Move Correctly");
        return playMove();
    }
}