package Sortings;

import java.util.Scanner;
import java.util.Arrays;

public class Sorting {



		
		public static void main(String args[]) {

			int ch;
			Sorting obj = new Sorting();
			
			try (Scanner io = new Scanner(System.in)) {
				System.out.println("SORTING OF THREE NUMBERS:");
				
// 			int n = io.nexrInt();
//      int [] arr = new int[n];
				int[] arr = new int[3];
				
				for(int i = 0;i<arr.length;i++) {
				    System.out.println("enter number "+(i+1)+":");
					arr[i]=io.nextInt();
				}
				System.out.println("The Entered Array list are:-");
				for(int q:arr) {
					System.out.print(q + " ");
				}

				while(true) {
				System.out.println("\n1.Seletion sort\n2.Insertion sort\n3.Bubble sort\n4.Merge sort\n"
						+ "5.Heap sort\n6.Quick Sorting\n7.Comb sort\n8.Count sort\n9.Shell sort\n"
						+ "10.Stooge sort\n11.enter new elements\n12.Exit");
				
				System.out.print("enter your choice of sorting method :");
				ch = io.nextInt();
				
				switch(ch) {
				
				case 1:
					obj.selection(arr);
					break;
				case 2:
					
					obj.insertion(arr);
					break;
				case 3:
					
					obj.bubble(arr);
					break;
				case 4:
					obj.merge(arr);
					break;
				case 5:
					obj.heap(arr);
					break;
				case 6:
					int n= arr.length;
				
					obj.quick(arr,0,n-1);
					break;
				case 7:
					obj.comb(arr);
					break;
				case 8:
					obj.count(arr);
					break;
				case 9:
					obj.shell(arr);
					break;
				case 10:
					obj.stooge(arr,0,arr.length-1);
					break;
				case 11:
					System.out.println("\tEnter New Array elements\n");
					obj.newst();
				case 12:
					System.exit(0);
				default:
					System.out.println("enter a number beween 1-10 as shown in menu:");
				}
			}
		}
			
	}
		
//		Selection sorting


