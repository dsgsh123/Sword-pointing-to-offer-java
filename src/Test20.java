import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是
 * 否为该栈的弹出序列。假设压入栈的所有数字均不相等。例如压栈序列为 1、 2、
 * 3、 4、 5.序列 4、 5、 3、 2、 1 是压栈序列对应的一个弹出序列，但 4、 3、 5、 1、
 * 2 却不是。
 */
public class Test20 {

    public static boolean isPopOrder(int[] pushOrder,int[] popOrder){
        if(null == pushOrder || null == popOrder){
            return false;
        }
        if(pushOrder.length != popOrder.length){
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;

        for(int i = 0;i<pushOrder.length;i++){
            stack.push(pushOrder[i]);
            //如果当前栈顶不等于当前出栈元素，则势必会继续压入
            //如果出栈后的新栈顶不等于下一个出栈序列元素，则势必是继续压栈
            while(!stack.isEmpty() && stack.peek() == popOrder[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        //如果在压栈和出栈结束后，栈中还有元素，则说明出栈序列不符合入栈序列
        return stack.isEmpty();
    }

    public static void main(String args[]){
        int[] pushOrder = {1,2,3,4,5};
        int[] popOrder = {4,5,3,1,2};
        System.out.println(isPopOrder(pushOrder,popOrder));
    }
}
