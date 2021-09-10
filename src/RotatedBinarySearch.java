public class RotatedBinarySearch {
    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,2};
        int target = 0;

        int pivot = findPivot(nums);
        if(pivot == -1){
            System.out.println(binarySearch(nums, target, 0 , nums.length - 1));
        }

        if(target == nums[pivot]){
            System.out.println(pivot);
        }

        if(target >= nums[0]){
            System.out.println(binarySearch(nums, target, 0 , pivot - 1));
        }
        else{
            System.out.println(binarySearch(nums, target, pivot + 1, nums.length - 1));
        }
    }


    public static int binarySearch(int[] nums, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return -1;
    }


    public static int findPivot(int[] nums){

        int start = 0;
        int end = nums.length  - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(mid < end && nums[mid] > nums[mid + 1]){
                return mid;
            }
            else if(mid > start && nums[mid - 1] > nums[mid]){
                return mid - 1;
            }
            else if(nums[start] < nums[mid]){
                start = mid;
            }
            else if(nums[start] >= nums[mid]){
                end = mid - 1;
            }
        }

        return -1;

    }


}
