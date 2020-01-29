package src;
import src.Playground.PlayGround;
import src.Players.Human;
import src.Players.Machine;
import src.State.GameInit;
import src.State.Hex;
import src.State.LeaderBoard;
import src.State.LeaderBoardWhole;
import src.State.Point;
import src.State.StateInterface;

import java.util.Scanner;

public class RunTest{

    public static void main(String[] args) {
        StateInterface state[][][];
        Scanner input = new Scanner(System.in);
        System.out.println("********WELCOME to TIC-TAC-TOE********");
        
        System.out.println("Enter Number of Sides");
        int side = input.nextInt();
        System.out.println("********         MENU         ********");
        System.out.println("1. One Player");
        System.out.println("2. Two Player");
        System.out.println("Enter The Number");
        int number = input.nextInt();
        LeaderBoard leaderboard1 = new LeaderBoard("Player 1");
        LeaderBoard leaderboard2 = new LeaderBoard("Player 2");
        if(number==1||number==2) {
            int level = 1;
            System.out.println("Enter Playing LEveL");
            level = input.nextInt();
            System.out.println("Enter The Game type\n1) TicTacToe 2) Hex");
            int type  = input.nextInt();
            if(type==1){
                state = GameInit.initState(side, level);
            }
            else{
                state = GameInit.initHex(side, level);
            }   
            String ch = "p";
            while(ch.equals("p")){
                PlayGround play = new PlayGround(number,level,side,leaderboard1,leaderboard2,state);
                if (play.startGame()) {
                    System.out.println("Game Finished Successfully");
                } else {
                    System.out.println("Some Unfortunate Error in the Game");
                }
                System.out.println("Leader Board");
                LeaderBoardWhole.print();
                System.out.println("If you wish to continue to next level enter p");
                
                ch = input.next();
                level++;
                
            }
        }
        else{
            System.out.println("Enter Right Number Next Time");
        }


        */
        
    }   
}