import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class sumSubArr {
    public static long subArrayRanges(int[] nums) {
        Stack<Integer> history = new Stack<>();
        long sum =0;

        for (int cur : nums) {
            ArrayList<Integer> list = new ArrayList<>();

            int min = cur, max = cur;
            while (!history.isEmpty()) {
                int popped = history.pop();
                list.add(popped);
                if (popped > max) {
                    max = popped;
                }
                if(popped < min){
                    min = popped;
                }
                sum += (max - min);
            }
            for(int i= list.size()-1;i>-1;i--){
                history.push(list.get(i));
            }
            history.push(cur);

        }

        return sum;
    }
    public static void main(String[] args) {

        //System.out.println(minSwaps("11110000"));
        //System.out.println(minSwaps("100"));
        //System.out.println(sequentialDigits(100,300));
        System.out.println(subArrayRanges(new int[]{4,-2,-3,4,1}));
        System.out.println(subArrayRanges(new int[]{1,2,3}));
        System.out.println(subArrayRanges(new int[]{1,3,3}));

    }
}
