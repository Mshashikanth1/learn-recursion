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
    * 1. binary search
    * 2. fibonacci
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

}
