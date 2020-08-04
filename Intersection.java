import java.util.ArrayList;

public class Intersection {

    private final IntersectionType intersectionType;
    private final ArrayList<Signal> signals = new ArrayList<Signal>();
    private boolean disabled = false;


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
     * Set the state of all the signals in this Intersection's list of signals, all at once.
     * @param state the state to set.
     */
    private void setSignalStates(Signal.State state) {
        for(Signal signal : this.signals)
            signal.setState(state);
    }

    /**
     * String representation of an Intersection.
     * @return string representation.
     */
    @Override
    public String toString(){
        return intersectionType + "\nSignals list:" + signals;
    }




}
