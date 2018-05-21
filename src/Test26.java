import java.util.*;

/**
 * 数组中有一个数字出现次数超过数组长度的一半，请找出这个数字。例如
 * 输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。 2出现的次数超过数组长度的
 * 一半，因此输出2.
 */
public class Test26 {

    public static void printMoreThanHalfOfTheArrayLe(int[] array){
        if(null == array){
            return;
        }
        int len = array.length;

        Map<Integer,Integer> map = new HashMap<>();
        //用数组中的值作为key，存入map，value每出现一次就加一
        for(int i = 0;i<len;i++){
            int n = array[i];
            if(null == map.get(n)){
                map.put(n,1);
            }else {
                int k = map.get(n);
                k++;
                map.put(n,k);
            }
        }
        Iterator iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            int k = (int)iterator.next();
            int count = map.get(k);
            if(count>len/2){
                System.out.println(k);
                break;
            }
        }
    }
    public static void main(String args[]){
       int[] array = {6,6,4,2,6,5,6,6,6,1};
       printMoreThanHalfOfTheArrayLe(array);
    }
}
