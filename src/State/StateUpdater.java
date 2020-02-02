package src.State;
import src.State.Point;
public class StateUpdater{
    

    public static boolean isValid(Point move, StateInterface state){
        int moveX = move.getX();
        int moveY = move.getY();
        if(moveX <0 || moveX >= state.getRowLevel() || moveY <0 || moveY >= state.getColumnLevel()){
            return false;
        }

        int currentLevel = state.getLevel();
        StateInterface currentGame = state;
        while(currentGame != null && currentLevel > 0){
            int hexXIndex= moveX / (int) Math.pow(state.getRow(), currentLevel-1);
            int hexYIndex= moveY / (int) Math.pow(state.getColumn(), currentLevel-1);
            moveX = moveX % (int) Math.pow(state.getRow(), currentLevel -1);
            moveY = moveY % (int) Math.pow(state.getColumn(), currentLevel -1);
            currentGame = currentGame.getSubGame(hexXIndex, hexYIndex);
            currentLevel--;
        }
        
        return currentGame != null;

    }

    public static void updateMove(Point move, char symbol, StateInterface state ){
        if(state.getLevel() == 0){
            state.setSymbol(symbol);
            return;
        }

        int moveX = move.getX();
        int moveY = move.getY();

        int currentLevel = state.getLevel();
        StateInterface currentGame = state;
        while(currentGame != null && currentLevel > 0){
            int hexXIndex= moveX / (int) Math.pow(state.getRow(), currentLevel-1);
            int hexYIndex= moveY / (int) Math.pow(state.getColumn(), currentLevel-1);
            moveX = moveX % (int) Math.pow(state.getRow(), currentLevel -1);
            moveY = moveY % (int) Math.pow(state.getColumn(), currentLevel -1);
            currentGame = currentGame.getSubGame(hexXIndex, hexYIndex);
            currentLevel--;
        }
        
        if(currentGame!= null){
            updateMove(new Point(moveX,moveY), symbol, currentGame);
        }
        
    }
    public static boolean isFull(StateInterface state) {
        for (int i = 0; i < state.getRowLevel(); i++) {
            for (int j = 0; j < state.getColumnLevel(); j++) {
                Point p = new Point(i, j);
                if (isValid(p,state) && ! state.isMarked(p)) {
                    return false;
                }
            }
        }
        return true;
    }
}