import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class StreamsExample {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> noEmptyStrings = new ArrayList();

        for (String s : strings) {
            if (!s.equals("")) {
                noEmptyStrings.add(s);
            }
        }

        for (String s : noEmptyStrings) {
            System.out.println(s);
        }

        System.out.println();

        strings.stream()
            .filter(string -> !string.isEmpty())
            .forEach(string -> System.out.println(string));

        for (String s : strings) {
            System.out.println(s);
        }
    }
}