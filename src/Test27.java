import java.util.Arrays;

/**
 * 输入 n 个整数，找出其中最小的 k 个数。例如输入 4,5,1， 6,2,7,3,8 这
 * 8 个数字，则最少的 4 个数字是 1,2,3,4.
 */
public class Test27 {
    public static void getMinArray(int[] array,int k ){

        if(array.length<k || null == array || 0 >= k){
            return;
        }
        Arrays.sort(array);
        int[] sortArray = Arrays.copyOfRange(array,0,k);
        for(int i = 0;i<sortArray.length;i++){
            System.out.print(sortArray[i]+" ");
        }
    }
    public static void main(String args[]){
        int[] array = {4,5,1,6,2,7,3,8};
        getMinArray(array,4);
    }
}
