import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Intersection {

    private final IntersectionType intersectionType;
    private final ArrayList<Signal> signals = new ArrayList<Signal>();
    private boolean enabled = true;
    private boolean queuingEnabled = false;

    // Constructor
    public Intersection(IntersectionType intersectionType) {
        this.intersectionType = intersectionType;

        for (int i = 0; i < intersectionType.getIndex(); i++)
            signals.add(new Signal());

        this.main();
    }


    public void main() {

        if (!this.enabled) {
            setSignalStates(SignalState.FLASHING_RED);
        } else {

            initIntersection();

            runIntersection();  // Main behaviour of the intersection is here.

        }

    }

    /**
     * Initialize the intersection by setting the lights to red.
     */
    private void initIntersection() {

        setSignalStates(SignalState.RED);

    }


    /**
     * Main behaviour of the intersection is driven by this method.
     */
    private void runIntersection() {

        try {

            if (!intersectionInitialized()) {
                throw new IllegalStateException("The intersection was not initialized to an all-red state.");  // TODO use a better exception
            } else {

                if (this.intersectionType == IntersectionType.FOUR_WAY) {

                    while (this.enabled) {

                        setSignalStates(SignalState.RED);

                        TimeUnit.SECONDS.sleep(5);

                        setSignalStates(SignalState.GREEN, SignalDirection.NORTH, SignalDirection.SOUTH);

                        System.out.println(this.toString());  // Debug print

                        TimeUnit.SECONDS.sleep(15);

                        setSignalStates(SignalState.AMBER, SignalDirection.NORTH, SignalDirection.SOUTH);

                        System.out.println(this.toString());  // Debug print

                        TimeUnit.SECONDS.sleep(5);

                        setSignalStates(SignalState.RED, SignalDirection.NORTH, SignalDirection.SOUTH);

                        System.out.println(this.toString());  // Debug print

                        TimeUnit.SECONDS.sleep(5);

                        setSignalStates(SignalState.GREEN, SignalDirection.EAST, SignalDirection.WEST);

                        System.out.println(this.toString());  // Debug print

                        TimeUnit.SECONDS.sleep(15);

                        setSignalStates(SignalState.AMBER, SignalDirection.EAST, SignalDirection.WEST);

                        System.out.println(this.toString());  // Debug print

                        TimeUnit.SECONDS.sleep(5);

                        setSignalStates(SignalState.RED, SignalDirection.EAST, SignalDirection.WEST);

                        System.out.println(this.toString());  // Debug print

                    }
                }
                else {
                    System.out.println("Unimplemented");
                    System.exit(0); // TODO Implement this
                }


            }
        } catch (InterruptedException | IllegalStateException e) {
            System.out.println("Caught an exception: " + e);
        }
    }


    /**
     * Set the state of ALL the signals in this Intersection's list of signals, all at once.
     *
     * @param state the state to set.
     */
    private void setSignalStates(SignalState state) {
        for (Signal signal : this.signals)
            signal.setState(state);
    }

    /**
     * Set the state of ONE the signals in this Intersection's list of signals, based on the direction of traffic it manages.
     *
     * @param state     the state to set.
     * @param direction which traffic light to change.
     */
    private void setSignalStates(SignalState state, SignalDirection direction) {

        this.signals.get(direction.getIndex()).setState(state);

    }

    /**
     * Set the state of TWO the signals in this Intersection's list of signals.
     *
     * @param state      the state to set.
     * @param direction1 one of the traffic lights to change.
     * @param direction2 one of the traffic lights to change.
     */
    private void setSignalStates(SignalState state, SignalDirection direction1, SignalDirection direction2) {

        this.signals.get(direction1.getIndex()).setState(state);
        this.signals.get(direction2.getIndex()).setState(state);

    }

    /**
     * Returns true if all the signals in the intersection are red, or false otherwise.
     *
     * @return the readiness state of the intersection.
     */
    private boolean intersectionInitialized() {

        boolean readiness = true;

        for (Signal signal : signals) {
            if (signal.getState() != SignalState.RED)
                readiness = false;
        }

        return readiness;

    }

    /**
     * String representation of an Intersection.
     *
     * @return string representation.
     */
    @Override
    public String toString() {

        String output = intersectionType + Integer.toString(this.hashCode()) + "\nSignals list:\n";

        output += "├── " + signals.get(0) + "\tNORTH\t\t" + "Current state: " + signals.get(0).getState() + "\t\tWaiting vehicles: " + signals.get(0).getQueueLength() + "\n";
        output += "├── " + signals.get(1) + "\tEAST\t\t" + "Current state: " + signals.get(1).getState() + "\t\tWaiting vehicles: " + signals.get(1).getQueueLength() + "\n";
        output += "├── " + signals.get(2) + "\tSOUTH\t\t" + "Current state: " + signals.get(2).getState() + "\t\tWaiting vehicles: " + signals.get(2).getQueueLength() + "\n";
        output += "└── " + signals.get(3) + "\tWEST\t\t" + "Current state: " + signals.get(3).getState() + "\t\tWaiting vehicles: " + signals.get(3).getQueueLength() + "\n";

        return output;

    }


}
