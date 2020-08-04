import java.util.ArrayList;

public class Intersection {


    private IntersectionType intersectionType;
    private ArrayList<Signal> signals = new ArrayList<Signal>();


    // Constructor
    public Intersection(IntersectionType intersectionType) { 
        this.intersectionType = intersectionType;
        
        for(int i = 0; i < intersectionType.getIndex(); i++)
            signals.add(new Signal());
            
    }

    @Override
    public String toString(){
        return intersectionType + "\nSignals list:" + signals;
    }




}
