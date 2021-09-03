import java.util.*;

class SlidingWindowMedian {
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void main(String args[]) {

        int[] nums = {7,0,3,9,9,9,1,7,2,3};
        int k = 6;

        List<Double> resultList = new ArrayList<>();

        int i = 0;
        for(int j = 0 ; j < nums.length ; j++){
            addNum(nums[j]);
            if(j - i + 1 == k){
                resultList.add(findMedian());
                if(minHeap.contains(nums[i])){
                    minHeap.remove(nums[i]);
                }
                else if(maxHeap.contains(nums[i])){
                    maxHeap.remove(nums[i]);
                }
                i++;
            }

        }

        double[] result = new double[resultList.size()];
        for(int idx = 0 ; idx < result.length ; idx++){
            result[idx] = resultList.get(idx);
        }

        System.out.println(Arrays.toString(result));

    }

    public static void addNum(int num) {
        if(maxHeap.size() == 0){
            maxHeap.add(num);
        }
        else if(maxHeap.size() == minHeap.size()){
            if(num < minHeap.peek()){
                maxHeap.add(num);
            }
            else{
                int top = minHeap.poll();
                minHeap.add(num);
                maxHeap.add(top);
            }

        }
        else{
            if(minHeap.size() == 0){
                if(num >= maxHeap.peek()){
                    minHeap.add(num);
                }
                else{
                    int top = maxHeap.poll();
                    maxHeap.add(num);
                    minHeap.add(top);
                }
            }
            else if(num >= minHeap.peek()){
                minHeap.add(num);
            }
            else{
                if(num < maxHeap.peek()){
                    int top = maxHeap.poll();
                    maxHeap.add(num);
                    minHeap.add(top);
                }
                else{
                    minHeap.add(num);
                }
            }
        }
    }

    public static double findMedian() {

        if(maxHeap.size() > minHeap.size()){
            return (double)maxHeap.peek();
        }
        else{
            return ((double)minHeap.peek() + (double)maxHeap.peek())/2.0;
        }

    }
}