		void selection(int [] arr) {
		int i;
			for( i = 0; i<arr.length-1;i++) {
				int min = i;
				for(int j = i+1;j<3;j++) {
					if(arr[j]<arr[min]) {
						min = j;	
					}
				}
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
			
			System.out.println("\t... Seletion sorting ...\nsorted elements are:");
			
			for(i = 0;i<arr.length;i++) {
				System.out.println(arr[i]);
			}
		}
				
//     Insertion sorting 
		
	void insertion(int [] arr) {
		 for (int j = 1; j < arr.length; j++) {  
	            int key = arr[j];  
	            int i = j-1;  
	            while ( (i > -1) && ( arr [i] > key ) ) {  
	                arr [i+1] = arr [i];  
	                i--;  
	            }  
	            arr[i+1] = key;  
	        }
		 
		 System.out.println("\t...Insertion sorting...\n");
		 System.out.println("after insertion sorting....");
		 for(int i = 0;i<arr.length;i++) {
			 System.out.println(arr[i]);
		 }
	}
	
//	Bubble sorting
	
	void bubble(int[] arr) {
		
		int temp;

		System.out.println("\t...After Bubble Sorting...");
		
		for(int i = 0;i<3;i++) {
			
			for(int j =i+1;j<3;j++) {
				
				if(arr[i]>arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		

		System.out.println("elements are:");
		
		for(int i = 0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
	}
	
//	merge sorting 
	
	void merge(int [] arr) {
		
		
		int i, b = 0 , l =arr.length-1, m = (b+l)/2;
		int n1 = m-b+1;
		int n2 = l-m;
		
		int a1[] = new int[n1], a2[] = new int[n2];
		
		for (i=0; i<n1; i++) {
			a1[i] = arr[b + i];
		}
		for (int j=0; j<n2; j++) {
			a2[j] = arr[m + 1 + j];
		}
		i=0; int j=0; int k=b;
		while (i<n1 && j<n2) {
			if (a1[i] <= a2[j]) {
				arr[k] = a1[i];
				i++;
			} else {
				arr[k] = a2[j];
				j++;
			}
			k++;
		}
		while (i<n1) {
			arr[k] = a1[i];
			i++; k++;
		}
		while (j<n2) {
			arr[k] = a2[j];
			j++; k++;
		}
		System.out.println("\t...Merge Sorting...");
		System.out.println("After sorting...");
		for(i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
			
//	heap sort
	void heap(int arr[]) {
		int temp;
		for(int i=(arr.length/2)-1;i>=0;i--) {
			heapify(arr,arr.length,i);
		}
		for(int i = arr.length-1;i>=0;i--) {
			temp = arr[0];
			arr[0] = arr[i];
			arr[i] =temp;
			heapify(arr,i,0);
			
		}
		System.out.println("After Heap Sorting...");
		
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
	
	void heapify(int arr[],int n,int i) {
		
		int max = i, temp;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		if (left < n && arr[left] > arr[max]) {
			max = left;
		}
		if (right < n && arr[right] > arr[max]) {
			max = right;
		}
		if (max != i) {
			temp = 	arr[i];
			arr[i] = arr[max];
			arr[max] = temp;
			heapify(arr, n, max);
		}
	}
	
//	quick sort 
	
	public void quick(int arr[],int lb ,int ub) {
		if (lb<ub) {
			int a = partition(arr,lb,ub);
			quick(arr,lb,a-1);
			quick(arr,a+1,ub);
			
			System.out.println("After Quick Sorting...");
			for(int i:arr) {
				System.out.println(i);
			}
		}
	}
	int partition(int arr[], int lb ,int ub){
		int  pivot = arr[ub],i = lb-1,j,temp;
		for(j = lb;j<=ub-1;j++) {
			if(arr[j]<pivot) {
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				
			}
		}
		
		temp = arr[i+1];
		arr[i+1] = arr[ub];
		arr[ub] = temp;
		return(i+1);
	}
	
//	comb sorting 
	
	void comb(int arr[]) {
		int gap = arr.length, swap = 1,i,temp;
		while(gap!=1||swap==1) {
			gap = updategap(gap);
			swap = 0;
			for(i= 0;i<(arr.length-gap);i++){
				if(arr[i]>arr[i+gap]) {
					temp = arr[i];
					arr[i] = arr[i+gap];
					arr[i+gap] = temp;
					swap = 1;
					}
			}
		}
		System.out.println("Afert Comb Sorting...");
		for(int a : arr) {
			System.out.println(a);
		}
	}
	int updategap(int gap) {
		gap = (int)(gap/1.3);
		if (gap < 1) {
			return 1;
		}
		return gap;
	}
	
//	count sorting
	
	void count(int arr[]) {
		int n = arr.length;
		int temparr[] = new int[n+1], max = Arrays.stream(arr).max().getAsInt(),
				count[] = new int[max+1];
		for (int i = 0; i<=max; ++i) {
			count[i] = 0;
		}
		for (int i = 0; i<n; i++) {
			count[arr[i]]++;
		}
		for (int i= 1; i<=max; i++) {
			count[i] += count[i-1]; 
		}
		for (int i= n-1; i>=0; i--) {
			temparr[count[arr[i]]-1] = arr[i];
			count[arr[i]]--;
		}
		for (int i = 0; i<n; i++) {
			arr[i] = temparr[i];
		}
		
		System.out.println("After Count Sortinig...");
		for(int q :arr) {
			System.out.print(q + " ");
		}
	}
	
//	shell Sorting
	
	void shell(int arr[]) {
		int i,j,temp,k;
		for(i = arr.length/2;i>0;i/=2) {
			for(j=i;j<arr.length;j+=1) {
				temp = arr[j];
				for(k = j;k>=1&&arr[k-1]>temp;k-=i) {
					arr[k] = arr[k-i];
				}
				arr[k] = temp;
			}
		}
		System.out.println("After Shell Sorting ...");
		for(int q : arr) {
			System.out.print(q + " ");
		}
		
	}
	
//	Stooge sorting 
	
	void stooge(int [] arr,int i,int j) {
		int temp,k ;
		if(arr[i] > arr[j]) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		if((i+1)>=j) {
			return;
		}
		k = (int)(j-i+1/3);
		stooge(arr,i,j-k);
		stooge(arr,i+k,j);
		stooge(arr,i,j-k);
		
		System.out.println("After Stooge Sorting...");
		for(int q:arr) {
			System.out.print(q + " ");
		}
	}
	
//	to begins from first
	
	void newst() {
		main(null);
	}
}
