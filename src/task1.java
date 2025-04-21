public class task1 {
    public static int countBinarySubstrings(String s) {
        int ans = 0;
        boolean skipZeros = false, skipOnes = false;


        String query ;
        int index ;
        int nCounter ;

        int n = (s.length() + s.length()%2) / 2;
        for (int i = 1; i <= n; i++) {
            int oldCounter = ans;
            if(!skipZeros){
                query = formAString(i, '1', '0');
                index = s.indexOf(query);
                nCounter = 0;
                while (index != -1) {
                    nCounter++;
                    index = s.indexOf(query, index + 1);
                }
                ans += nCounter;
                if(oldCounter == ans) skipZeros = true;
            }
            oldCounter = ans;
            if(!skipOnes){
                query = formAString(i, '0', '1');
                index = s.indexOf(query);
                nCounter = 0;
                while (index != -1) {
                    nCounter++;
                    index = s.indexOf(query, index + 1);
                }
                ans += nCounter;
                if(oldCounter == ans) skipOnes = true;;
            }

            if(skipZeros && skipOnes) break;

        }
        return ans;
    }

    private static String formAString(int count, char pre, char suf) {
        return String.valueOf(pre).repeat(Math.max(0, count)) +
                String.valueOf(suf).repeat(Math.max(0, count));
    }
    public static void main(String[] args) {
        //System.out.println(countBinarySubstrings("00110011"));
        //System.out.println(countBinarySubstrings("10101"));
        System.out.println(countBinarySubstrings("1011110000")); // 6
    }
}
