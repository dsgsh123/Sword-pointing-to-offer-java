import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 输入二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设前
 * 序遍历和中序遍历结果中都不包含重复的数字，例如输入的前序遍历序列
 * {1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}重建出如图所示的二叉
 * 树。
 */
public class Test05 {

    public static MyTree rebuildTree(int[] pre,int[] in) throws Exception{
        if(null == pre || null == in){
            return null;
        }
        if(pre.length != in.length){
            throw new Exception("长度不一致");
        }

        MyTree root = new MyTree(0);
        //利用递归和数组复制，原则是，前序遍历的第一个值是根节点，对应到中序遍历中的i位置，中序遍历中，i左侧为左子树，右侧为右子树
        for(int i = 0;i<pre.length;i++){
            if(in[i] == pre[0]){
                root.data = in[i];
                System.out.print(root.data+"  ");
                root.leftChildTree = rebuildTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.rightChildTree = rebuildTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }

        return root;
    }

    public static void main(String args[]) throws Exception{
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};

        rebuildTree(pre,in);

    }
}
