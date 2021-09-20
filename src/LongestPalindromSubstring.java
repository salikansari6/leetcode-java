public class LongestPalindromSubstring {
    public static void main(String[] args) {
        String s = "aacabdkacaa";
        int n = s.length();
        String reversed = new StringBuilder(s).reverse().toString();

        int[][] dp = new int[n + 1][n + 1];

        int[] maxIndex = {-1, -1};


        for(int i = 0 ; i < dp.length ; i++){
            dp[i][0] = 0;
        }

        for(int j = 0 ; j < dp[0].length ; j++){
            dp[0][j] = 0;
        }


        int max = 0;
        for(int i = 1 ; i < dp.length ; i++){
            for(int j = 1 ; j < dp[0].length ; j++){
                if(s.charAt(i - 1) == reversed.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if(dp[i][j] > max){
                        max = dp[i][j];
                        maxIndex[0] = i;
                        maxIndex[1] = j;
                    }
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }

        StringBuilder resultBuilder = new StringBuilder();
        int i = maxIndex[0];
        int j = maxIndex[1];

        while(dp[i][j] != 0){
            resultBuilder.insert(0,s.charAt(i - 1));
            i--;
            j--;

        }

        System.out.println(resultBuilder.toString());
    }
}
