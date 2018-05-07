/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像
 */
public class Test17 {

    public static MyTree mirrorTree(MyTree root){

        root = mirrorTreeWithParent(null,root);

        return root;
    }

    public static MyTree mirrorTreeWithParent(MyTree parent,MyTree node){

        if(null == node && null == parent) {
            return null;
        }
        if(null == node && null != parent){
            return null;
        }
        if(null != node.leftChildTree || null != node.rightChildTree){
            MyTree temp = node.leftChildTree;
            node.leftChildTree = mirrorTreeWithParent(node,node.rightChildTree);
            node.rightChildTree = mirrorTreeWithParent(node,temp);
        }
        return node;
    }

    //前序遍历
    public static void printTree(MyTree root){
        if(null == root){
            return;
        }
        System.out.print(root.data + "  ");
        printTree(root.leftChildTree);
        printTree(root.rightChildTree);
    }

    public static void main(String args[]){
        MyTree root1=new MyTree(8);
        MyTree node1=new MyTree(8);
        MyTree node2=new MyTree(7);
        MyTree node3=new MyTree(9);
        MyTree node4=new MyTree(2);
        MyTree node5=new MyTree(4);
        MyTree node6=new MyTree(7);
        root1.leftChildTree=node1;
        root1.rightChildTree=node2;
        node1.leftChildTree=node3;
        node1.rightChildTree=node4;
        node4.leftChildTree=node5;
        node4.rightChildTree=node6;
        MyTree newTree = mirrorTree(root1);

        printTree(newTree);
    }
}
