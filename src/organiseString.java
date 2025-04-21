import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class organiseString {

    public static String reorganizeString(String s) {
        return s.transform(input -> {
            Map<Character, Integer> freqMap = new HashMap<>();
            for (char ch : input.toCharArray()) {
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            }

            PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
            maxHeap.addAll(freqMap.entrySet());

            StringBuilder result = new StringBuilder();
            Map.Entry<Character, Integer> prev = null;

            while (!maxHeap.isEmpty()) {
                Map.Entry<Character, Integer> current = maxHeap.poll();
                result.append(current.getKey());
                current.setValue(current.getValue() - 1);

                if (prev != null && prev.getValue() > 0) {
                    maxHeap.offer(prev);
                }

                prev = current;
            }
            return result.length() == input.length() ? result.toString() : "";
        });
    }

    public static int minSwaps(String s) {
        Stack<Integer> zeros = new Stack<>();
        Stack<Integer> ones = new Stack<>();

        int prev = 0, curr = s.charAt(0), ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                if (prev == 0) {
                    zeros.add(curr);
                } else {
                    ones.add(curr);
                }
                prev = curr;
                curr = 1;
            } else {
                curr++;
            }
        }
        if (prev == 0) {
            zeros.add(curr);
        } else {
            ones.add(curr);
        }

        while (!zeros.isEmpty() && !ones.isEmpty()) {
            int query = ones.pop();
            int foundEqual = zeros.search(query);
            int foundEqualMinusOne = zeros.search(query - 1);
            if (foundEqual != -1) {
                zeros.remove(foundEqual - 1);
                ans += query / 2;
            } else if (foundEqualMinusOne != -1) {
                zeros.remove(foundEqualMinusOne - 1);
                ans += query / 2;
            } else {
                ones.add(query);
                query = zeros.pop();
                ans += query / 2;
                foundEqual = ones.search(query);
                foundEqualMinusOne = ones.search(query - 1);
                if (foundEqual != -1) {
                    ones.remove(foundEqual - 1);
                    ans += query / 2;
                } else if (foundEqualMinusOne != -1) {
                    ones.remove(foundEqualMinusOne - 1);
                    ans += query / 2;
                } else{
                    return -1;
                }
            }
        }
        if(!zeros.isEmpty()){
            for(int z:zeros)
                if(z>1) return -1;
        }
        if(!ones.isEmpty()){
            for(int o:ones)
                if(o>1) return -1;
        }
        return ans;
    }

    public static void main(String[] args) {

        //System.out.println(minSwaps("11110000"));
        //System.out.println(minSwaps("100"));
        System.out.println(minSwaps("1001"));
    }
}
