import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Intersection {

    private final IntersectionType intersectionType;
    private final ArrayList<Signal> signals = new ArrayList<Signal>();
    private boolean disabled = false;

    // Constructor
    public Intersection(IntersectionType intersectionType) {
        this.intersectionType = intersectionType;

        for(int i = 0; i < intersectionType.getIndex(); i++)
            signals.add(new Signal());

        this.main();
    }

    public void main() {

        if(this.disabled) {
            setSignalStates(Signal.State.FLASHING_RED);
        }
        else if(!this.disabled) {

            setSignalStates(Signal.State.RED);

            while(!this.disabled) {
                try {
                    runIntersection();  // Main behaviour of the intersection is here.
                }
                catch(InterruptedException e) {
                    System.out.println("Caught exception: " + e);
                }
            }
        }

    }

    /**
     * Set the state of ALL the signals in this Intersection's list of signals, all at once.
     * @param state the state to set.
     */
    private void setSignalStates(Signal.State state) {
        for(Signal signal : this.signals)
            signal.setState(state);
    }

    /**
     * Set the state of ONE the signals in this Intersection's list of signals, based on the direction of traffic it manages.
     * @param state the state to set.
     * @param direction which traffic light to change.
     */
    private void setSignalStates(Signal.State state, SignalDirection direction) {
        // TODO Implement this method
        // TODO Make the 'signals' ArrayList indexable by direction.
    }

    /**
     * Set the state of TWO the signals in this Intersection's list of signals.
     * @param state the state to set.
     * @param direction1 one of the traffic lights to change.
     * @param direction2 one of the traffic lights to change.
     */
    private void setSignalStates(Signal.State state, SignalDirection direction1, SignalDirection direction2) {
        // TODO Implement this method
        // TODO Make the 'signals' ArrayList indexable by direction.
    }

    /**
     * Method for controlling the intersection.
     */
    private void runIntersection() throws InterruptedException {

        setSignalStates(Signal.State.RED);

        TimeUnit.SECONDS.sleep(5);

        setSignalStates(Signal.State.GREEN, SignalDirection.NORTH, SignalDirection.SOUTH);

        System.out.println(this.toString());

    }

    /**
     * String representation of an Intersection.
     * @return string representation.
     */
    @Override
    public String toString(){

        String output = intersectionType + Integer.toString(this.hashCode()) + "\nSignals list:\n";

        output += "|\t" + signals.get(0) + "\tNORTH\t\t" + "Current state: " + signals.get(0).getState() + "\n";
        output += "|\t" +  signals.get(1) + "\tEAST\t\t" + "Current state: " + signals.get(1).getState() + "\n";
        output += "|\t" +  signals.get(2) + "\tSOUTH\t\t" + "Current state: " + signals.get(2).getState() + "\n";
        output += "|\t" +  signals.get(3) + "\tWEST\t\t" + "Current state: " + signals.get(3).getState() + "\n";

        return output;

    }




}
