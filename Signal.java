public class Signal {

    private SignalType type = SignalType.STANDARD;
    private SignalState state = SignalState.RED;
    private int queueLength = 0;

    // Default constructor
    public Signal() {

    }


    // Constructor
    public Signal(SignalType type, SignalState state) {

        this.type = type;
        this.state = state;

    }


    // Getters
    public SignalType getType() {
        return type;
    }

    public SignalState getState() {
        return state;
    }

    public int getQueueLength() {
        return queueLength;
    }

    //Setters
    public void setState(SignalState state) {
        this.state = state;
    }

    public void enqueue() {
        queueLength++;
    }

    public void dequeue() {
        queueLength--;
    }


}
