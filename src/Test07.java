/**
 * 写一个函数，输入 n，求斐波那契数列的第 n 项
 */
public class Test07 {

    public static int getFsNum(int n) throws Exception{
        if(0 == n){
            throw  new Exception("不存在第零项");
        }
        if(1 == n || 2 == n){
            return 1;
        }
        return getFsNum(n-1)+getFsNum(n-2);
    }

    public static void main(String args[]) throws Exception{
        System.out.println(getFsNum(0)+"");
    }
}
