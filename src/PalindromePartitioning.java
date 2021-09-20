import java.util.Arrays;

public class PalindromePartitioning {
    public static void main(String[] args) {

        String str = "nitik";

        int[][] dp = new int[str.length() + 1][str.length() + 1];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }
        int N = str.length() - 1;
        int result =  solve(str, 0 , N, dp);
        System.out.println(result);
    }

    static int solve(String S, int i, int j, int[][] dp){
        if(i >= j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(isPalindrome(S.substring(i,j+1))){
            return 0;
        }

        int minPart = Integer.MAX_VALUE;
        for(int k = i ; k < j ; k++){
            int tempAns = solve(S, i, k, dp) + solve(S, k + 1, j, dp) + 1;
            if(tempAns < minPart){
                minPart = tempAns;
            }
        }
        dp[i][j] = minPart;
        return dp[i][j];
    }

    static boolean isPalindrome(String S){
        int i = 0;
        int j = S.length() - 1;
        while(i <= j){
            if(S.charAt(i) == S.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
