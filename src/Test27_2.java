import java.util.Arrays;

/**
 * 输入 n 个整数，找出其中最小的 k 个数。例如输入 4,5,1， 6,2,7,3,8 这
 * 8 个数字，则最少的 4 个数字是 1,2,3,4.
 */
public class Test27_2 {

    public static void getMinArray(int[] arr,int k){
        if(null == arr || k>arr.length || 0>= k){
            return;
        }
        int[] minArr = Arrays.copyOfRange(arr,0,k);
        //先建立一个k长度的最大堆
        buildMaxHeap(minArr);
        for(int i = k;i<arr.length;i++){
            //遍历剩下的节点，如果比堆顶大，则就当前遍历到的数来讲，一定是堆内的k个数最小
            //如果比堆顶小，则把堆顶剔除，放入该节点后再次建立最大堆，此时被剔除的堆顶是已遍历的数的最大值，
            //即堆内数为已遍历的数的最小的k个数
            if(arr[i] < minArr[0]){
                minArr[0] = arr[i];
                getMaxHeap(minArr,0,minArr.length);
            }
        }
        //只是为了打印好看，没什么特别含义
        Arrays.sort(minArr);
        for(int i : minArr){
            System.out.print(i + " " );
        }
    }

    private static void buildMaxHeap(int[] arr){
        //以0为起点，则length/2 到length 必定为叶子节点，即length/2 + 1必定为最后一个非叶子节点，则从这个节点开始进行
        //最小堆的建立
        for(int i = arr.length/2-1;i>=0;i--){
            getMaxHeap(arr,i,arr.length);
        }
    }
    /**
     * 以i节点为基础，建立它的最大堆
     * @param arr
     * @param i
     * @param len
     */
    private static void getMaxHeap(int[] arr,int i,int len){
        int last = i;
        //左子树节点
        int left = 2*i+1;
        //右子树节点
        int right = left + 1;
        //将last记录为该节点以及左右子节点三者中最大的那个节点的位置
        //left与right为索引，不可以大于或者等于数组长度
        if(left<len && arr[i]<arr[left]){
            last = left;
        }
        if(right<len && arr[last]<arr[right]){
            last = right;
        }
        //如果最大节点不是原节点，则将最大节点与原节点进行交换，交换后，再以该最大节点为基础，重建它的最大堆
        if(last != i){
            swap(arr,last,i);
            getMaxHeap(arr,last,len);
        }
    }
    private static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String args[]){
        int[] array = {3,4,7,1,6,3,0,5};
        getMinArray(array,4);
    }
}
