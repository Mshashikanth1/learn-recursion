public class MustDoLC {

    /*100 Must do Leet code problems*/
    int[] productOfAllEleExpectEleAtCurrIndex(int[] arr){
        int prod=1,n=arr.length;
        int[] ans=new int[n];

        for (int j : arr) if(j!=0) prod *= j;
        for(int i=0;i<n;i++) if(ans[i]!=0) ans[i]=prod/arr[i];

        return ans;
    }

}
