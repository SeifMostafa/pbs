import java.util.List;

public class LongestSubSeq_Fib {
    public int lenLongestFibSubseq(int[] arr) {
        int len = 0;
        int len_reversed = 0;
        int a = 0, b = 1;
        int reversed_a = arr.length - 1;
        int reversed_b = arr.length - 2;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == arr[a] + arr[b]) {
                len++;
                a = b;
                b = i;
            } else if (arr[a] + arr[b] < arr[i]) {
                a = a + 1;
                b = b + 1;
            }
            if (arr[reversed_a] == arr[arr.length - i + 1] + arr[reversed_b]) {
                len_reversed++;
                reversed_a = reversed_b;
                reversed_b = arr.length - i + 1;
            } else if (arr[reversed_a] > arr[reversed_b] + arr[arr.length - i + 1]) {
                reversed_a = reversed_a - 1;
                reversed_b = reversed_b - 1;
            }
        }
        if (arr[reversed_a] == arr[1] + arr[reversed_b]) {
            len_reversed++;
            reversed_a = reversed_b;
            if(arr[reversed_a] == arr[1] + arr[0])
                len_reversed++;
        }
        len = Math.max(len, len_reversed);
        return len > 0 ? len + 2 : len;
    }
    public static void main(String[] args) {
        LongestSubSeq_Fib v = new LongestSubSeq_Fib();
        System.out.println(v.lenLongestFibSubseq(new int[]{2,4,7,8,9,10,14,15,18,23,32,50}));
    }
}
