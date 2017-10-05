public enum Rainbow {

    RED("#ff0000"),
    ORANGE("#ff7f00"),
    YELLOW("#ffff00"),
    GREEN("#008000"),
    BLUE("#0000ff"),
    INDIGO("#4b0082"),
    VIOLET("#7f007f");

    private final String hexCode;

    /**
     * Creates a Rainbow enum
     * @param hexCode String representation of color hex code
     */
    Rainbow(String hexCode) {
        this.hexCode = hexCode;
    }

    /**
     * Getter method for color hex code
     * @return String representation of color hex code
     */
    public String getHexCode() {
        return hexCode;
    }

}