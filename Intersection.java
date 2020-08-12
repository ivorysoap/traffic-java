import java.util.ArrayList;

public class Intersection {

    private final IntersectionType intersectionType;
    private final ArrayList<Signal> signals = new ArrayList<Signal>();
    private boolean disabled = false;

    enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST;
    }


    // Constructor
    public Intersection(IntersectionType intersectionType) {
        this.intersectionType = intersectionType;

        for(int i = 0; i < intersectionType.getIndex(); i++)
            signals.add(new Signal());
    }

    public void main(String[] args) {

        if(this.disabled) {
            setSignalStates(Signal.State.FLASHING_RED);
        }
        else if(!this.disabled) {

            setSignalStates(Signal.State.RED);

            while(!this.disabled) {
                // Intersection behaviour goes here
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
    private void setSignalStates(Signal.State state, Direction direction) {
        // Unimplemented
    }

    /**
     * Set the state of TWO the signals in this Intersection's list of signals.
     * @param state the state to set.
     * @param direction1 one of the traffic lights to change.
     * @param direction2 one of the traffic lights to change.
     */
    private void setSignalStates(Signal.State state, Direction direction1, Direction direction2) {
        // Unimplemented
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
