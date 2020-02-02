package src;
import junit.framework.TestCase;
import src.State.StateInterface;
import src.State.StateManager;
import src.State.StateUpdater;
import src.State.Hex;
import src.State.Point;
public class HexTest extends TestCase {
    

    public void testAdd() {
        checkRow();
        checkDiagonal();
        checkValidPoint();
    }
    public void checkValidPoint(){
        StateInterface state = new Hex(2,2);
        
        assertTrue(StateUpdater.isValid(new Point(-1,-1), state)==false);
        assertTrue(StateUpdater.isValid(new Point(-1,0), state)==false);
        assertTrue(StateUpdater.isValid(new Point(-1,-3), state)==false);
        assertTrue(StateUpdater.isValid(new Point(1000,1000), state)==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(8,8),'O', state);
        assertTrue(state.isMarked(new Point(8,8))==true);
        assertTrue(state.isMarked(new Point(3,11))==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
    }
    public void checkDiagonal(){
        StateInterface state = new  Hex(2,2);
        StateUpdater.updateMove(new Point(0,6),'X', state);
        StateUpdater.updateMove(new Point(3,1),'O', state);
        StateUpdater.updateMove(new Point(1,7),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(5,1),'O', state);
        StateUpdater.updateMove(new Point(2,8),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(3,3),'O', state);
        StateUpdater.updateMove(new Point(3,11),'X', state);
        StateUpdater.updateMove(new Point(5,3),'O', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(4,12),'X', state);
        StateUpdater.updateMove(new Point(4,2),'O', state);
        StateUpdater.updateMove(new Point(5,13),'X', state);
        StateUpdater.updateMove(new Point(4,4),'O', state);
        StateUpdater.updateMove(new Point(6,16),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(4,10),'O', state);
        StateUpdater.updateMove(new Point(7,17),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(0,8),'O', state);
        StateUpdater.updateMove(new Point(8,18),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==true);
        assertTrue(StateManager.hasWon(state, 'O')==false);
    }
    public void checkRow(){
        StateInterface state = new Hex(2,2);
        StateUpdater.updateMove(new Point(4,0),'X', state);
        StateUpdater.updateMove(new Point(0,6),'O', state);
        StateUpdater.updateMove(new Point(4,2),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(0,8),'O', state);
        StateUpdater.updateMove(new Point(4,4),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(6,16),'O', state);
        StateUpdater.updateMove(new Point(4,10),'X', state);
        StateUpdater.updateMove(new Point(7,17),'O', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(4,12),'X', state);
        StateUpdater.updateMove(new Point(8,18),'O', state);
        StateUpdater.updateMove(new Point(4,14),'X', state);
        StateUpdater.updateMove(new Point(1,7),'O', state);
        StateUpdater.updateMove(new Point(4,20),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(2,8),'O', state);
        StateUpdater.updateMove(new Point(4,22),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==false);
        assertTrue(StateManager.hasWon(state, 'O')==false);
        StateUpdater.updateMove(new Point(8,8),'O', state);
        StateUpdater.updateMove(new Point(4,24),'X', state);
        assertTrue(StateManager.hasWon(state, 'X')==true);
        assertTrue(StateManager.hasWon(state, 'O')==false);
    }
}