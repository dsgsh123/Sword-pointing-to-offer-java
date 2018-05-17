import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。是则返回true，否则返回false。
 */
public class Test22 {
    public static boolean isPostorder(int[] array){
        //首先要确定，二叉搜索树的特点在于，左子树均小于根节点，右子树均大于右子树
        if(null == array || array.length == 0){
            return false;
        }
        if(array.length == 1){
            return true;
        }
        //数组的最后一位为根节点，从开始到比他小的为止为左子树，剩下的为右子树
        int end = array.length - 1;
        int root = array[end];
        int cur = 0;

        for(int i = 0;i<array.length-1;i++){
            if(array[i]>root){
                cur = i;
                break;
            }
        }
        for(int i = cur + 1;i<array.length -1;i++){
            if(array[i]<root){
                return false;
            }
        }
        boolean left = isPostorder(Arrays.copyOfRange(array,0,cur));
        boolean right = isPostorder(Arrays.copyOfRange(array,cur,array.length-1));
        return (left&&right);
    }

    public static void main(String args[]){
        int[] array  = {5,7,6,9,11,10,8};
        //int[] array = {5,4};
        System.out.println(isPostorder(array));
    }
}
