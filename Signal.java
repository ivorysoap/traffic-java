public class Signal {

    enum Type {
        STANDARD,
        PROTECTED_LEFT
    }

    enum State {
        RED,
        AMBER,
        GREEN,
        RED_PROTECTED_GREEN,
        RED_PROTECTED_AMBER,
        GREEN_PROTECTED_GREEN,
        GREEN_PROTECTED_AMBER,
        FLASHING_RED,
        FLASHING_AMBER,
        OUT_OF_SERVICE        
    }

    private final Type type;
    private State state;


    // Constructor
    public Signal(Type type, State state){
        
        this.type = type;
        this.state = state;

    }


    // Getters
    public Type getType(){ return type; }

    public State getState(){ return state; }

    //Setters
    public void setState(State state){ this.state = state; }

    
}