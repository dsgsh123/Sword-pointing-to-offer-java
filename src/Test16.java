/**
 * 输入两颗二叉树 A 和 B，判断 B 是不是 A 的子结构
 */
public class Test16 {


    public static boolean isChildTree(MyTree a,MyTree b){

        if(null == a && null != b){
            return false;
        }
        if(null == a && null == b){
            return true;
        }
        if(null != a && null == b){
            return true;
        }

        boolean result = false;
        //在此二叉树不考虑存在重复元素
        if(a.data == b.data){
            if(isChildTree(a.leftChildTree,b.leftChildTree)){
                if(isChildTree(a.rightChildTree,b.rightChildTree)){
                    result = true;
                }
            }
        }else{
            if(isChildTree(a.leftChildTree,b) || isChildTree(a.rightChildTree,b)){
                result = true;
            }
        }

        return result;
    }

    public static void main(String args[]){
        MyTree root1=new MyTree(0);
        MyTree node1=new MyTree(1);
        MyTree node2=new MyTree(2);
        MyTree node3=new MyTree(3);
        MyTree node4=new MyTree(4);
        MyTree node5=new MyTree(5);
        MyTree node6=new MyTree(6);
        root1.leftChildTree=node1;
        root1.rightChildTree=node2;
        node1.leftChildTree=node3;
        node1.rightChildTree=node4;
        node4.leftChildTree=node5;
        node4.rightChildTree=node6;

        MyTree root2=new MyTree(0);
        MyTree a=new MyTree(1);
        MyTree b=new MyTree(2);
        root2.leftChildTree=a;
        root2.rightChildTree=b;

        System.out.println(isChildTree(root1, root2));
    }
}
