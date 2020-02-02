package src.State;
// Abstract Class for TicTacToe Game and Hex Game
public abstract class StateInterface{
    int level;
    int Row;
    int Column;
    int side;
    char symbol;
    abstract public StateInterface getSubGame(int i,int j);
    public int getRowLevel(){
        return (int) Math.pow(Row, level);
    }
    public int getColumnLevel(){
        return (int) Math.pow(Column, level);
    }
    public int getRow(){
        return Row;
    }
    public int getColumn(){
        return Column;
    }
    public int getSize(){
        return side;
    }
    public int getLevel(){
        return level;
    }
    public void setSymbol(char Symbol){
        symbol = Symbol;
    }
    public char getSymbol(){
        return symbol;
    }
    public boolean isMarked(Point p){
        return getSymbol(p)!='0';
    }
    //Print The game state
    public void printGame(){
        int rows = getRowLevel();
        int col = getColumnLevel();

        for(int i = 0; i< rows ; i++){
            for(int j = 0; j < col ; j++){
                if(StateUpdater.isValid(new Point(i,j), this)){
                    if(isMarked(new Point(i,j))){
                        System.out.print("   "+getSymbol(new Point(i,j))+"   ");
                    }
                    else{
                        System.out.print(" ("+i+","+j+") ");
                    }
                }
                else{
                    System.out.print("       ");
                }
            }
            System.out.println();
        }

    }
    public char getSymbol(Point move){

        if(level == 0){
            return getSymbol();
        }

        int moveX = move.getX();
        int moveY = move.getY();

        int currentLevel = this.level;
        StateInterface currentGame = this;
        while(currentGame != null && currentLevel > 0){
            int hexXIndex= moveX / (int) Math.pow(Row, currentLevel-1);
            int hexYIndex= moveY / (int) Math.pow(Column, currentLevel-1);
            moveX = moveX % (int) Math.pow(Row, currentLevel -1);
            moveY = moveY % (int) Math.pow(Column, currentLevel -1);
            currentGame = currentGame.getSubGame(hexXIndex, hexYIndex);
            currentLevel--;
        }
        if(currentGame != null)
            return currentGame.getSymbol(move);
        
        return ' ';

    }
}