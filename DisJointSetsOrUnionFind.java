public class DisJointSetsOrUnionFind {

    static int [] parent;
    public DisJointSetsOrUnionFind(int size){
        parent=new int[size];
        for(int i=0;i<size;i++) parent[i]=i;
    }



    public   void union(int i, int j){
        int irep=find(i), jRep=find(j);
        if(irep!=jRep)  parent[irep]=jRep;
    }


    /*Recursive function that will  check the parent of the set, initially there are n sets*/
    public static int find(int i){
            if(parent[i]==i) return  i;
            parent[i]=find(parent[i]);
            return parent[i];
    }

    public  static boolean bothAreInSameSet(int i, int j){
        return find(i)==find(j);
    }
}
