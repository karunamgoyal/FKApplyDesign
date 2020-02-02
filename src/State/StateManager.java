package src.State;

public class StateManager{

    
    
    // Visible function for all games

    public static boolean hasWon(StateInterface state,char symbol){
        if(isWinner(symbol, state)){
            return true;
        }
        else{
            return false;
        }
    }
    private static  boolean isWinner(char symbol, StateInterface state) {
        if (state.getLevel() == 0) {
            return state.getSymbol()==symbol;
        }
        if(state instanceof Hex)
            return checkHexRows(symbol,state) || checkHexDiagonals(symbol,state);
        else
            return checkStateRows(symbol,state)||checkStateColumn(symbol,state)|| checkStateDiagonal(symbol,state);
    }
    
    
    
    //TicTacToe Checker
    
    private static  boolean checkStateDiagonal(char symbol, StateInterface state){
        boolean check = true;
        for (int i = 0; i < state.getSize(); i++) {
            if (!isWinner(symbol,state.getSubGame(i, i))) {
                check = false;
                break;
            }
        }

        if (check) return true;
        check = true;
        for (int i = 0; i < state.getSize(); i++) {
            if (!isWinner(symbol,state.getSubGame(state.getSize() - i - 1, i))) {
                check = false;
                break;
            }
        }

        return check;
    }

    private static boolean checkStateRows(char symbol,StateInterface state) {
        int rows = state.getRow();
        int columns = state.getColumn();
        for (int i = 0; i < rows; i++) {
            boolean check = true;
            for (int j = 0; j < columns; j++) {
                if (!isWinner(symbol,state.getSubGame(i, j))) {
                    check = false;
                    break;
                }
            }
            if (check) return true;
        }

        return false;
    }

    private static boolean checkStateColumn(char symbol, StateInterface state) {
        int rows = state.getRow();
        int columns = state.getColumn();
        for (int i = 0; i < rows; i++) {
            boolean check = true;
            for (int j = 0; j < columns; j++) {
                if (!isWinner(symbol,state.getSubGame(j, i))) {
                    check = false;
                    break;
                }
            }
            if (check) return true;
        }

        return false;
    }


    // Hex Checker
    public static  boolean checkHexDiagonals(char symbol,StateInterface state) {

        Hex tempGame = new Hex(state.getSize(), 1);
        int rows = state.getRow();
        int columns = state.getColumn();

        for (int j = rows / 2; j < columns - rows / 2; j += 2) {
            boolean check = true;

            for (int i = 0, k = j; StateUpdater.isValid(new Point(i, k),tempGame); i++, k++) {
                if (!isWinner(symbol,state.getSubGame(i, k))) {
                    check = false;
                    break;
                }
            }

            if (check) return true;
        }

        for (int i = 1; i <= rows / 2; i++) {
            int j = Math.abs(i - rows / 2);
            boolean check = true;
            for (int k = i; StateUpdater.isValid(new Point(k, j),tempGame); k++, j++) {
                if (!isWinner(symbol,state.getSubGame(k, j))) {
                    check = false;
                    break;
                }
            }
            if (check) return true;
        }

        for (int j = rows / 2; j < columns - rows / 2; j += 2) {
            boolean check = true;

            for (int i = 0, k = j; StateUpdater.isValid(new Point(i, k),tempGame); i++, k--) {
                if (!isWinner(symbol,state.getSubGame(i, k))) {
                    check = false;
                    break;
                }
            }

            if (check) return true;
        }

        for (int i = 1; i <= rows / 2; i++) {
            int j = columns - Math.abs(i - (rows / 2)) - 1;
            boolean check = true;
            for (int k = i; StateUpdater.isValid(new Point(k, j),tempGame); k++, j--) {
                if (!isWinner(symbol,state.getSubGame(k, j))) {
                    check = false;
                    break;
                }
            }
            if (check) return true;
        }

        return false;
    }

    private static  boolean checkHexRows(char symbol, StateInterface state) {
        int rows = state.getRow();
        int columns = state.getColumn();
        for (int i = 0; i < rows; i++) {
            boolean check = true;

            for (int j = Math.abs(i - rows / 2); j < columns - Math.abs(i - (rows / 2)); j += 2) {
                if (!isWinner(symbol,state.getSubGame(i, j))) {
                    check = false;
                    break;
                }
            }

            if (check) return true;
        }

        return false;
    }

    
}