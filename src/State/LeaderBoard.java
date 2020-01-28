package src.State;

import java.util.ArrayList;

public class LeaderBoard {
    int Score;
    String Name;
    ArrayList<Integer> LevelScore = new ArrayList<>();
    
    public LeaderBoard(String name){
        Score = 0;
        Name = new String(name);
    }
    public void add(int score){
        this.Score += score;
        LevelScore.add(score);        
    }
    public void showScore(){
        System.out.println(Score);
    }




}