package Wine;

import java.util.Scanner;

public class Wine {
	
	static int Num;
	static Integer[] arr;
	static int[] list;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Num = sc.nextInt();
		
		arr = new Integer[Num + 2];
		list = new int[Num + 2];
		for(int i = 2; i < Num + 2; i++) {
			list[i] = sc.nextInt();
		}
		
		arr[0] = 0;
		arr[1] = 0;
		arr[2] = list[2];
		
		System.out.print(dp(Num + 1));
	}
	
	public static int dp(int depth) {
		
		if(arr[depth] == null) {
			arr[depth] = Math.max(Math.max(dp(depth - 2), (dp(depth - 3) + list[depth - 1])) + list[depth], dp(depth - 1));
		}
		
		return arr[depth];
	}

}
