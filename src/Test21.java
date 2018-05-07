import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上往下打印二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
 */
public class Test21 {

    public static void printTopToBottom(MyTree root){
        if(null == root){
            return;
        }
        //创建一个队列，先进先出
        LinkedList<MyTree> linkedList = new LinkedList<>();
        linkedList.add(root);
        //把首位取出后，放入左节点和右节点，这样就可以实现一排一排的按从左到右的顺序加入队列中
        while (!linkedList.isEmpty()){
            MyTree treeNode = linkedList.poll();
            System.out.print(treeNode.data+" ");
            if(null != treeNode.leftChildTree){
                linkedList.add(treeNode.leftChildTree);
            }
            if(null != treeNode.rightChildTree){
                linkedList.add(treeNode.rightChildTree);
            }
        }
    }

    public static void main(String args[]){
        MyTree root = new MyTree(0);

        MyTree node1 = new MyTree(1);
        MyTree node2 = new MyTree(2);
        root.leftChildTree = node1;
        root.rightChildTree = node2;

        MyTree node3 = new MyTree(3);
        MyTree node4 = new MyTree(4);
        node1.leftChildTree = node3;
        node1.rightChildTree = node4;

        MyTree node5 = new MyTree(5);
        MyTree node6 = new MyTree(6);
        node2.leftChildTree = node5;
        node2.rightChildTree = node6;

        printTopToBottom(root);
    }
}
