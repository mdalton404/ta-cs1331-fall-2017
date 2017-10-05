public class RainbowRunner {

    public static void main(String[] args) {

        System.out.println(blend(Rainbow.RED, Rainbow.YELLOW));

        // == or .equals()?
        // Both can be used for enums, but == is preferred in case of null.
        Rainbow rainbow = Rainbow.GREEN;
        // System.out.println(rainbow == Rainbow.RED);
        // System.out.println(rainbow.equals(Rainbow.RED));

        // Enum methods

        // values() returns an array of the enumeration constants
        // for (Rainbow r : Rainbow.values()) {
        //     System.out.println(r);
        // }

        // ordinal() returns the position of the given enumeration constant
        // in its enum declaration where the initial constant is assigned an ordinal of zero
        // System.out.println(rainbow.ordinal());
    }

    /**
     * Takes in two hex code values and finds their middle value
     * @param color1 the hex code value of a color
     * @param color2 the hex cdoe value of a color
     * @return the hex code values that lies between the two passed-in hex codes
     */
    public static String blend(Rainbow color1, Rainbow color2) {
        String[] parsedColor1 = parseColor(color1.getHexCode());
        String[] parsedColor2 = parseColor(color2.getHexCode());
        int[] integers1 = convertToInteger(parsedColor1);
        int[] integers2 = convertToInteger(parsedColor2);
        int[] average = calculateAverage(integers1, integers2);
        String[] averageParsedColor = convertToHex(average);
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < averageParsedColor.length; i++) {
            strBuilder.append(averageParsedColor[i]);
        }
        return strBuilder.toString();
    }

    /**
     * Parse a hexcode into hex values of length two
     * @param hexCode a color hex code value
     * @return a list of hex values of length two
     */
    public static String[] parseColor(String hexCode) {
        String[] parsedColor = new String[3];
        parsedColor[0] = hexCode.substring(1,3);
        parsedColor[1] = hexCode.substring(3,5);
        parsedColor[2] = hexCode.substring(5,7);
        return parsedColor;
    }

    /**
     * Converts a list of hex code values into a list of integers
     * @param hexCodes an list of hex values
     * @return a list of integers
     */
    public static int[] convertToInteger(String[] hexCodes) {
        int[] integers = new int[hexCodes.length];
        for (int i = 0; i < hexCodes.length; i++) {
            integers[i] = (int) Long.parseLong(hexCodes[i], 16);
        }
        return integers;
    }

    /**
     * Averages two values at every index of the lists and
     * Creates a list of these values
     * @param nums1 a list of integers
     * @param nums2 a list of integers
     * @return a list of the average of each integer in the two lists
     */
    public static int[] calculateAverage(int[] nums1, int[] nums2) {
        int[] average = new int[3];
        for (int i = 0; i < nums1.length; i++) {
            average[i] = (nums1[i] + nums2[i]) / 2;
        }
        return average;
    }

    /**
     * Converts a list of integers into a list of hex values
     * @param integers a list of integers
     * @return a list of hex values
     */
    public static String[] convertToHex(int[] integers) {
        String[] hexCodes = new String[integers.length];
        for (int i = 0; i < integers.length; i++) {
            hexCodes[i] = Integer.toHexString(integers[i]);
            if (hexCodes[i].length() == 1) {
                hexCodes[i] = "0" + hexCodes[i];
            }
        }
        return hexCodes;
    }

}