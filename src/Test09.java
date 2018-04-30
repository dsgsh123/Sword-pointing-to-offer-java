/**
 * 实现函数 double Power（double base， int exponent），求 base 的 exponent
 * 次方。不得使用库函数，同时不需要考虑大数问题。
 */
public class Test09 {

    public static double power(double base, int exponent) throws Exception{

        if(0>exponent && equal(base,0.0)){
            throw new Exception("不存在0的负数次幂");
        }
        double result = 1.0;

        if(exponent>0){
            result = powerWithExponent(base,exponent);
        }
        //exponent要取倒数
        if(exponent<0){
            //这个地方一定要用1.0而不能用1
            result = 1.0/powerWithExponent(base,-exponent);
        }
        return result;
    }

    /**
     * @param base
     * @param exponent 始终大于等于 0
     * @return
     */
    private static double powerWithExponent(double base, int exponent){

        if(0 == exponent){
            return 1;
        }
        if(1 == exponent){
            return base;
        }
        double result = 1.0;

        while (exponent != 0){
            result = result * base;
            exponent--;
        }
        return result;
    }

    /**
     * 比较两个浮点数是否相同，由于存在精度差，只需要其差值的绝对值在一个很小的范围内即可，绝不能直接用 == 或者 != 来比较
     * @param m
     * @param n
     * @return
     */
    private static boolean equal(double m,double n){
        double dValue = m - n;
        //差值如0.0000001，这个差值越小，精度越高
        if(-0.0000001< dValue && dValue <0.0000001 ){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String args[]) throws Exception{
        System.out.println(power(0.0,-3));
    }
}
