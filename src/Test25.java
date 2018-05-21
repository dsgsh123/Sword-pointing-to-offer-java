import java.util.*;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 */
public class Test25 {
    public static void printAllSort(String str){
        char[] charArrays = str.toCharArray();
        Set<String> resultSet = new TreeSet<>();
        printAllSort(charArrays,resultSet,0,charArrays.length);

        System.out.println(resultSet.toString());
    }

    /**
     * 例如字符串为abc，则总排序方式为 a在首位时，剩余字符的排列方式+b在首位时，剩余字符的排列方式+c在首位时，剩余字符的排列方式
     * 以此类推，即每位字符都作为一次首位的排列方式的和为全部排列，剩余字符又可以进行递归，使用TreeSet进行排序和去重
     * @param chars
     * @param resultSet
     * @param start
     * @param len
     */
    private  static void printAllSort(char[] chars, Set<String> resultSet,int start,int len){
        if(start == len-1){
            //start为当前子数组的头位置，当头位置等于原数组的长度-1时，说明已经进行完了一次排序，则记录set并结束
            resultSet.add(String.valueOf(chars));
            return;
        }
        for(int i = start;i<len;i++){
            swap(chars,start,i);
            printAllSort(chars,resultSet,start+1,len);
            swap(chars,start,i);
        }

    }
    private static void swap(char[] chars,int a ,int b){
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
    public static void main(String args[]){
        String str = "abcd";
        printAllSort(str);
    }
}
