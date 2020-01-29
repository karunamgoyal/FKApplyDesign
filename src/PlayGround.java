package src.Playground;
import src.Players.Machine;

import java.util.Scanner;
import src.State.LeaderBoard;
import src.State.LeaderBoardWhole;
import src.Players.Human;
import src.Players.Player;
import src.State.StateManager;
import src.State.StateUpdater;
import src.State.State;
import src.State.StateInterface;
import src.State.Point;
import src.State.Hex;
public class PlayGround{
    Player PlayerOne,PlayerTwo;
    StateUpdater GameStateUpdater;
    StateInterface[][][] state;
    int level;
    int side;
    StateManager GameStateManager;
    LeaderBoard leaderboard1 , leaderboard2;
    public PlayGround(int NumberOfPlayers,int level,int side,LeaderBoard leaderboard1,LeaderBoard leaderboard2,StateInterface[][][] state){
        this.side = side;
        this.level = level;
        this.leaderboard1 = leaderboard1;
        this.leaderboard2 = leaderboard2;
        this.state = state;   
        GameStateManager = new StateManager();
        GameStateUpdater = new StateUpdater();
        if(NumberOfPlayers == 1){
            PlayerOne = new Human('X');
            PlayerTwo = new Machine('O', side);
        }
        else {
            PlayerOne = new Human('X');
            PlayerTwo = new Human('O');
        }
    }
    public boolean startGame(){
        boolean gameGoing = true;
        try{
            while(gameGoing){
                for(int j=0;j<Math.pow(state[0][0][0].getRow(),level-1);j++){
                    for(int k=0;k<(int)Math.pow(state[0][0][0].getColumn(),level-1);k++){
                        if(state[0][j][k].getCheck()!=-1){
                            char winner = startLevel(state[0][j][k]);
                            for(int i = 1;i<level;i++){
                                int xmove = j/(int)Math.pow(state[0][0][0].getRow(),i-1);
                                int ymove = k/(int)Math.pow(state[0][0][0].getRow(),i-1);
                                Point move = new Point(xmove,ymove);
                                xmove = j/(int)Math.pow(state[0][0][0].getRow(),i);
                                ymove = k/(int)Math.pow(state[0][0][0].getRow(),i);
                                GameStateUpdater.updateMove(move,winner,state[i][xmove][ymove],1);
                            }
                            state[level-1][0][0].printState();
                            boolean checkWinner = GameStateManager.hasWon(state[level-1][0][0]);
                            if(checkWinner){
                                System.out.println("Winner ");
                                LeaderBoardWhole.addScore(leaderboard1, leaderboard1.getScore());
                                LeaderBoardWhole.addScore(leaderboard2, leaderboard2.getScore());
                                return true;
                            }
                            boolean isfull = GameStateUpdater.isFull(state[level-1][0][0]);
                            if(isfull){
                                System.out.println("Drawn");
                                LeaderBoardWhole.addScore(leaderboard1, leaderboard1.getScore());
                                LeaderBoardWhole.addScore(leaderboard2, leaderboard2.getScore());
                                return true;
                            }
                        }
                    }
                    
                }
            }
        }
        catch(Exception e){
            return false;
        }
        return false;
    }
    public char startLevel(StateInterface thisState)throws Exception{
        boolean GameGoing = true;
        boolean isUpdated = false;
        Point back;
        while(GameGoing){
            
            Point playerOnePoint = PlayerOne.playMove();
            while(GameStateUpdater.isNotValid(playerOnePoint,thisState)){
                playerOnePoint = PlayerOne.wrongMove();
            }
            isUpdated = GameStateUpdater.updateMove(playerOnePoint,PlayerOne.getSymbol(),thisState,1);
            back = playerOnePoint;
            if(!isUpdated)
                throw new Exception("Some Error") ;
            
            state[0][0][0].printState(state[0], level);    
            thisState.printState();
            
            Scanner in = new Scanner(System.in);
            
            System.out.println("Enter b if you want to revert move or anything else");
            String check = in.next();
            if(check.equals("b")||check.equals("B")){
                GameStateUpdater.updateMove(playerOnePoint,(char)0,thisState,-1);
                playerOnePoint = PlayerOne.playMove();
                while(GameStateUpdater.isNotValid(playerOnePoint,thisState)){
                    playerOnePoint = PlayerOne.wrongMove();
                }
                isUpdated = GameStateUpdater.updateMove(playerOnePoint,PlayerOne.getSymbol(),thisState,1);
            }
            thisState.printState();
            state[0][0][0].printState(state[0], level);
            if(GameStateManager.hasWon(thisState)){
                System.out.println("Player One Won");
                leaderboard1.add(level);
                System.out.println("LeaderBoard in Game p1 vs p2");
                leaderboard1.showScore();
                leaderboard2.showScore();
                GameGoing = false;
                return 'X';
            }
            if(GameStateUpdater.isFull(thisState)){
                GameGoing = false;
                System.out.println("Game Drawn");
                return '-';
            }
            Point playerTwoPoint = PlayerTwo.playMove();
            while(GameStateUpdater.isNotValid(playerTwoPoint,thisState)){
                playerTwoPoint = PlayerTwo.wrongMove();
            }
           
            isUpdated = GameStateUpdater.updateMove(playerTwoPoint,PlayerTwo.getSymbol(),thisState,1);
            if(!isUpdated)
                throw new Exception("Some Error");
            thisState.printState();
            System.out.println("Enter b if you want to revert move or anything else");
            check = in.next();
            if(check.equals("b")||check.equals("B")){
                GameStateUpdater.updateMove(playerTwoPoint,(char)0,thisState,-1);
                playerTwoPoint = PlayerTwo.playMove();
                while(GameStateUpdater.isNotValid(playerTwoPoint,thisState)){
                    playerTwoPoint = PlayerTwo.wrongMove();
                    GameStateUpdater.updateMove(playerTwoPoint,PlayerTwo.getSymbol(),thisState,1);     
               }
            }
            thisState.printState();
            if(GameStateManager.hasWon(thisState)){
                System.out.println("Player Two Won");
                leaderboard1.add(level);
                System.out.println("LeaderBoard in Game p1 vs p2");
                leaderboard1.showScore();
                leaderboard2.showScore();
                GameGoing = false;
                return 'O';
            }
        }
        
        throw new Exception("Some Error");
            
    }

}