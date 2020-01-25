package src.State;

public class State{
    public int Row;
    public int Column;
    char [][] Board;
    public State(){
        Row = 3;
        Column = 3;
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