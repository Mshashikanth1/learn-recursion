import java.util.HashMap;
import java.util.Map;

public class recursion {
    public static String reverseString(String str){
        if(str.equals("")){ //base case
            return "";
        }
        return reverseString(str.substring(1))+str.charAt(0); //do smallest work
    }

    public static boolean isPalindrome(String str){
        if(str.length()==0 || str.length()==1) { //base cases
            return  true;
        }
        else if(!(str.charAt(0)==str.charAt(str.length()-1))){
            return  false;
        }
        return isPalindrome(str.substring(1,str.length()-1)); //do smallest work
    }

    public static String findBinaryString(int num){
        if (num==0){  //base case
            return "0";
        }
        return findBinaryString(num/2)+num%2; //do small amount of work
    }

    public static int sumOfNaturalNumbers(int num){
        if(num==1) return 1;
        return sumOfNaturalNumbers(num-1)+num;
    }

    /*
    * Divide and conquer algorithms are recursive:
    * we divide the problem into sub problems and combine the results of sub problems
    * 1. binary search
    * 2. fibonacci
    * 3. merge sort
    * */

    public static int binarySearch (int[] nums,int left,int right, int target){
        if(left>right) return -1;
        int mid=(left+right)/2;
        if(nums[mid]==target) return  mid;
        else if (nums[mid]>target)  return binarySearch(nums,mid+1,right,target);
        return binarySearch(nums,left,mid-1,target);
    }

    public static int fibonacci(int num){
        if(num==0 ) return  0;
        else if (num==1) return 1;
        return fibonacci(num-1) +fibonacci(num-2);
    }
    //memorization
    public static int fibonacciOptimized(int num, Map<Integer,Integer> cache){
        if(num==0 ) return  0;
        else if (num==1) return 1;
        else if (cache.containsKey(num)) return cache.get(num);
        cache.put(num, fibonacciOptimized(num-1,cache) +fibonacciOptimized(num-2,cache));
        return cache.get(num);
    }

    //Time : O(nlog(n)) Space :O(1)
    public static void mergeSort(int[] nums,int start,int end){
          if(start<end) {
              int mid = (start + end) / 2;

              mergeSort(nums, start, mid);
              mergeSort(nums, mid + 1, end);
              merge(nums, start, mid, end);
          }
    }
    public static void merge(int[] nums,int start,int mid,int end){
        int[] temp=new int[end-start+1];
        int i=start,j=mid+1,k=0;

        //linear time comparison  between left and right and arrange accordingly
        while (i<=mid  && j<=end){
            if(nums[i] <=nums[j]) temp[k++]=nums[i++];
            else temp[k++]=nums[j++];
        }
        //if the nums are remaining then add to temp
        while (i<=mid)  temp[k++]=nums[i++];
        while ( j<=end) temp[k++]=nums[j++];

        for(i=start;i<=end;i++) nums[i]=temp[i-start];
    }

    /*
    * Linked list also employ the recursion in its properties
    * 1. reverse the linked list
    * */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
        public int getVal(){
            return val;
        }
        public ListNode getNext() {
            return next;
        }
        public void setNext(ListNode node){
            this.next=node;
        }
    }

    public static ListNode reverseLinkedList(ListNode head){
        if(head==null || head.next==null) return head;  //base case
        ListNode p=reverseLinkedList(head.next);
        head.next.next=head;   //least amt. of work
        head.next=null;
        return p;
    }
    public static ListNode MergeSortedLinkedList(ListNode a, ListNode b ){
        if(a==null) return b;
        else if ( b==null) return  a;

        if(a.val<b.val) {
            a.next=MergeSortedLinkedList(a.getNext(),b);
            return a;
        }else {
            b.next=MergeSortedLinkedList(a,b.getNext());
            return b;
        }
    }

}
