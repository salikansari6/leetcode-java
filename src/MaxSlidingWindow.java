import java.util.Arrays;
import java.util.List;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        List<Integer> path = Arrays.asList(10,2,-10,5,20);
        int maxStep = 2;
        int i = 0;
        long maxSum = Long.MIN_VALUE;
        long currSum  = 0;
        for(int j = 0 ; j < path.size() ; j++){
            currSum += path.get(j);
            if(j - i + 1 == maxStep){
                maxSum = Math.max(currSum,maxSum);
                currSum -= path.get(i);
                i++;
            }
        }
        System.out.println(maxSum);
    }
}
