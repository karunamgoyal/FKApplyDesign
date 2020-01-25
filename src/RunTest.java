package src;
import src.Playground.PlayGround;
import src.Players.Human;
import src.Players.Machine;
import src.State.Point;
import java.util.Scanner;

public class RunTest{

    public static void main(String[] args) {
        System.out.println("********WELCOME to TIC-TAC-TOE********");
        System.out.println("********         MENU         ********");
        System.out.println("1. One Player");
        System.out.println("2. Two Player");
        System.out.println("Enter The Number");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        if(number==1||number==2) {
            PlayGround play = new PlayGround(number);
            if (play.startGame()) {
                System.out.println("Game Finished Successfully");
            } else {
                System.out.println("Some Unfortunate Error in the Game");
            }
        }
        else{
            System.out.println("Enter Right Number Next Time");
        }
    }   
}