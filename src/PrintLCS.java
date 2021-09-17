public class PrintLCS {
    public static void main(String[] args) {
        String text1 = "ABCDGH";
        String text2 = "AEDFHR";

        int len1 = text1.length();
        int len2 = text2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++) {
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1 ; i < dp.length ; i++){
            for(int j = 1 ; j < dp[0].length ; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder resultBuilder = new StringBuilder();

        int i = len1;
        int j = len2;

        while(i >  0 || j > 0){
            if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                resultBuilder.insert(0,text1.charAt(i - 1));
                i--;
                j--;
            }
            else{
                if(dp[i - 1][j] > dp[i][j - 1]){
                    i--;
                }
                else{
                    j--;
                }
            }
        }

        System.out.println(resultBuilder.toString());


    }
}
