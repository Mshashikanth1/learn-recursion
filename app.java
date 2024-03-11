import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class app {
    public static void main(String[] args){
        int[] arr=new int[]{20,-4,3,1,100};
        recursion.mergeSort(arr,0,4);
        String lineBreak = "\n";
        String res = "reverse of the string abcd : " + recursion.reverseString("abcd") + lineBreak +
                      "is this work palindrome racecar : " + recursion.isPalindrome("racecar") + lineBreak +
                      "binary representation of 8 : " + recursion.findBinaryString(8) + lineBreak +
                      "the  sum of first 10 natural nums:   "+recursion.sumOfNaturalNumbers(10)   + lineBreak +
                      "in what index 4 is present in this array [-1,2,3,4,6,7,9,10] ? : "
                       + recursion.binarySearch( new int[]{-1,2,3,4,6,7,9,10}, 0,7,4)  + lineBreak +
                      "the  6 fibonacci number is :" + recursion.fibonacci(6)  + lineBreak +
                      "the 6th fibnacci number is : " +recursion.fibonacciOptimized(6,new HashMap<>()) + lineBreak +
                      "sort the array [20,-4,3,1,100] : " + Arrays.toString(arr);
        System.out.println(sameFreq("xyyz"));
    }

    static boolean sameFreq(String s) {


        Map<Character,Integer> hMap=new HashMap<>();
        for(char ch : s.toCharArray()){
            int freq= hMap.getOrDefault(ch, 0);
            hMap.put(ch,++freq);
        }
        int f=Integer.MIN_VALUE;
        for(int e: hMap.values()){

            if(Math.abs(f-e)==1) return true;
            f=e;

        }
        return false;
    }
}
