import java.util.Arrays;

public class LongestCommonSubsequenceMemo {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        int len1 = text1.length();
        int len2 = text2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }

        System.out.println(helper(text1, text2, len1, len2,dp));
    }

    public static int helper(String text1,String text2,int len1,int len2,int[][] dp){

        if(dp[len1][len2] != -1){
            return dp[len1][len2];
        }

        if(len1 == 0 || len2 == 0){
            return 0;
        }

        if(text1.charAt(len1 - 1) == text2.charAt(len2 - 1)){
            dp[len1][len2] = 1 + helper(text1,text2,len1 - 1,len2 - 1, dp);
            return dp[len1][len2];
        }
        else{
            dp[len1][len2] = Math.max(helper(text1,text2, len1 - 1, len2, dp),helper(text1, text2, len1, len2 - 1, dp));
            return dp[len1][len2];
        }

    }

}
