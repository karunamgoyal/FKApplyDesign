package src.State;

public class Hex extends StateInterface{

    Hex[][] hex;
    public Hex(int side,int level){
        this.side = side;
        this.Row = 2*side-1;
        this.Column = 2*Row-1;
        this.level = level;
        if(level == 0){
            symbol = '0';
            return;
        }
        
        hex = new Hex[this.Row][this.Column];

        for(int row = 0; row< Row ; row++){
            for(int col = Math.abs(row-(Row)/2);col < Column - Math.abs(row-(Row)/2);col+=2){
                    hex[row][col] = new Hex(side, level-1);
            }
        }
    }
    public Hex getSubGame(int x,int y){
        return hex[x][y];
    }
  
    
}