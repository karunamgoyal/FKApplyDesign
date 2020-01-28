package src.State;

public class State{
    public int Row;
    public int Column;
    char [][] Board;
    int numberofStates;
    public State(int side){
        Row = side;
        Column = side;
        numberofStates = 0;
        Board = new char[Row][Column];
        for(int row = 0; row<Row;row++){
            for(int column = 0 ; column < Column; column++){
                Board[row][column]=0;
            } 
        }
    }
    public State(int RowNew,int ColumnNew){
        Row = RowNew;
        Column = ColumnNew;
        Board = new char[Row][Column];
        for(int row = 0; row<Row;row++){
            for(int column = 0 ; column < Column; column++){
                Board[row][column]=0;
            } 
        }
    }
    public static void printState(State [][] state, int level){
        for(int i=0 ; i < Math.pow(3,level-1);i++){
            for(int row =0 ;row<3;row++){
                for(int j=0 ; j < Math.pow(3,level-1);j++){
                    for(int col=0;col<3;col++){
                        if(state[i][j].Board[row][col]!=0){
                            System.out.print(" "+state[i][j].Board[row][col]+" ");
                        }
                        else{
                            System.out.print(" * ");
                        }
                    }
                    
                }
                System.out.println();
            }   
        }
    }
    public void printState(){
           
        for(int row =0 ;row<Row;row++){
            for(int col=0;col<Column;col++){
                if(Board[row][col]!=0){
                    System.out.print(" "+Board[row][col]+" ");
                }
                else{
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
    }



}