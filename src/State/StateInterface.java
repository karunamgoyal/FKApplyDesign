package src.State;

public interface StateInterface{

    public int getRow();
    public int getColumn();
    public char[][] getBoard();
    public void printState();
    public void changeCount(int i);
    public int getCount();
    public void printState(StateInterface [][] state, int level);
    public int getCheck();
}