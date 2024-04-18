import java.util.Arrays;

public class sorting {

    /*Bubble sort :repeatedly compare the adjacent members in an array and swap them until the array gets sorted
    * Time : O(n^2)
    * Space : O(1)
    * */
    public static void bubbleSort(int[] nums){
        boolean isSwapped;
        int n=nums.length;
        do{
            isSwapped=false;
            for (int i=0;i<n-1;i++){
                if(nums[i]>nums[i+1]) { performSwap(nums,i,i+1); isSwapped=true;};
            }
        } while (isSwapped);
    }
    public static void performSwap(int[] nums, int i, int j) {
        nums[i]^=nums[j];
        nums[j]^=nums[i];
        nums[i]^=nums[j];
    }

    public static void swap(int[] nums,int i , int j){
        int temp= nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


    /*Divide and conquer algorithm , we can choose the pivot element as base element and start working
    * Quick sort is best for arrays; all it is about  partitioning , each element in the array;
    * Time: O(nlog(n)), Worst Case O(n^2)
    * Space: O(1)
    * Partitioning around each element is notting but putting every element less than that to left and elements
    * Greater than  to the right;
    * */
    public static void quickSort(int[] nums, int left,int right){
        if(left<right){
            int pi=partitionn(nums,left,right);
            quickSort(nums,left,pi-1);
            quickSort(nums,pi+1,right);
        }
    }
    public static int partitionn(int[] nums, int left, int right){
        int i=left-1,j=left;
        while (j<right) {
            if(nums[j]<=nums[right]) {
                swap(nums, ++i, j);
            }
            j++;
        }
        swap(nums,++i,right);
        return i;
    }

/*  Divide and conquer algorithms: it includes in dividing the array into smaller arrays and
    sorting them and merging them back
  * Time : O(nlog(n)
  * Space : O(n)
  */
    public static void mergeSort(int[] nums, int left, int right){
           if(left<right){
               int mid=left + ((right - left)/2);
               mergeSort(nums,left, mid);
               mergeSort(nums,mid+1,right);
               merge(nums,left,mid,right);
           }
    }

    public static void merge(int[] nums,int left,int mid,int right){
           int n= mid-left+1 , m=right-mid, i=0, j=0, k=left;

           int[] nArr=new int[n], mArr=new int[m];

           /*copy the data from og arr*/
           while(i<n) nArr[i]=nums[left  + i++];
           while(j<m) mArr[j]=nums[mid+1 + j++];

           i=0; j=0;

           /*put the min ele in og arr from left to right */
           while(i<n && j<m) nums[k++] = nArr[i]<=mArr[j] ? nArr[i++] : mArr[j++];

           /*put the remaining elements in og arr*/
           while(i<n) nums[k++]=nArr[i++];
           while(j<m) nums[k++]=mArr[j++];
    }

    public  static  int gcd(int a, int b){
        if(a<b) return  gcd(b,a);
        if(a%b==0) return b;
        else return gcd(a%b,a);
    }

}
