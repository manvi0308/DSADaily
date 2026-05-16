package greedy;

import com.sun.jdi.Value;

import java.util.Arrays;

public class JobSequencing {
    class Pair<K, V>{
        private K Key;
        private V Value;

        public Pair(K key, V value) {
            this.Key = key;
            this.Value = value;
        }
        public K getKey(){
            return Key;
        }
        public V getValue() {
            return Value;
        }
    }
    class Job{
        int id;
        int deadline;
        int profit;
    }

    public Pair<Integer, Integer> jobScheduling( Job[] arr, int n ){
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        int maxi = arr[0].deadline;
        for (int i = 1; i < n; i++){
            maxi = Math.max(maxi, arr[i].deadline);
        }
        int[] slots = new int[maxi + 1];
        Arrays.fill(slots, -1);
        int countJobs = 0, jobProfit = 0;
        for (int i = 0; i < n; i++){
            for (int j = arr[i].deadline; j > 0; j--){
                if (slots[j] == -1){
                    slots[j] = i;
                    countJobs++;
                    jobProfit += arr[i].profit;
                    break;
                }
            }
        }
        return new Pair<>(countJobs, jobProfit);
    }

}
