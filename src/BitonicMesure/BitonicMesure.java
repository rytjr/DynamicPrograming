package BitonicMesure;

import java.util.Scanner;

public class BitonicMesure {
	
	static int Num;
	static Integer[] arr;
	static Integer[] arr2;
	static int[] list;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Num = sc.nextInt();
		
		arr = new Integer[Num];
		list = new int[Num];
		arr2 = new Integer[Num];
		
		for(int i = 0; i < Num; i++) {
			list[i] = sc.nextInt();
		}
		
		
		for (int i = 0; i < Num; i++) {
			dp(i);
			dp2(i);
		}
 
		int max = -1;
		for (int i = 0; i < Num; i++) {
			max = Math.max(arr[i] + arr2[i], max);
		}
		System.out.print(max - 1);
	}
	
	/*static int LIS(int N) {
		 
		// 만약 탐색하지 않던 위치의 경우
		if (r_dp[N] == null) {
			r_dp[N] = 1; // 1로 초기화
 
			// N 이전의 노드들을 탐색
			for (int i = N - 1; i >= 0; i--) {
				// 이전의 노드 중 seq[N]의 값보다 작은 걸 발견했을 경우
				if (seq[i] < seq[N]) {
					r_dp[N] = Math.max(r_dp[N], LIS(i) + 1);
				}
			}
		}
		return r_dp[N];
	}
	*/
	public static int dp(int depth) {
		
		if(arr[depth] == null) {
			
			arr[depth] = 1;
			
			for(int i = depth - 1; i >= 0; i--) {
				if(list[i] < list[depth]) {
					arr[depth] = Math.max(arr[depth], dp(i) + 1);
				}
			}
			
		}
		
		return arr[depth];
	}
	
	/**
	 * static int LDS(int N) {
		
		// 만약 탐색하지 않던 위치의 경우
		if (l_dp[N] == null) {
			l_dp[N] = 1; // 1로 초기화
 
			// N 이후의 노드들을 탐색
			for (int i = N + 1; i < l_dp.length; i++) {
				// 이후의 노드 중 seq[N]의 값보다 작은 걸 발견했을 경우
				if (seq[i] < seq[N]) {
					l_dp[N] = Math.max(l_dp[N], LDS(i) + 1);
				}
			}
		}
		return l_dp[N];
	}*/
	
    public static int dp2(int depth) {
		
		if(arr2[depth] == null) {
			
			arr2[depth] = 1;
			
			for(int i = depth + 1; i < Num; i++) {
				if(list[i] < list[depth]) {
					arr2[depth] = Math.max(arr2[depth], dp2(i) + 1);
				}
			}
			
		}
		
		return arr2[depth];
	}

}
