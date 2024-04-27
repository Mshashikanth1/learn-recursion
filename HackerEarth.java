public class HackerEarth {
    static long solve(int k, long n){
        // Write your code here
        long count=1L;
        for(int i=1;i<=k;i++){
            String str=nBaseRep(i,n);
            System.out.println(str);
            count+=str.length();
        }
        return count;

    }
    static String nBaseRep(int k, long n){
        StringBuilder sb=new StringBuilder();
        while(k>0){
            sb.append(k%n);
            k/= (int) n;
        }
        return sb.toString();
    }
}
