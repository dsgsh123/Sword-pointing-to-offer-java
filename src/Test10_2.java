/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位进制数。比如输入 3，则打
 * 印出 1、 2、 3 一直到 999.
 */

public class Test10_2 {

    public static void printToMax(int n ) throws Exception{

        if( 0 == n){
            throw  new Exception("不存在0位数");
        }

        StringBuffer sb = new StringBuffer("");

        for(int i = 0;i<n;i++){
            sb.append("9");
        }
        int max = Integer.parseInt(sb.toString());
        int k = 1;
        while (k<=max){
            System.out.print(k+" ");
            k++;
        }
    }

    public static void main(String args[]) throws Exception{
        printToMax(1);
    }
}
