import java.util.ArrayList;
import java.util.List;

public class sqDigit {
    public static List<Integer> sequentialDigits(int low, int high) {
        int cur = low;
        int finish = high;

        // fetch starting digit from low limit
        int digits = 0;
        while(cur >= 10){
            cur/=10;
            digits++;
        }
        // fetching finishing digit from high limit and digit difference between low & high
        int high_low_digit_diff = high/low;
        while(digits > 1){
            finish/=10;
            digits--;
        }
        while(high_low_digit_diff > 1){
            finish/=10;
            high_low_digit_diff/=10;
        }
        // processing
        List<Integer> arr = new ArrayList<>();
        while(low<high){
            StringBuilder sb = new StringBuilder();
            for(int i=cur;i<finish+cur;i++){
                sb.append(i);
                if(Integer.parseInt(sb.toString())>high){
                    sb.deleteCharAt(sb.length()-1);
                    break;
                }
            }
            arr.add(Integer.parseInt(sb.toString()));
            cur++;
        }
        return arr;
    }
    public static void main(String[] args) {

        //System.out.println(minSwaps("11110000"));
        //System.out.println(minSwaps("100"));
        //System.out.println(sequentialDigits(100,300));
        System.out.println(sequentialDigits(1000,13000));

    }
}
