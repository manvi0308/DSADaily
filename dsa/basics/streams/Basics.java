package basics.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class Basics {
    public static void main(String[] args) {
        List<String> names = List.of( "Alice", "Bob", "Charlie", "Duke" );

        List<String> res = names.stream()
                        .filter(n -> n.startsWith( "A") )
                        .map(String::toUpperCase)
                        .toList();

        System.out.println(res);
        // top 3 frequent words
        String sentence = "Manvi Loves Sanvik, Sanvik loves Manvi, Everyone loves Sanvik";

        Arrays.stream(sentence.toLowerCase().split("\\s+"))
                // groupingBy and counting for arrangement 
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3) // for top 3
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", "));
    }
}
