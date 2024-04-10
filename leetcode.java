import java.util.*;

public class leetcode {
    public static int findMaxLength(int[] nums) {
        int n=nums.length,maxLen=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int ones=0, zeros=0;
                for(int k=i;k<=j;k++){
                    if(nums[k]==1) ones++;
                    else zeros++;
                }
                if(ones!=0 && ones==zeros ) maxLen=Math.max(Math.abs(i-j)+1,maxLen);
            }
        }
        return maxLen;
    }


    public static int removeDuplicates(int[] nums) {

        int n=nums.length,c=1;
        for(int i=0;i<n-c;i+=2){
            while(i !=0 && nums[i]==nums[i-1] ) {
                c++;swapElementToLast(nums,i);
            }
        }
        System.out.println(Arrays.toString(nums));
        return n-c+1;
    }

    public static void swapElementToLast(int[] nums, int i){
        int j=i+1;
        while(j<nums.length){
            nums[i]=nums[j]^nums[i];
            nums[j]=nums[j]^nums[i];
            nums[i]=nums[j]^nums[i];
            i++;
            j++;
        }
    }
    /**
    * 452. Minimum Number of Arrows to Burst Balloons
Medium
Topics
Companies
There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.

Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.

Given the array points, return the minimum number of arrows that must be shot to burst all balloons.



Example 1:

Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
Example 2:

Input: points = [[1,2],[3,4],[5,6],[7,8]]
Output: 4
Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
Example 3:

Input: points = [[1,2],[2,3],[3,4],[4,5]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
- Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].


Constraints:

1 <= points.length <= 105
points[i].length == 2
-231 <= xstart < xend <= 231 - 1

//     [ [10,16], [2,8], [1,6], [7,12]]
//       i
//                 j  is( arr[j]!=0 && arr[i]!=0 &&( j[0] <= i[1]   || j[1] >= i[0] ))  arr[j]=0;
//
//    arr= [1, 1, 1, 1];

    * */

    public static  int findMinArrowShots(int[][] points) {
           int n=points.length,c=0;
           int[] arr=new int[n];
           Arrays.fill(arr,1);


           for(int i=0;i<n-1;i++){
               int[] ipoint=points[i];
               for(int j=i+1;j<n;j++){
                   int[] jpoint=points[j];
                  if(arr[i]!=0 && arr[j]!=0 && (jpoint[1] >= ipoint[0]  && ipoint[1] >=jpoint[0])){
                       arr[j] =0;
                  }

                   }
               }

        System.out.println(Arrays.toString(arr));
          for(int i: arr) c+=i;
          return c;
        }

        /*
        * [1,2,3,4,5,6,7] ,k=3
        *
        * */
        public static int[] rotateArray(int[] arr,int k){

            List<Integer> ans=new ArrayList<>();
            int n=arr.length,i,j;
           for(i=n-1;i<n;i++){
               if(k<=0) break;;
               ans.add(arr[i]);
               k--;
           }
          for( j=0;j<i;j++){
              ans.add(arr[j]);
          }

          j=0;
          for(int l: ans)  {arr[i]=l; j++;}

          return arr;
        }

/*** 621. Task Scheduler

You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n.
Each cycle or interval allows the completion of one task.
Tasks can be completed in any order, but there's a constraint:
identical tasks must be separated by at least n intervals due to cooling time.
​Return the minimum number of intervals required to complete all tasks.



Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8

Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
After completing task A, you must wait two cycles before doing A again.
         The same applies to task B. In the 3rd interval,
         neither A nor B can be done, so you idle.
         By the 4th cycle, you can do A again as 2 intervals have passed.

Example 2:

Input: tasks = ["A","C","A","B","D","B"], n = 1
Output: 6

Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.
With a cooling interval of 1, you can repeat a task after just one other task.

Example 3:
Input: tasks = ["A","A","A", "B","B","B"], n = 3
Output: 10

Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.
There are only two types of tasks, A and B, which need to be separated by 3 intervals.
         This leads to idling twice between repetitions of these tasks.



Constraints:

1 <= tasks.length <= 104
tasks[i] is an uppercase English letter.
0 <= n <= 100

**/


        public int leastInterval(char[] tasks, int n) {

        return -1;
        }

        /*
        * 41. First Missing Positive
Hard
Topics
Companies
Hint
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.



Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.


Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
        * */

    /*Time :O(n) Space :O(n)*/
    public static int firstMissingPositive1(int[] nums) {
        int fmp=1;
        Set<Integer> hSet=new HashSet<>();
        for(int i: nums) hSet.add(i);
        while(hSet.contains(fmp))  fmp++;
       return  fmp;
    }
    public static int firstMissingPositive(int[] nums) {

        boolean contains1=false;
        int n=nums.length;
        for(int i=0;i<n;i++) {
            if(nums[i]==1) contains1=true;
            if(nums[i]<=0 || nums[i]>n) nums[i]=1;
        }
        if(!contains1) return 1;

        for(int i=0;i<n;i++){
            int value = Math.abs(nums[i]);
            if (value == n) {
                nums[0] = - Math.abs(nums[0]);
            } else {
                nums[value-1] = - Math.abs(nums[value-1]);
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i]>0) return i+1;
        }
        return n+1;
    }

        /*
    * check weather 1 is present in the array if not return 1;
    * clean the data<=0  & data>n to 1
    * take the indexes as numbers you are searching presence and values as indices to navigate to next
    * and change the sign
    * return the first postive index that will be the anser
    * */


    public static long countSubarrays(int[] nums, int minK, int maxK) {
        int c=0,n=nums.length;
        for(int i=0;i<n;i++){
            int lmin=Integer.MAX_VALUE, lmax=Integer.MIN_VALUE;
            for(int j=i;j<n;j++){
                for(int k=i;k<=j;k++){
                    if(nums[k] < lmin) lmin=nums[k];
                    if(nums[k] > lmax) lmax=nums[k];
                }
                if((lmin==minK) && (lmax==maxK)) c++;

            }
        }
        return c;
    }

    public static int maxTeams(int p, int t1, int t2) {

         int not1=p/t1, ans=Math.max(not1, (p-not1)/t2);
         return ans==0? -1: ans ;
    }

    static long countMaximum(int n, int arr[])
    {
        // Your code here

        int[] ans=new int[2];
        int i=0, j=arr.length-1, trun=0;

        while(i<j){
            ans[trun%2] +=arr[j]>arr[i] ? arr[j--] : arr[i++];
            trun++;
        }
        System.out.println(Arrays.toString(ans));
        return Long.valueOf(ans[0]);
    }

    public static boolean divisorGame(int n) {

        return rec(n,0);
    }
    public static boolean rec (int n, int turn){

         int x=Integer.MIN_VALUE;
         for(int i=n-1;i>0;i--){
            if(n%i==0) {x=i; break;}
         }

         if(x==Integer.MIN_VALUE && turn%2==1) return true;
         else if(n-x>0) return rec(n-x,++turn);
         else return false;


    }


}


/*

[1,2,3,4,5]
 0,1,2,3,4

 [ 3, 4, -1 ,1]
   0  1   2  3

   [7,8,9,11,12]
    0,1,2,3,4

    minVal !=1 then answer =1
    maxVal*(maxVal+1)>>1 == sum(nums) then return maxVal+1;

 */


