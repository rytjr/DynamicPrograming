package Lcs;

import java.util.*;

public class Lcs {
    
    static char[] A;
    static char[] B;
    static Integer[][] dp;
    
    public static void main (String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        A = sc.nextLine().toCharArray();
        B = sc.nextLine().toCharArray();
        
        dp = new Integer[B.length+1][A.length+1];
        
        for (int i=0; i<A.length+1; i++) dp[0][i] = 0;
        for (int i=0; i<B.length+1; i++) dp[i][0] = 0;
        
        System.out.println(LCS(A.length, B.length));
                           
        sc.close();
    }
    
    static int LCS (int X, int Y) {
    	
    	int x = X-1;
    	int y = Y-1;
        
        if (dp[Y][X] == null) {
            
            if (A[x] == B[y]) dp[Y][X] = LCS(X-1,Y-1)+1;
            
            else dp[Y][X] = Math.max(LCS(X-1, Y), LCS(X, Y-1));
        }
        
        return dp[Y][X];
    }
}
