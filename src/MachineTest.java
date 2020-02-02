package src;
import junit.framework.TestCase;
import src.State.StateInterface;
import src.State.StateManager;
import src.State.StateUpdater;
import src.State.State;
import src.State.Hex;
import src.Players.Machine;
import src.State.Point;
public class MachineTest extends TestCase {
    

    public void testAdd() {
        checkLimit();

    }
    public void checkLimit(){
        StateInterface state = new State(3,2);
        Machine machine = new Machine('X', state);

        
        assertTrue(machine.playMove().getX()<state.getRowLevel());
        assertTrue(machine.playMove().getY()<state.getColumnLevel());
         
        assertTrue(machine.playMove().getX()<state.getRowLevel());
        assertTrue(machine.playMove().getY()<state.getColumnLevel());
         
        assertTrue(machine.playMove().getX()<state.getRowLevel());
        assertTrue(machine.playMove().getY()<state.getColumnLevel());
         
         
        assertTrue(machine.playMove().getX()>=0);
        assertTrue(machine.playMove().getY()>=0);
         
        assertTrue(machine.playMove().getX()<state.getRowLevel());
        assertTrue(machine.playMove().getY()<state.getColumnLevel());
         
         
        assertTrue(machine.playMove().getX()<state.getRowLevel());
        assertTrue(machine.playMove().getY()<state.getColumnLevel());

        state = new Hex(3,2);

        assertTrue(machine.playMove().getX()<state.getRowLevel());
        assertTrue(machine.playMove().getY()<state.getColumnLevel());
         
        assertTrue(machine.playMove().getX()<state.getRowLevel());
        assertTrue(machine.playMove().getY()<state.getColumnLevel());
         
        assertTrue(machine.playMove().getX()<state.getRowLevel());
        assertTrue(machine.playMove().getY()<state.getColumnLevel());
         
         
        assertTrue(machine.playMove().getX()>=0);
        assertTrue(machine.playMove().getY()>=0);
         
        assertTrue(machine.playMove().getX()<state.getRowLevel());
        assertTrue(machine.playMove().getY()<state.getColumnLevel());
         
         
        assertTrue(machine.playMove().getX()<state.getRowLevel());
        assertTrue(machine.playMove().getY()<state.getColumnLevel());
         
    }
    
}