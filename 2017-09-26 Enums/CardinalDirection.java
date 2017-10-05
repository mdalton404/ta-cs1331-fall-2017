public enum CardinalDirection {
    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W");

    private String abbr;
    CardinalDirection (String abbr) {
        this.abbr = abbr;
    }

    public String printAbbr() {
        return this.abbr;
    }
}