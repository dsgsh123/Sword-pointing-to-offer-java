import java.util.Stack;

/**
 * 用两个栈实现一个队列，实现对了的两个函数 appendTail 和
 * deleteHead，分别完成在队列尾插入结点和在队列头部删除结点的功能。
 */
public class Test06<T> {

    private Stack<T> stack1 = new Stack<T>();
    private Stack<T> stack2 = new Stack<T>();

    public void appendTail(T element){
        stack1.push(element);
    }

    public T deleteHead(){
        //删除时，首先判断stack2中有没有元素，如果有，则stack2.pop()即可，若stack2为空，则先把stack1中的元素pop放入stack2
        //这样，stack2的顺序就相当于队列的先进先出
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            System.out.println("队列中已经没有元素");
        }
        T element = stack2.pop();
        System.out.println(element);
        return element;
    }


    public static void main(String args[]){
        Test06<Integer> test06 = new Test06<>();
        test06.appendTail(1);
        test06.deleteHead();

        test06.appendTail(2);

        test06.appendTail(3);
        test06.deleteHead();
        test06.appendTail(4);
        test06.deleteHead();

    }
}
