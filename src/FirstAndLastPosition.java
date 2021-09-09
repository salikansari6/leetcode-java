import java.util.Arrays;

public class FirstAndLastPosition {

    public static void main(String[] args) {
        int arr[] = {5,7,7,8,8,10};
        int target = 8;

        int start = 0;
        int end = arr.length - 1;
        int[] ans = {-1,-1};


        //Finding start position of target
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] <  target){
                start = mid + 1;
            }
            else if(arr[mid] > target){
                end = mid - 1;
            }
            else{
                ans[0] = mid;
                end = mid - 1;
            }
        }

        //Re-initialize start and end
        start = 0;
        end = arr.length - 1;

        //Finding last position of target
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] <  target){
                start = mid + 1;
            }
            else if(arr[mid] > target){
                end = mid - 1;
            }
            else{
                ans[1] = mid;
                start = mid + 1;
            }
        }


        System.out.println(Arrays.toString(ans));

    }

}
