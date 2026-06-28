package strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationOfString {
    public List<String> uniquePermutations(String s){
        List<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        solve(arr, 0, res);
        return res;
    }

    public void solve(char[] arr, int index, List<String> res){
        if (index == arr.length)
        {
            res.add(new String(arr));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < arr.length; i++){
            if (set.contains(arr[i]))
                continue;
            set.add(arr[i]);

            swap(arr, index, i);
            solve(arr, index + 1, res);
            swap(arr, index, i);
        }
    }
    public void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
