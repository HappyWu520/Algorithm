import java.util.ArrayList;

/**
 * Created by HappyWu on 16/6/1.
 */
public class Heap {
    private ArrayList<Integer> heap;
    private int size;

    public Heap(){
        this.heap = new ArrayList<Integer>();
        this.size = this.heap.size();
    }

    public Heap(Integer[] elements){
        this.heap = new ArrayList<Integer>();

        for (Integer i: elements) {
            this.heap.add(i);
        }

        this.size = this.heap.size();
        buildMaxHeap();
    }

    private void buildMaxHeap(){
        int index = parent(heap.size() - 1);
        for (int i = index; i >= 0; i--) {
            max_heapify(i);
        }
    }

    public void max_heapify(int i){
        int l = left(i);
        int r = right(i);
        int largest_index = i;
        if (l <= this.size()-1 && heap.get(l) > heap.get(i)){
            largest_index = l;
        }
        if (r <= this.size()-1 && heap.get(r) > heap.get(largest_index)){
            largest_index = r;
        }
        if (largest_index != i){
            int tmp = heap.get(i);
            heap.set(i,heap.get(largest_index));
            heap.set(largest_index,tmp);

            max_heapify(largest_index);
        }
    }

    public void max_heapify_nonRecursive(int i){
        while(true){
            int l = left(i);
            int r = right(i);
            int largest_index = i;
            if (l <= this.heap.size() && heap.get(l) > heap.get(i)){
                largest_index = l;
            }
            if (r <= this.heap.size() && heap.get(r) > heap.get(largest_index)){
                largest_index = r;
            }
            if (largest_index != i){
                int tmp = heap.get(i);
                heap.set(i,heap.get(largest_index));
                heap.set(largest_index,tmp);

                i = largest_index;
            }
            else
                break;
        }
    }

    public void heapSort(){
        for (int i = this.heap.size()-1; i >= 1; i--) {
            int tmp = this.heap.get(i);
            this.heap.set(i,heap.get(0));
            this.heap.set(0,tmp);

            this.size--;
            max_heapify(0);
        }
    }

    public int size(){
        return this.size;
    }

    public int left(int i){
        return 2*i + 1;
    }

    public int right(int i){
        return 2*(i+1);
    }

    public int parent(int i){
        return (i-1)/2;
    }

    public String toString(){
        String result = "";
        for (Integer i: heap) {
            result = result + i + ",";
        }
        return result;
    }
}
