import java.util.HashMap;
import java.util.Map;

public class DynamicProgramming {

    /*Dynamic programming(save the similar sub-problems result and use it for further )
     * stair case
     * fibonacci : fib(n)=fib(n-1) + fib(n-2)
     *
     *
     * factorial : fac(n) = n*fib(n-1) --> no repeated work[ dp not required]
     *
     * prefer iterative dynamic programming
     * DAG (directed acyclic graph) ,
     *
     * iterative (bottom up) [easier to calculate time complexity] [tabulation] [ space optimization ]
     * / recursive (top down)[its easier] [memorization]
     *
     *
     * */
    /*
    * fibonacci numbers : 0,1,1,2,3,5,.... : f(n)=f(n-1)+f(n-2)
    * */


    /*Time : O(2^n)
    * Space : O(1)
    *
    * an observation : overlapping sub problems
    * */
    public int fibNum(int n){
        if(n<=1) return n;
        return fibNum(n-1) +fibNum(n-2);
    }

    /*
    * Time : O(n)
    * Space :O(1)
    * */
    public int fibNumMemorization(int n, Map<Integer,Integer> cache){
        if(n<=1) return n;
        if(cache.containsKey(n)) return cache.get(n);
        cache.put(n,fibNumMemorization(n-1,cache)+fibNumMemorization(n-2,cache));
        return cache.get(n);
    }

    /*
    * Time : O(n)
    * Space : O(n)
    *
    * an observation can be done : we are soring large data,
    * but we use only last 2 calls
    * kotlin is the replica
    * */
    public int fibNumTabulation(int n){
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    /*
     * Time : O(n)
     * Space : O(1)
     * */
    public int fibNumSpaceOptimisation(int n){
        int first=0,second=1;
        if(n==1) return first;
        if(n==2) return second;
        int next=-1;
        for(int i=2;i<=n;i++){
           next=first+second;
           first=second;
           second=next;
        }
        return next;
    }




    /* bottom up : dynamic programming : tabulation  Time : O(n*m) Space O(n*m) */
    public static int longestCommonSubSequence(String s, String t){
            int n= s.length(), m=t.length();
            int[][] dp= new int[n+1][m+1];

            for(int i=1;i<=n;i++){
                for(int j=1; j<=m; j++ ){
                    if(s.charAt(i-1) == t.charAt(j-1)){
                        dp[i][j] = 1+ dp[i-1][j-1];
                    }else {
                        dp[i][j] =Math.max(dp[i-1][j] , dp[i][j-1]);
                    }
                }
            }
            /*to print the longest common subsequence we , need backtrack the dp array by checking the character
            equality & and got to max of the i,j and reverse the string you have got*/

        System.out.println(backTrack(s,t,n,m,dp));
            return dp[n][m];
    }

    public static String backTrack(String s, String t, int n, int m,int[][] dp){
        int i= n,  j=m;
        StringBuilder lcs= new StringBuilder();
        while(i>0 && j>0){
            if(s.charAt(i-1)== t.charAt(j-1)) {lcs.append(s.charAt(i-1));  i--; j--;}
            else if( dp[i-1][j] > dp[i][j-1]) i--;
            else j--;
        }
        lcs.reverse();
        return lcs.toString();
    }

    public static int longestCommonSubSequence(String s, String t, int i, int j,int[][] memo){
        if(i==0 || j==0 ) {
            return 0;
        }

        if( s.charAt(i-1) == t.charAt(j-1)) {
            memo[i][j]= 1+ longestCommonSubSequence(s,t,i-1,j-1, memo);
        }
        else { memo[i][j]=Math.max(longestCommonSubSequence(s,t,i-1,j , memo), longestCommonSubSequence(s,t,i,j-1 , memo));}

        return memo[i][j];
    }


}
