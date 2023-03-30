public class BST {
    
    public static Nodee root;
    public static Nodee item;

    static {
        item = null;
    }

   // public static ArrayList valid = new ArrayList();
    public static boolean num1BST (Nodee root, int leftTree, int rightTree){
        if (root!= null){//as long as the root is not empty Base Case
            if (root.data >= leftTree && root.data <= rightTree) {//sorta splits the tree into two and checks both sides of the tree
                //recursively traverses through the tree and checks the max and min values of each tree.
                return (num1BST(root.left,leftTree, root.data-1) && num1BST(root.right,root.data+1,rightTree));
            }
            return false;//

        }
        return true;
    }
//public static boolean isHoping (){
//        inOrder(root);
//
//}
    


    public static int [] inOrder (Nodee data){//regular in order traversal
        int [] arr1= new int [10];

        if(data.left!=null){//checks if left is null, if it's not it adds to the left branches
            inOrder(data.left);
        }


        if(data.right!=null){//checks if right is null, if it's not it adds to the right branches
            inOrder(data.right);
        }
        for(int i =0; i< arr1.length; i++){
            arr1[i]= data.data;
            if (arr1[i]>arr1[i+1]){
                System.out.println("false");
            }
            System.out.println("true");
        }
        return arr1;
    }
    public static boolean isNum1BST (){
        return num1BST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);//geta the root and then the minimum and maximuum values
    }

    public static boolean isInOrderBST (){

        if (validBSTInOrder(root))//calls the validBSTInOrder function
            return true;
        else
            return false;
    }
  public static boolean validBSTInOrder (Nodee root ){
        if (root == null) {//base case
            return true;
        }
      if (!validBSTInOrder(root.left) || item != null && item.data > root.data) {
          return false;
      }//recursively calls the function and as long as it's not, the values gwt added to the l
      // left recursively till null, or if the item is not null and the previous value is greater than the
      // root it returns false because vales on the left side must be smaller than the root.
      item = root;
      //the previous item will recursively be assigned to the root so the values of the inOrder traversals will go
      // in order
      return validBSTInOrder(root.right);

  }

    public static void main(String[] args) {
        //Build a tree
        root = new Nodee(4);
        root.left = new Nodee(2);
        root.right = new Nodee(6);
        root.left.left = new Nodee(1);
        root.left.right = new Nodee(3);
        root.right.left = new Nodee(5);
        root.right.right = new Nodee(7);
       /* if (root == null) {//TEST CASE to check if root is null
            System.out.println("root is null");
        }*/
//        System.out.println("Question 1");
//        if (!isNum1BST()) {//if the tree is in order and is a BST then it returns true if it's not it returns false
//            System.out.println("false");
//        } else {
//            System.out.println("True");
//        }
//        System.out.println("Question 2");
//        if (!isInOrderBST()) {//if the tree is in order and is a BST then it returns true if it's not it returns false
//            System.out.println("false");
//        } else {
//            System.out.println("True");
//        }

        inOrder(root);//prints the tree
    }
}
//Time Complexity = O(n)
//Space Complexity = O(n)


//NODEE CLASS
public class Nodee {
    int data;
    Nodee left, right;

    public Nodee ( int item){
        data = item;
        left = null;
        right = null;
    }
    




