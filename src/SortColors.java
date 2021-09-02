public class SortColors {

    public static void main(String[] args) {
        int[] nums = {1,2,0};
        int start = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high){
            if(nums[mid] == 0){
                int temp = nums[mid];
                nums[mid] = nums[start];
                nums[start] = temp;
                start++;
                mid++;
            }
            else if(nums[mid] == 2){
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
                mid++;
            }
            else{
                mid++;
            }

        }
    System.out.println(nums.toString());
    }

}
