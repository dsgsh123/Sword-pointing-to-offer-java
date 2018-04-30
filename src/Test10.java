/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位进制数。比如输入 3，则打
 * 印出 1、 2、 3 一直到 999.
 */

public class Test10 {
    //注意，我用的这种写法在强转为int时，可能会出现溢出问题，不建议这么写
    public static void print(int n )throws Exception{
        if(0 == n){
            throw  new Exception("不存在0位数");
        }
        int digits = 0;
        for(int i = 0;i<n;i++){

            digits = (int)Math.pow(10,i) + digits;
        }

        int max = 9 * digits;

        while(max!=0){
            System.out.print(max+" ");
            max--;
        }

    }

    public static void main(String args[]) throws Exception{
        print(2);
    }
}
