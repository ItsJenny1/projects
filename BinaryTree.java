import java.util.ArrayDeque;

public class BinaryTree1 {

    public static Nodee root;//Gets variables from the Nodee class

public static void Level (Nodee data){//DOes the actual Level Traversal

    ArrayDeque<Nodee> inputQue = new ArrayDeque<>();//Makes an Array queue

    inputQue.push(data);//inputs the value of the tree
    System.out.println("After Traversal");
    if (!inputQue.isEmpty()) {//works as long as the queue is not empty TEST CASE
        do {
            Nodee current = inputQue.remove();//points to the current root node of the tree and deques the quue
            // and stores the value in the 'current' variable
            System.out.print(current.data + " ");
            //then the right
            //it checks if right is null, if its not it offers the position at the right of the tree to the queue
            //it checks if right is null, if its not it offers the position at the right of the tree to the queue
            if (current.left != null) {//if left is not empty the position at the left of the tree is offered to the queue
                inputQue.offer(current.left);
            } else {//check if left is empty if it is,
            }
            if (current.right == null) {
            } else {//it checks if right is null, if its not it offers the position at the right of the tree to the queue
                inputQue.offer(current.right);
            }

        } while (!inputQue.isEmpty());
    }
    /*if (inputQue.isEmpty()){//TEST CASE to check if inputQue is empty
        System.out.println("Input Que is empty");

    }*/
}

    public static void main(String[] args) {

//Makes the binary tree
        root = new Nodee(4);
        root.left = new Nodee(2);
        root.right = new Nodee(6);
        root.left.left = new Nodee(1);
        root.left.right = new Nodee(3);
        root.right.left = new Nodee(5);
        root.right.right = new Nodee(7);
        // System.out.println(root);
        Level(root);//Calls the level function and uses nodde root as it parameter.


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
    



