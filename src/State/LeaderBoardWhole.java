package src.State;

import java.util.HashMap;

public class LeaderBoardWhole{
    public static HashMap<LeaderBoard, Integer> leaderboard = new HashMap<>();
    public static void addScore(LeaderBoard leader,int score){
        Integer s = leaderboard.get(leader);
        if(s!=null){
            leaderboard.put(leader,s+score);
        }
        else{
            leaderboard.put(leader,score);
        }

    }
    public static void print(){
        leaderboard.forEach( (k,v)->{ System.out.println(k.getName()+ " "+ v );} );
    }
}