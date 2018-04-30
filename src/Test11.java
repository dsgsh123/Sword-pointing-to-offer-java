/**
 * 给定单向链表的头指针和一个结点指针，定义一个函数在 O(1)时间删除该结点。
 */
public class Test11 {

    public static MyNode deleteNode(MyNode head,MyNode deleteNode){

        if(null == head || null == deleteNode){
            return null;
        }

        MyNode temp = head.next;
        MyNode pre = head;
        if(head == deleteNode){
            head.next = null;
            head = temp;
            return head;
        }
        while(null != temp && temp != deleteNode){
            pre = temp;
            temp = temp.next;
        }
        if(null == temp) {
            System.out.println("删除失败，不存在该节点");
            return head;
        }
        pre.next = deleteNode.next;
        //断开链表
        deleteNode.next = null;
        deleteNode = null;
        return head;
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

        MyNode newHead =  deleteNode(node1,node2);
        while (null != newHead){
            System.out.print(newHead.data+" ");
            newHead = newHead.next;
        }
    }
}
