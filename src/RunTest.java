package src;
import src.Playground.PlayGround;
import src.Players.Human;
import src.Players.Machine;
import src.State.Point;

public class RunTest{

    public static void main(String[] args) {
        PlayGround play = new PlayGround();
        if(play.startGame()){
            System.out.println("Game Finished Successfully");
        }
    }   
}