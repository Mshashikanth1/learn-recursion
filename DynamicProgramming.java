import java.util.HashMap;
import java.util.Map;

public class DynamicProgramming {
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

}
