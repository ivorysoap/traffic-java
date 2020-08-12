public enum IntersectionType {

    TWO_WAY(2),     // Unimplemented
    THREE_WAY(3),   // Unimplemented
    FOUR_WAY(4);

    
    private final int index;

    // Constructor
    IntersectionType(int index) {
        this.index = index;
    }

    /**
     * Returns index of the enum value.
     * 
     * @return index
     */
    public int getIndex() {
        return index;
    }


}
