import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class suggestWords {
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        ArrayList<List<String>> output = new ArrayList<List<String>>();
        for(int i = 0 ;i<searchWord.length();i++){
            String query = searchWord.substring(0,i+1);
            int maxWordsPerQuery = 3;
            List<String> resultWordsPerQuery = new ArrayList<>();
            boolean foundPrefix = false;
            for(int j=0;j<products.length && maxWordsPerQuery > 0 ;j++){
                if(products[j].startsWith(query)){
                    maxWordsPerQuery--;
                    resultWordsPerQuery.add(products[j]);
                    foundPrefix = true;
                }else if(foundPrefix) break;
            }
            output.add(resultWordsPerQuery);
        }
        return output;
    }
    public static void main(String[] args) {

        //System.out.println(minSwaps("11110000"));
        //System.out.println(minSwaps("100"));
        System.out.println(suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
    }
}
