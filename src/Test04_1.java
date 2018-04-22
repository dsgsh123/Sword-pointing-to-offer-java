import java.util.Stack;

/**
 * 输入一个链表的头结点，从尾到头反过来打印出每个结点的值---循环法
 */
public class Test04_1 {
    public static void reversePrint(MyNode head){

        if(null == head){
            return;
        }
        //利用栈的先进后出特点进行打印
        Stack<MyNode> stack = new Stack<>();

        while (null !=head){
            stack.push(head);
            head = head.next;
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop().data+"  ");
        }
    }
    public static void main(String args[]){
        MyNode node1 = new MyNode(1);
        MyNode node2 = new MyNode(2);
        MyNode node3 = new MyNode(3);
        MyNode node4 = new MyNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        reversePrint(node1);
    }
}
