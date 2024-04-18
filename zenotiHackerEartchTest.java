import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class zenotiHackerEartchTest {

        public static void main1(String args[] ) throws Exception {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            while(n>0){
                String str=sc.next();
                Map<Character,Integer> fhMap=new LinkedHashMap<>();

                for(char ch : str.toCharArray()){
                    fhMap.put(ch, fhMap.getOrDefault(ch, 0)+1);
                }

                StringBuilder sb=new StringBuilder();
                for(char ch : fhMap.keySet()){
                    sb.append(ch);
                    sb.append(fhMap.get(ch));
                }
                System.out.println(sb);
                n--;
            }

        }


    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String S = br.readLine();

        String[] out_ = tokenize_string(S);
        for (int i_out_ = 0; i_out_ < out_.length; i_out_++)
        {
            System.out.println(out_[i_out_]);
        }

        wr.close();
        br.close();
    }
    static String[] tokenize_string(String S){
        char[] chr= S.toCharArray();
        int f=-1;
        List<String> str=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<chr.length;i++){

            if(chr[i]==' ' && f==-1) {
                str.add(sb.toString());
                sb=new StringBuilder();
            }

            if(f!=-1 && chr[i]=='"'){
                sb.append(chr[i]);
                str.add(sb.toString());
                sb=new StringBuilder();
                f=-1;
                continue;
            }

            if(chr[i]=='"'){
                f=i;
            }
            sb.append(chr[i]);
        }

        String[] ans=new String[str.size()];
        for(int i=0;i<str.size();i++){
            ans[i]=str.get(i).trim();
        }


        return ans;
    }

    public static void main3(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n>0){
            String str=sc.next();
            StringBuilder sb=new StringBuilder();

            for(char ch : str.toCharArray()){
                if(ch >=65 && ch <=90){
                    if(sb.length()!=0) sb.append('_');
                    sb.append((char) (ch+32));
                }else{
                    sb.append(ch);
                }
            }

            System.out.println(sb.toString());
            n--;
        }
    }
}
