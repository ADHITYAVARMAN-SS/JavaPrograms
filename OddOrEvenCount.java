package Training;
// this program checks the count of odd or even in a given string.
import java.util.Scanner;

public class OddOrEvenCount {
	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		
		char arr[] = a.toCharArray();
		int len = arr.length,even = 0, odd = 0;
		char even1[] = new char[len],odd1[] = new char[len];int j = 0,k = 0;
		
		for(int i = 0;i< len;i++) {
			if(arr[i]%2 == 0) {
				even1[j]=arr[i];
				j++;
				even++;
				continue;
		}
			odd1[k]=arr[i];
			k++;
			odd++;
		}
		System.out.println("Even : "+even+" Odd : "+odd);
		
		System.out.println("Even digits");
		for(int i = 0;i < even1.length;i++) {
			if(even1[i]==0) {
				continue;
			}
			System.out.print(even1[i]+" ");
		}
		System.out.println("\n\nOdd digits");
		for(int i = 0;i < even1.length;i++) {
			if(odd1[i]==0) {
				continue;
			}
			System.out.print(odd1[i]+" ");
		}
	}
}
