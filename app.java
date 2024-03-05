import java.util.HashMap;

public class app {
    public static void main(String[] args){
        String lineBreak = "\n";
        String res = "reverse of the string abcd : " + recursion.reverseString("abcd") + lineBreak +
                      "is this work palindrome racecar : " + recursion.isPalindrome("racecar") + lineBreak +
                      "binary representation of 8 : " + recursion.findBinaryString(8) + lineBreak +
                      "the  sum of first 10 natural nums:   "+recursion.sumOfNaturalNumbers(10)   + lineBreak +
                      "in what index 4 is present in this array [-1,2,3,4,6,7,9,10] ? : "
                       + recursion.binarySearch( new int[]{-1,2,3,4,6,7,9,10}, 0,7,4)  + lineBreak +
                      "the  6 fibonacci number is :" + recursion.fibonacci(6)  + lineBreak +
                      "the 6th fibnacci number is : " +recursion.fibonacciOptimized(6,new HashMap<>())
                ;
        System.out.println(res);
    }
}
