/**
 *定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 */
public class Test14 {

    public static MyNode reverseList(MyNode head){
        if(null == head){
            System.out.println("传入链表为空！");
            return null;
        }

        MyNode pre = null;
        MyNode temp = head;
        MyNode next = head.next;

        while (null != next){
            temp.next = pre;
            pre = temp;
            temp = next;
            next = temp.next;
            temp.next = pre;
        }
        return temp;
    }

    public static void main(String args[]){
        MyNode node1 = new MyNode(1);
        MyNode node2 = new MyNode(2);
        MyNode node3 = new MyNode(3);
        MyNode node4 = new MyNode(4);
        MyNode node5 = new MyNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        MyNode newHead = reverseList(node1);

        while (null != newHead){
            System.out.print(newHead.data+" ");
            newHead = newHead.next;
        }

    }
}
