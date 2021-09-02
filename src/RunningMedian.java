import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());


    public static void main(String[] args) {
        addNum(1);
        addNum(2);
        findMedian();
        addNum(3);
        findMedian();
    }

    public static double findMedian() {
        if(maxHeap.size() > minHeap.size()){
            return (double)maxHeap.peek();
        }
        else{
            System.out.println((double)(minHeap.peek()+maxHeap.peek())/2);
            return (double)(minHeap.peek()+maxHeap.peek())/2;
        }

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
                if(num > maxHeap.peek()){
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

}
