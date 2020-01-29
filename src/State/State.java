package src.State;

public class State implements StateInterface{
    public int Row;
    public int Column;
    char [][] Board;
    int numberofStates;
    int side ;
    int check;
    public void changeCount(int i){
        numberofStates+=i;
    }
    public int getCount(){
        return numberofStates;
    }
    public int getCheck(){
        return check;
    }
    public State(int side){
        this.side = side;
        check = 0;
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
    public void printState(StateInterface [][] state, int level){
        for(int i=0 ; i < Math.pow(Row,level-1);i++){
            for(int row =0 ;row<Column;row++){
                for(int j=0 ; j < Math.pow(Column,level-1);j++){
                    for(int col=0;col<side;col++){
                        if(state[i][j].getBoard()[row][col]!=0){
                            System.out.print(" "+state[i][j].getBoard()[row][col]+" ");
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
    public int getRow(){
        return Row;
    }
    public int getColumn(){
        return Column;
    }
    public char [][] getBoard(){
        return Board;
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