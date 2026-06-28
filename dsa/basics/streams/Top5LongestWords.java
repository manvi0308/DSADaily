package basics.streams;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Top5LongestWords {
    public static void main(String[] args) {
        List<String> words = List.of("Manvi", "is", "the", "best", "I", "Love", "Sanvik" );

        List<String> res = words.stream().sorted(Comparator.comparingInt(String::length).reversed())
                .limit(5)
                .toList();

        System.out.println(res.toString());
    }

}
