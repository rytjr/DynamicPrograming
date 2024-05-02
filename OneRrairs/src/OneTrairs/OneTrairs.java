package OneTrairs;

import java.util.Scanner;

public class OneTrairs {
	
	static int Num;
	static int[][] arr;
	static long count = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Num = sc.nextInt();
		arr = new int[Num][10];
		
		
		
		for(int i = 0; i < 10; i++) {
			arr[0][i] = 1;
		}
		
		for(int i = 1; i < 10; i++) {
			count += dp(Num - 1, i);
		}
		
		System.out.print(count % 1000000000);
	}
	
	public static int dp(int depth, int num) {
		
		
		if(arr[depth][num] == 0) {
			if(num == 0) {
				arr[depth][num] = dp(depth - 1, num + 1) + arr[depth][num];
			}
			else if(num == 9) {
				arr[depth][num] = dp(depth - 1, num - 1) + arr[depth][num];
			}
			else {
				arr[depth][num] = (dp(depth - 1, num + 1) + dp(depth - 1, num - 1)) + arr[depth][num];
			}
		}
		
		return arr[depth][num];
	}

}
