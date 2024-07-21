import java.util.*;

public class NeetCode {


    /*
     * operations  :
     *    choose any index i from 1 to n
     *    make it
     *   decrement  -1 : nums[i]-=1;
     *   increment 1 : nums[i] +=1;
     *
     *  T: O(n) S: O(1)
     * */
    public static int minimizeMaximumArray(int[] nums) {
        int prefixSum = nums[0], maximumValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum += nums[i];
            int res = (int) Math.ceil(prefixSum / (i + 1));
            maximumValue = Math.max(maximumValue, res);

        }
        return maximumValue;
    }

    /*
     *  input str= neet**cod*e
     *  output : necoe
     *
     *  Time : O (n) S: O(n)
     * */
    public static String removeStars(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '*') stack.pop();
            else stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }

    /*
     * Optimal sub string split, from a string with no duplicate char
     * input : "abacaba"
     * out put : 4  { "ab", "ac", "ab", "a" }
     *
     *   T : O(n) S : O(1) since we only store at-most 26 english alphabet chars
     * */
    public static int optimalPartitionSubstring(String str) {
        Set<Character> hset = new HashSet<>();
        int count = 1;
        for (char ch : str.toCharArray()) {
            if (hset.contains(ch)) {
                count++;
                hset = new HashSet<>();
            }
            hset.add(ch);
        }
        return count;
    }


    /*
       input : spells = [5,1,3] , portions =[1,2,3,4,5] , success=7
       output : [4,0,3]

       5 * portions = count( [5,10,15, 20, 25] ) >= sucess : 4;
       1 * portions =count( [1,2,3,4,5] ) >= sucess : 0;
       3 * portions = count( [3,6,9,12, 15] ) >= success : 3;

    * */
    /* Time : O(n*m)  Space : O(n)  */
    public static int[] _pairsSuccessSpellsPortions(int[] spells, int[] portions, int success) {
        int n = spells.length, m = portions.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            for (int portion : portions) {
                if (spells[i] * portion >= success) ans[i]++;
            }
        }
        return ans;
    }

    /*
     * to reduce the time complexity we need to sort the portions and do a binary search on portions for every spell to find the first index
     * of the portion meets the success condition
     *
     * Time : O(mlog(m)) (sorting) + O(nlog(m)) (binary search)
     * */

    public static int[] pairsSuccessSpellsPortions(int[] spells, int[] portions, int success) {
        int n = spells.length, m = portions.length;
        Arrays.sort(portions);
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int left = 0, right = portions.length - 1, indx=portions.length;
            while (left<=right){
                int mid= left + (right-left)/2;
                if( spells[i]* portions[mid] >=success) { right=mid-1; indx=mid;}
                else left= mid+1;
            }

            ans[i]= portions.length-indx;
        }
        return ans;
    }


    /*
    *  top k frequent elements :
    *
    *  input : nums = [1,1,1,2,2,3] k= 2
    *   out put : [1 , 2]
    *
    * */

    public static int[] _topKFrequentElements( int[] nums, int k){

        Map<Integer, Integer> freqMap= new HashMap<>();
        for( int i: nums) freqMap.put(i, freqMap.getOrDefault(i,0) +1 );

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) ->b[1]-a[1] );

        for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()) {
                pq.add(new int[]{ entry.getKey(), entry.getValue()});
        }

        int[] ans = new int[k];
        while( --k >= 0){
             ans[k] = pq.poll()[0];
        }

        return ans;

    }


    public static int[] __topKFrequentElements( int[] nums, int k){

        Map<Integer, Integer> freqMap= new HashMap<>();
        for( int i: nums) freqMap.put(i, freqMap.getOrDefault(i,0) +1 );

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>( (a,b) ->b.getValue()-a.getValue() );
        pq.addAll(freqMap.entrySet());

        int[] ans = new int[k];
        while( --k >= 0) ans[k] = pq.poll().getKey();

        return ans;
    }

    public static int[] topKFrequentElements( int[] nums, int k){
        Map<Integer,Integer> freqMap= new HashMap<>();
        for( int i : nums) freqMap.put(i, freqMap.getOrDefault(i,0)+1);

        System.out.println(freqMap);
        List< List<Integer> > bucket= new ArrayList<>();
        for( int i=0; i<= nums.length+1; i++) bucket.add(new ArrayList<>());

        for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
            bucket.get(entry.getValue()).add(entry.getKey());
        }

        int[] ans = new int[k];

        for( int i=0; i<= nums.length+1 ; i++){

            System.out.println(bucket.get(i));
            for( int j : bucket.get(i)){

                ans[--k]=j;
                if( k==0 )return  ans;
            }
        }

        return ans;

    }

}














