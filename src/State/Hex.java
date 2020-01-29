package src.State;

public class Hex implements StateInterface{
    
    char[][] Board;
    int Row;
    int side;
    int Column;
    char Symbol;
    int level;
    int check;
    int numberofStates;
    public Hex(int side){
        this.side = side;
        Row = 2*side-1;
        Column = 2*Row-1;
        check = 0;
        numberofStates = 0;
        Board = new char[Row][Column];
        for(int row = 0; row<Row;row++){
            for(int column = Math.abs(row-(Row/2)) ; column < Column-Math.abs(row-(Row/2)); column+=2){
                Board[row][column]='0';
            } 
        }
        for(int row = 0; row<Row;row++){
            for(int column = 0 ; column < Column; column++){
                if(Board[row][column]!='0'){
                    Board[row][column]='#';
                }
            } 
        }
        
    }
    public Hex(int side,int var){
        this.side = side;
        Row = 2*side-1;
        Column = 2*Row-1;
        check = -1;
        numberofStates = 0;
        Board = new char[Row][Column];
        for(int row = 0; row<Row;row++){
            for(int column = 0 ; column < Column; column++){
                    Board[row][column]='#';
            } 
        }
        
    }
    public int getCheck(){
        return check;
    }
    public void printState(StateInterface [][] state, int level){
        for(int i=0 ; i < Math.pow(Row,level-1);i++){
            for(int row =0 ;row<Row;row++){
                for(int j=0 ; j < Math.pow(Column,level-1);j++){
                    for(int col=0;col<Column;col++){
                        if(state[i][j].getBoard()[row][col]=='0'){
                            System.out.print(" "+state[i][j].getBoard()[row][col]+" ");
                        }
                        else{
                            System.out.print("   ");
                        }
                    }
                    
                }
                System.out.println();
            }   
        }
    }
    public void changeCount(int i){
        numberofStates+=i;
    }
    public int getCount(){
        return numberofStates;
    }
    public char[][] getBoard(){
        return Board;
    }

    public int getRow(){
        return Row;
    }

    public int getColumn(){
        return Column;
    }

    public void printState(){
        for(int row =0 ;row<Row;row++){
            for(int col=0;col<Column;col++){
                if(Board[row][col]=='0'){
                    System.out.print(" "+Board[row][col]+" ");
                }
                else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }


}