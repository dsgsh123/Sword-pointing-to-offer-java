/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class Test18 {

    public static void printClockwisely(int[][] matrix){
        int row = matrix.length;
        int column = matrix[0].length;

        //确定圈数  取出行列较小的作为计算标准  规律： 1、2  一圈  3、4  两圈  5、6  三圈...
        //即行列较小的那个数所最接近的大于等于他自身的偶数除以2，就得到矩阵的圈数
        int min = getMin(row,column);
        int rounds = getRounds(min);
        int maxColumn = 0;
        int maxRow = 0;

        for(int i = 0;i<rounds;i++){
            maxColumn = column-1-i;
            maxRow = row-1-i;
            //一竖排为一圈
            if(i == maxColumn){
                for(int m = i;m<=maxRow;m++){
                    System.out.print(matrix[m][i]+" ");
                }
                continue;
            }
            //一横排为1圈
            if(i == maxRow){
                for(int m = i;m<=maxColumn;m++){
                    System.out.print(matrix[i][m]+" ");
                }
                continue;
            }
            for(int m = i;m<=maxColumn;m++){
                System.out.print(matrix[i][m]+" ");
            }
            for(int m = i+1;m<=maxRow;m++){
                System.out.print(matrix[m][maxColumn] + " ");
            }
            for(int m = maxColumn - 1;m>=i;m-- ){
                System.out.print(matrix[maxRow][m] + " ");
            }
            for(int m = maxRow - 1;m>i;m--){
                System.out.print(matrix[m][i] + " ");
            }
        }

    }

    //获取圈数
    private static int getRounds(int n){
        int rounds = 0;
        if(0 == n%2){
            rounds = n/2;
        }else {
            rounds = (n+1)/2;
        }
        return rounds;
    }

    private static int getMin(int a,int b){
        if(a >= b){
            return b;
        }
        return a;
    }

    public static void main(String args[]){
        int[][] matrix = new int[4][3];
        matrix[0][0] = 0;
        matrix[0][1] = 1;
        matrix[0][2] = 2;
        matrix[0][3] = 3;

        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[1][3] = 7;

        matrix[2][0] = 8;
        matrix[2][1] = 9;
        matrix[2][2] = 10;
        matrix[2][3] = 11;

        matrix[3][0] = 12;
        matrix[3][1] = 13;
        matrix[3][2] = 14;
        matrix[3][3] = 15;

        printClockwisely(matrix);
    }
}
