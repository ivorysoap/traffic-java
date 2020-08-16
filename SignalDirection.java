public enum SignalDirection {

    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    private final int index;

    // Constructor
    SignalDirection(int index) {
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
