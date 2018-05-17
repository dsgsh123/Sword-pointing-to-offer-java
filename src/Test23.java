import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Test23 {

    public static void getPath(MyTree root,int n){
        if(null == root || root.data > n){
            return;
        }
        int currentNum = 0;
        Stack<Integer> stack = new Stack<>();
        getPath(root,n,currentNum,stack);
    }

    public static void getPath(MyTree root,int sum,int currentNum,Stack<Integer> stack){
        currentNum += root.data;
        //将当前值入栈
        stack.push(root.data);

        if(null == root.leftChildTree && null == root.rightChildTree){
            //在当前节点为叶子节点的情况下，如果此时刚好和与currentNum一致，则为一条路径
            if(currentNum == sum){
                for(int m:stack){
                    System.out.print(m + " ");
                }
                System.out.println();
            }
        }
        //左子节点不为空的时候，递归判断左子树中是否存在路径
        if(null != root.leftChildTree){
            getPath(root.leftChildTree,sum,currentNum,stack);
        }
        //右子节点不为空的时候，递归判断右子树中是否存在路径
        if(null != root.rightChildTree){
            getPath(root.rightChildTree,sum,currentNum,stack);
        }
        //执行完毕后，需要将当前节点值出栈，方便返回上一节点进行其他路径的判断和打印
        stack.pop();
    }
    public static void main(String args[]){

        MyTree root = new MyTree(8);
        MyTree tree1 = new MyTree(6);
        MyTree tree2 = new MyTree(10);
        root.leftChildTree = tree1;
        root.rightChildTree = tree2;
        MyTree tree3 = new MyTree(5);
        MyTree tree4 = new MyTree(7);
        tree1.leftChildTree = tree3;
        tree1.rightChildTree = tree4;
        MyTree tree5 = new MyTree(1);
        MyTree tree6 = new MyTree(11);
        tree2.leftChildTree = tree5;
        tree2.rightChildTree = tree6;

        getPath(root,19);
    }
}
