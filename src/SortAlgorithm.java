import java.util.Arrays;

public class SortAlgorithm {
	//Insertion sort
	public static void nonIncreasingInsertionSort(int[] nums){
		if(nums.length <= 1)
			return;
		else{
			for (int i = 1; i < nums.length; i++) {
				int key = nums[i];
				int j = i-1;
				while(j>=0 && nums[j]<key){
					nums[j+1] = nums[j];
					j--;
				}
				nums[j+1] = key;
			}
		}
	}
	
	
	//Merge sort
	public static void mergeSort(int[] nums,int p, int r){
		if(p < r){
			int q = (p+r)/2;
			mergeSort(nums, p, q);
			mergeSort(nums, q+1, r);
			merge(nums, p, q, r);
		}
	}
	
	private static void merge(int[] nums,int p, int q, int r){
		int nums1 = q-p+1;
		int nums2 = r-q;
		
		int[] left = new int[nums1+1];
		int[] right = new int[nums2+1];
		
		for (int i = 0; i < nums1; i++) {
			left[i] = nums[p+i];
		}
		left[nums1] = Integer.MAX_VALUE;
		
		
		for(int i = 0; i < nums2; i++){
			right[i] = nums[q+1+i];
		}
		right[nums2] = Integer.MAX_VALUE;
		
		int i = 0;
		int j = 0;
		for (int m = 0; m < nums1 + nums2; m++) {
			if (left[i] < right[j]) {
				nums[p+m] = left[i];
				i++;
			}
			else{
				nums[p+m] = right[j];
				j++;
			}
		}
	}

	//Quick sort
	public static void quickSort(int[] nums,int p, int r){
		if (p < r){
			int q = randomized_partition(nums, p, r);
			quickSort(nums, p, q-1);
			quickSort(nums, q+1, r);
		}
	}

	//HOARE Quick sort
	public static void hoare_quickSort(int[] nums,int p, int r){
		if (p < r){
			int q = hoare_partition(nums, p, r);
			hoare_quickSort(nums, p, q);
			hoare_quickSort(nums, q+1, r);
		}
	}

	private static int randomized_partition(int[] nums, int p, int r){
		int index = (int) (Math.ceil(Math.random() * (r-p)) + p);
		swap(nums, index, r);
		return partition(nums, p, r);
	}

	private static int partition(int[] nums, int p, int r){
		int pivot = nums[r];
		int i = p-1;
		int replication = 0;
		for (int j = p; j < r; j++) {
			if (nums[j] == pivot){
				replication++;
				if (replication % 2 == 0){
					i++;
					swap(nums, i, j);
				}
			}
			if (nums[j] < pivot) {
				i++;
				swap(nums, i, j);
			}
		}
		i++;
		swap(nums, i, r);

		return i;
	}

	private static int hoare_partition(int[] nums, int p, int r){
		int pivot = nums[p];
		int l = p;
		int h = r;
		while(true){
			while(nums[h] > pivot ){
				h--;
			}
			while(nums[l] < pivot){
				l++;
			}
			if(l < h){
				swap(nums, l, h);
				l++;
				h--;
			}
			else{
				return h;
			}
		}
	}

	private static void swap(int[] nums, int x, int y){
		int tmp = nums[x];
		nums[x] = nums[y];
		nums[y] = tmp;
	}

	//Counting sort
	public static void countingSort(int[] A, int[] B, int k){
		int[] C = new int[k+1];
		for (int i=0; i<C.length; i++){
			C[i] = 0;
		}

		for (int i=0; i<A.length; i++){
			C[A[i]] += 1;
		}

		for (int i=1; i<C.length; i++){
			C[i] = C[i-1] + C[i];
		}

		for (int i = A.length - 1; i>=0; i--){
			B[C[A[i]]-1] = A[i]; //index - 1
			C[A[i]]--;
		}
	}
}

