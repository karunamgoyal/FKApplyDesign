package src.Playground;

import src.Players.Machine;
import java.util.Scanner;
import src.State.LeaderBoard;
import src.Players.Human;
import src.Players.Player;
import src.State.StateManager;
import src.State.StateUpdater;
import src.State.StateInterface;
import src.State.Point;

public class PlayGround {
    Player PlayerOne, PlayerTwo;
    StateInterface state;
    LeaderBoard leaderboard1, leaderboard2;
    int level;
    public PlayGround(int NumberOfPlayers,int level, LeaderBoard leaderboard1, LeaderBoard leaderboard2,
            StateInterface state) {
        this.level = level;
        this.leaderboard1 = leaderboard1;
        this.leaderboard2 = leaderboard2;
        this.state = state;
        if (NumberOfPlayers == 1) {
            PlayerOne = new Human('X');
            PlayerTwo = new Machine('O', state);
        } else {
            PlayerOne = new Human('X');
            PlayerTwo = new Human('O');
        }
    }


    public boolean startGame() {
        boolean GameGoing = true;
        try {
            while (GameGoing) {
                state.printGame();
                playerMove(PlayerOne);
                if(checkFinished(PlayerOne,leaderboard1)){
                    GameGoing = false;
                    return true;
                }  
                playerMove(PlayerTwo);
                if(checkFinished(PlayerTwo,leaderboard2)){
                    GameGoing = false;
                    return true;
                }  
                 
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }



    private void playerMove(Player player) {
        Point playerPoint = player.playMove();
        while ((StateUpdater.isValid(playerPoint, state)==false)||(state.isMarked(playerPoint)==true)) {
            playerPoint = player.wrongMove();
        }

        StateUpdater.updateMove(playerPoint, player.getSymbol(), state);
        state.printGame();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter b if you want to revert move or anything else");
        String check = in.next();
        if (check.equals("b") || check.equals("B")) {
            StateUpdater.updateMove(playerPoint, (char) 0, state);
            playerPoint = PlayerOne.playMove();
            while (!StateUpdater.isValid(playerPoint, state)) {
                playerPoint = PlayerOne.wrongMove();
            }
            StateUpdater.updateMove(playerPoint, player.getSymbol(), state);
        }
        state.printGame();
    }

    private boolean checkFinished(Player player,LeaderBoard leaderBoard){
        if (StateManager.hasWon(state, player.getSymbol())) {
            System.out.println("Player "+player.getSymbol()+" Won");
            leaderBoard.add(level);
            System.out.println("LeaderBoard in Game p1 vs p2");
            leaderboard1.showScore();
            leaderboard2.showScore();
            return true;
        }
        else {
            if (StateUpdater.isFull(state)) {
                System.out.println("Game Drawn");
                return true;
            }
            else 
                return false;
        }
    }

}