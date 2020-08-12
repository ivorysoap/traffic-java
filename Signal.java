public class Signal {

    //TODO put these enums into their own files
    enum Type {
        STANDARD,
        PROTECTED_LEFT          // Unimplemented
    }

    enum State {
        RED,
        AMBER,
        GREEN,
        RED_PROTECTED_GREEN,    // Unimplemented
        RED_PROTECTED_AMBER,    // Unimplemented
        GREEN_PROTECTED_GREEN,  // Unimplemented
        GREEN_PROTECTED_AMBER,  // Unimplemented
        FLASHING_RED,           // Unimplemented
        FLASHING_AMBER,         // Unimplemented
        OUT_OF_SERVICE
    }

    private Type type = Type.STANDARD;
    private State state = State.RED;

    // Default constructor
    public Signal() {

    }


    // Constructor
    public Signal(Type type, State state) {

        this.type = type;
        this.state = state;

    }


    // Getters
    public Type getType() {
        return type;
    }

    public State getState() {
        return state;
    }

    //Setters
    public void setState(State state) {
        this.state = state;
    }




}
