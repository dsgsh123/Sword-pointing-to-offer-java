/**
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如
 * 把 9 表示成二进制是 1001；有 2 位是 1，因此如果输入 9，函数输出 2.
 */
public class Test08 {

    public static int numOfOne(int n){
        int num = 0;
        while( 0 != n){
            // n & (n-1)会将二进制最后一位的 1 变成 0 ，从而每执行一次，就说明二进制中有一个1存在
            n = n &( n-1);
            num++;
        }
        return num;
    }

    public static void main(String args[]){
        System.out.println(numOfOne(9));
    }
}
