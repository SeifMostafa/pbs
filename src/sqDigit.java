public class sqDigit {
    public List<Integer> sequentialDigits(int low, int high) {
        int cur = low;
        while(cur/10>0)
            cur/=10;
        List<Integer> arr = new ArrayList<>();
        List<Integer> iterativeAdd;

        while(cur<high){
            String s = "" + String.valueOf(cur).charAt(0);
            for(char c:s){

            }
        }
    }
}
