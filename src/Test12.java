/**
 * 输入一个整数数组，实现一个函数来调整该函数数组中数字的顺序，使得
 * 所有奇数位于数组的前半部分，所有的偶数位于数组的后半部分。
 */
public class Test12 {

    public static void adjustOrder(int[] arr){
        if(null == arr || 1 == arr.length){
            return;
        }

        int h = 0;
        int l = arr.length - 1;

        //类似快排
        while (h!=l){
            while(l>h && !isOdd(arr[l])){
                l--;
            }
            while(l>h && isOdd(arr[h])){
                h++;
            }
            if(l>h) {
                swap(arr, h, l);
            }
        }

    }
    //交换
    public static void swap(int[] arr,int n,int m ){
        int temp = arr[n];
        arr[n] = arr[m];
        arr[m] = temp;
    }

    //判断是否为奇数
    private static boolean isOdd(int n){
        if(0 == n%2){
            return false;
        }else {
            return true;
        }
    }

    public static void main(String args[]){
        int[] arr = {4,2,3,5,1,3,7,9,0,8};

        adjustOrder(arr);

        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }

    }
}
