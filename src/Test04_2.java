/**
 * 输入一个链表的头结点，从尾到头反过来打印出每个结点的值---递归法
 */
public class Test04_2 {
    public static void reversePrint2(MyNode head){

        if(null == head){
            return;
        }

        if(null != head.next) {
            reversePrint2(head.next);
        }
        System.out.print(head.data+"  ");
    }
    public static void main(String args[]){
        MyNode node1 = new MyNode(1);
        MyNode node2 = new MyNode(2);
        MyNode node3 = new MyNode(3);
        MyNode node4 = new MyNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        reversePrint2(node1);
    }
}
