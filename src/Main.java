import java.util.Arrays;

public class Main {
	public static void main(String[] args){
		//testInsertionSort();
		//testMergeSort();
		//testFindMaxSubArrayAlgorithm();
        //testQuickSort();
		testHoareQuickSort();
		//testHeap();
//		testCountingSort();
	}

	public static void testInsertionSort(){
		int[] nums = {2,5,3,1,9,6,7,10};
		SortAlgorithm.nonIncreasingInsertionSort(nums);
	}

	public static void testMergeSort(){
		int[] nums = {2,5,3,1,9,6,7,10};
		SortAlgorithm.mergeSort(nums, 0, nums.length-1);
		System.out.println(Arrays.toString(nums));
	}

	public static void testQuickSort(){
        int[] nums = {2,5,3,10,9,6,13,8};
        SortAlgorithm.quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

	public static void testHoareQuickSort(){
		int[] nums = {1,4,2,3,5,6};
		SortAlgorithm.hoare_quickSort(nums, 0, nums.length-1);
		System.out.println(Arrays.toString(nums));
	}

	public static void testFindMaxSubArrayAlgorithm(){
		int[] nums = new int[10000000];
		for (int i = 0; i < 10000000; i++) {
			int r = (int)(Math.random() * 50);
			if (r < 40)
				r= -r;
			nums[i] = r;
		}

		System.out.println(Arrays.toString(nums));

		long a=System.currentTimeMillis();
		int[] result = SubArrayAlgorithm.findMaxSubArray(nums, 0, nums.length-1);
		System.out.println(Arrays.toString(result));
		System.out.println("执行耗时 : "+(System.currentTimeMillis()-a)+" 毫秒 ");

		a=System.currentTimeMillis();
		result = SubArrayAlgorithm.findMaxSubArray_DP(nums);
		System.out.println(Arrays.toString(result));
		System.out.println("执行耗时 : "+(System.currentTimeMillis()-a)+" 毫秒 ");

		a=System.currentTimeMillis();
		result = SubArrayAlgorithm.findMaxSubArray_DP2(nums);
		System.out.println(Arrays.toString(result));
		System.out.println("执行耗时 : "+(System.currentTimeMillis()-a)+" 毫秒 ");
	}

	public static void testHeap(){
		Integer[] nums = {2,11,1,5,6,8,9,4};
		Heap heap = new Heap(nums);
		System.out.println(heap);
		heap.heapSort();
		System.out.println(heap);
	}

	public static void testCountingSort(){
		int[] nums = {1,3,5,6,5,3,2,0,1,2,3,4};
		int[] result = new int[nums.length];
		SortAlgorithm.countingSort(nums, result, 6);
		System.out.println(Arrays.toString(result));
	}
}