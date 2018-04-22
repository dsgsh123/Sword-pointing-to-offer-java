/**
 * 请实现一个函数，把字符串中的每个空格替换成“%20”
 */
public class Test03 {

    public static String replace(String str){
        StringBuffer buffer = new StringBuffer("");

        if(null == str){
            return null;
        }

        char[] chars = str.toCharArray();

        for(int i = 0;i<chars.length;i++){
            //注意此处是char  千万不要用“ ”.equals(),char的比较是单引号并且使用 ==来讲比较
            if(' ' ==chars[i]){
                buffer.append("%20");
            }else{
                buffer.append(chars[i]);
            }
        }
        return buffer.toString();
    }

    public static void main(String args[]){
        System.out.println(replace("_ds d"));
    }
    
}
