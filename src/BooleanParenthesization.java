import java.util.Arrays;

public class BooleanParenthesization {

    static int[][] dpt = new int[201][201];
    static int[][] dpf = new int[201][201];

    public static void main(String[] args) {
        for(int[] rows : dpt){
            Arrays.fill(rows, -1);
        }

        for(int[] rows : dpf){
            Arrays.fill(rows, -1);
        }

        String S = "T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F";
        int N = S.length();

        System.out.println( solve(S, 0 , N - 1, true));
    }

    static int solve(String s, int i , int j, boolean isTrue){

        if(isTrue && dpt[i][j] != -1){
            return dpt[i][j];
        }

        if(!isTrue && dpf[i][j] != -1){
            return dpf[i][j];
        }


        if(i > j){
            return 0;
        }
        if(i == j){
            if(isTrue){
                if(s.charAt(i) == "T".charAt(0)){
                    return 1;
                }
                else{
                    return 0;
                }
            }
            else{
                if(s.charAt(i) == "F".charAt(0)){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        }

        int ans = 0;


        for(int k = i + 1 ; k < j ; k += 2){
            int lt = solve(s,i, k - 1, true);
            int rt = solve(s,k + 1, j, true);
            int lf = solve(s,i,k - 1, false);
            int rf = solve(s,k + 1, j, false);


            if(s.charAt(k) == "&".charAt(0)){
                if(isTrue){
                    ans += lt*rt;
                }
                else{
                    ans += lt * rf + lf * rt + lf * rf;
                }
            }
            else if(s.charAt(k) == "|".charAt(0)){
                if(isTrue){
                    ans += lt * rt + lt * rf + lf * rt;
                }
                else{
                    ans += lf * rf;
                }
            }
            else if(s.charAt(k) == "^".charAt(0)){
                if(isTrue){
                    ans += lt * rf + lf * rt;
                }
                else{
                    ans += lt * rt + lf * rf;
                }
            }

        }

        if(isTrue){
            dpt[i][j] = ans;
        }
        else{
            dpf[i][j] = ans;
        }

        return ans;
    }


}
