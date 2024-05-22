import java.util.ArrayList;
import java.util.List;

public class Trees {

    public static class Node{

        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
            this.left=this.right= null;

        }
    }


    public static void main(String[] args){

    }

    public static class TreeView{

        public List<Integer> getRightView(Node root){

            return  new ArrayList<>();
        }
    }
}
