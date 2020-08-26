public class Signal {

    //TODO put these enums into their own files
    enum Type {
        STANDARD,
        PROTECTED_LEFT          // Unimplemented
    }

    private Type type = Type.STANDARD;
    private SignalState state = SignalState.RED;
    private int queueLength = 0;

    // Default constructor
    public Signal() {

    }


    // Constructor
    public Signal(Type type, SignalState state) {

        this.type = type;
        this.state = state;

    }


    // Getters
    public Type getType() {
        return type;
    }

    public SignalState getState() {
        return state;
    }

    public int getQueueLength() { return queueLength; }

    //Setters
    public void setState(SignalState state) {
        this.state = state;
    }

    public void enqueue() { queueLength++; }

    public void dequeue() { queueLength--; }



}
