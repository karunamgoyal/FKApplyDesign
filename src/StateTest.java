package src;
import junit.framework.TestCase;
import src.State.StateInterface;
import src.State.StateManager;
import src.State.StateUpdater;
import src.State.State;
import src.State.Point;
public class StateTest extends TestCase {
    

    public void testAdd() {
        checkRow();
        checkColumn();
        checkDiagonal();
        checkValidPoint();
    }
    public void checkValidPoint(){
        StateInterface state = new State(3,2);
        
        assertTrue(StateUpdater.isValid(new Point(-1,-1), state)==false);
        assertTrue(StateUpdater.isValid(new Point(-1,0), state)==false);
        assertTrue(StateUpdater.isValid(new Point(-1,-3), state)==false);
        assertTrue(StateUpdater.isValid(new Point(-1,1000), state)==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(1,1),'O', state);
        assertTrue(state.isMarked(new Point(1,1))==true);
        StateUpdater.updateMove(new Point(2,0),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(1,2),'O', state);
        StateUpdater.updateMove(new Point(3,0),'X', state);
        StateUpdater.updateMove(new Point(1,3),'O', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(4,0),'X', state);
        StateUpdater.updateMove(new Point(1,4),'O', state);
        StateUpdater.updateMove(new Point(5,0),'X', state);
        StateUpdater.updateMove(new Point(1,5),'O', state);
        StateUpdater.updateMove(new Point(6,0),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(1,6),'O', state);
        StateUpdater.updateMove(new Point(7,0),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(1,7),'O', state);
        StateUpdater.updateMove(new Point(8,0),'X', state);
        assertTrue(StateManager.hasWon(state, 'O')==false);
    }
    public void checkDiagonal(){
        StateInterface state = new State(3,2);
        StateUpdater.updateMove(new Point(0,0),'X', state);
        StateUpdater.updateMove(new Point(1,0),'O', state);
        StateUpdater.updateMove(new Point(1,1),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(2,1),'O', state);
        StateUpdater.updateMove(new Point(2,2),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(1,2),'O', state);
        StateUpdater.updateMove(new Point(3,3),'X', state);
        StateUpdater.updateMove(new Point(1,3),'O', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(4,4),'X', state);
        StateUpdater.updateMove(new Point(1,4),'O', state);
        StateUpdater.updateMove(new Point(5,5),'X', state);
        StateUpdater.updateMove(new Point(1,5),'O', state);
        StateUpdater.updateMove(new Point(6,6),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(1,6),'O', state);
        StateUpdater.updateMove(new Point(7,7),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(1,7),'O', state);
        StateUpdater.updateMove(new Point(8,8),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==true);
        assertTrue(StateManager.hasWon(state, 'O')==false);
    }
    public void checkColumn(){
        StateInterface state = new State(3,2);
        StateUpdater.updateMove(new Point(0,0),'X', state);
        StateUpdater.updateMove(new Point(1,0),'O', state);
        StateUpdater.updateMove(new Point(1,0),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(1,1),'O', state);
        StateUpdater.updateMove(new Point(2,0),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(1,2),'O', state);
        StateUpdater.updateMove(new Point(3,0),'X', state);
        StateUpdater.updateMove(new Point(1,3),'O', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(4,0),'X', state);
        StateUpdater.updateMove(new Point(1,4),'O', state);
        StateUpdater.updateMove(new Point(5,0),'X', state);
        StateUpdater.updateMove(new Point(1,5),'O', state);
        StateUpdater.updateMove(new Point(6,0),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(1,6),'O', state);
        StateUpdater.updateMove(new Point(7,0),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(1,7),'O', state);
        StateUpdater.updateMove(new Point(8,0),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==true);
        assertTrue(StateManager.hasWon(state, 'O')==false);
    }
    public void checkRow(){
        StateInterface state = new State(3,2);
        StateUpdater.updateMove(new Point(0,0),'X', state);
        StateUpdater.updateMove(new Point(1,0),'O', state);
        StateUpdater.updateMove(new Point(0,1),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(1,1),'O', state);
        StateUpdater.updateMove(new Point(0,2),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(1,2),'O', state);
        StateUpdater.updateMove(new Point(0,3),'X', state);
        StateUpdater.updateMove(new Point(1,3),'O', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(0,4),'X', state);
        StateUpdater.updateMove(new Point(1,4),'O', state);
        StateUpdater.updateMove(new Point(0,5),'X', state);
        StateUpdater.updateMove(new Point(1,5),'O', state);
        StateUpdater.updateMove(new Point(0,6),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(1,6),'O', state);
        StateUpdater.updateMove(new Point(0,7),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(1,7),'O', state);
        StateUpdater.updateMove(new Point(0,8),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==true);
        assertTrue(StateManager.hasWon(state, 'O')==false);
    }
}