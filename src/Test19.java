import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min、 push及pop的时间复杂度都是O(1)
 */
public class Test19 {
    //利用两个栈，只有stack2为空或者压入的值小于stack2的栈顶时，才往stack2中压入
    //stack1用于记录压入的数据，stack1在pop时，只有值与stack2的栈顶相等时，才把stack2的栈顶pop
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public  void push(int n){
        stack1.push(n);
        if(null == stack2){
            stack2.push(n);
        }else{
            if(stack2.peek() >= n){
                stack2.push(n);
            }
        }
    }

    public int pop(){
        int n = stack1.pop();
        if(n == stack2.peek()){
            stack2.pop();
        }
        return n;
    }

    public int peek(){
        return stack1.peek();
    }

    public int min(){
        return stack2.peek();
    }

    public static void main(String args[]){
        Test19 test19 = new Test19();
        test19.push(3);
        test19.push(4);
        System.out.println(test19.min());
        test19.push(2);
        System.out.println(test19.pop()+" min:"+test19.min());
        test19.push(5);
        test19.push(1);
        System.out.println(test19.min());


    }
}
