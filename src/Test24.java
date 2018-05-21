/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求
 * 不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Test24 {
    public static MyTree convert(MyTree root){

        MyTree result = null;
        result = convert(root,result);
        while(null != result.leftChildTree){
            result = result.leftChildTree;
        }
        return result;
    }

    /**
     * 思路主要是利用中序遍历，使last节点作为root的上一个遍历节点，（相当于root与last错一位遍历，就可以进行指向了）
     * @param root
     * @param last
     */
    public static MyTree convert(MyTree root,MyTree last){
        if(null != root.leftChildTree) {
           last = convert(root.leftChildTree, last);
        }
        if(null != last){
            //建立双向链表
            root.leftChildTree = last;
            last.rightChildTree =  root;
        }
        //移动到下一位
        last = root;
        if(null != root.rightChildTree){
           last = convert(root.rightChildTree,last);
        }
        return last;
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
        MyTree tree5 = new MyTree(9);
        MyTree tree6 = new MyTree(11);
        tree2.leftChildTree = tree5;
        tree2.rightChildTree = tree6;

        MyTree converted = convert(root);

        while (null != converted){
            System.out.print(converted.data + " ");
            converted = converted.rightChildTree;
        }
    }
}
