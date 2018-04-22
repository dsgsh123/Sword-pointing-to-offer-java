/**
 * 一个二维数组，每一行从左到右递增，每一列从上到下递增．输
 * 入一个二维数组和一个整数，判断数组中是否含有整数。
 */
public class Test02 {

    public boolean find(int[][] array,int num ){

        if(null == array ){
            return false;
        }
        //行数
        int row = 0;
        //列数减一
        int column = array[0].length-1;
        //从最右上角开始，等于则返回true，num大则row+1，num小则column-1
        while(row < array.length && column >=0){
            if(array[row][column] == num){
                return true;
            }else if(array[row][column] < num){
                row++;
            }else {
                column--;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] array = new int[4][4];
        array[0][0] = 0;
        array[0][1] = 1;
        array[0][2] = 2;
        array[0][3] = 3;

        array[1][0] = 4;
        array[1][1] = 5;
        array[1][2] = 6;
        array[1][3] = 7;

        array[2][0] = 8;
        array[2][1] = 9;
        array[2][2] = 10;
        array[2][3] = 11;

        array[3][0] = 12;
        array[3][1] = 13;
        array[3][2] = 14;
        array[3][3] = 15;
        Test02 test02 = new Test02();

        System.out.print(test02.find(array,16));
    }


    
}
